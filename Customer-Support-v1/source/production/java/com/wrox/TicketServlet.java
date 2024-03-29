package com.wrox;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.LinkedHashMap;
import java.util.Map;

@WebServlet(
        name = "ticketServlet",
        urlPatterns = {"/tickets"},
        loadOnStartup = 1
)
@MultipartConfig(
        fileSizeThreshold = 5_242_880, //5MB
        maxFileSize = 20_971_520L, //20MB
        maxRequestSize = 41_943_040L //40MB
)
public class TicketServlet extends HttpServlet
{
    private volatile int TICKET_ID_SEQUENCE = 1;

    private Map<Integer, Ticket> ticketDatabase = new LinkedHashMap<>();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        String action = request.getParameter("action");
        if(action == null)
            action = "list";
        switch(action)
        {
            case "create":
                this.showTicketForm(response);
                break;
            case "view":
                this.viewTicket(request, response);
                break;
            case "download":
                this.downloadAttachment(request, response);
                break;
            case "list":
            default:
            	 this.repost(request, response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        String action = request.getParameter("action");
        if(action == null)
            action = "list";
        switch(action)
        {
            case "create":
                this.createTicket(request, response);
                break;
            case "download":
            default:
               this.repost(request, response);
                break;
        }
    }

    private void showTicketForm(HttpServletResponse response)
            throws ServletException, IOException
    {
    	response.sendRedirect("NewTicket.jsp");//sends redirect to the new ticket form in NewTicket.JSP
    	/*
    	 * old code is found here
        PrintWriter writer = this.writeHeader(response);

        writer.append("<h2>Create a Ticket</h2>\r\n");
        writer.append("<form method=\"POST\" action=\"tickets\" ")
              .append("enctype=\"multipart/form-data\">\r\n");
        writer.append("<input type=\"hidden\" name=\"action\" ")
              .append("value=\"create\"/>\r\n");
        writer.append("Your Name<br/>\r\n");
        writer.append("<input type=\"text\" name=\"customerName\"/><br/><br/>\r\n");
        writer.append("Subject<br/>\r\n");
        writer.append("<input type=\"text\" name=\"subject\"/><br/><br/>\r\n");
        writer.append("Body<br/>\r\n");
        writer.append("<textarea name=\"body\" rows=\"5\" cols=\"30\">")
              .append("</textarea><br/><br/>\r\n");
        writer.append("<b>Attachments</b><br/>\r\n");
        writer.append("<input type=\"file\" name=\"file1\"/><br/><br/>\r\n");
        writer.append("<input type=\"submit\" value=\"Submit\"/>\r\n");
        writer.append("</form>\r\n");

        this.writeFooter(writer);
        END OF ALL OLD CODE*/
    }
    
   
    private void viewTicket(HttpServletRequest request,
                            HttpServletResponse response)
            throws ServletException, IOException
    {
        String idString = request.getParameter("ticketId");
        Ticket ticket = this.getTicket(idString, response);
        
        if(ticket == null)
            return;
        
        String customerName = ticket.getCustomerName();//Storing custommer name for ticket in this variable for later use
        String subject = ticket.getSubject();//storing subject in this variable for later use
        String body = ticket.getBody();//storing body in this variable for later use
        RequestDispatcher rd= request.getRequestDispatcher("TicketView.jsp");//New request dispatcher is called
		request.setAttribute("idString", idString);//sets the information that needs to be sent to request
		request.setAttribute("customerName", customerName);//variable customerName is stored to forward
		request.setAttribute("subject", subject);//subject variable is stored for forward
		request.setAttribute("body", body);//body variable is stored for forward
		
		/*OLD CODE STARTS HERE
        PrintWriter writer = this.writeHeader(response);

        writer.append("<h2>Ticket #").append(idString)
              .append(": ").append(ticket.getSubject()).append("</h2>\r\n");
        writer.append("<i>Customer Name - ").append(ticket.getCustomerName())
              .append("</i><br/><br/>\r\n");
        writer.append(ticket.getBody()).append("<br/><br/>\r\n");
        	
		 OLD CODE ENDS HERE*/
        if(ticket.getNumberOfAttachments() > 0)
        {
        	 
        	
        	request.setAttribute("attachments", ticket.getAttachments());//attachments are stored for forward
        	
        }
        	/*OLD CODE BEGINS HERE
            writer.append("Attachments: ");
            int i = 0;
            for(Attachment attachment : ticket.getAttachments())
            {
                if(i++ > 0)
                    writer.append(", ");
                writer.append("<a href=\"tickets?action=download&ticketId=")
                      .append(idString).append("&attachment=")
                      .append(attachment.getName()).append("\">")
                      .append(attachment.getName()).append("</a>");
            }
            writer.append("<br/><br/>\r\n");
        }
		OLD CODE ENDS HERE*/
        
        rd.forward(request, response);//forwards the information to the JPS TicketView.jsp
        
        // OLD CODE HERE writer.append("<a href=\"tickets\">Return to list tickets</a>\r\n");

        //OLD CODE HERE this.writeFooter(writer);
    }
    
    //Repost method to post to the JSP
    private void repost(HttpServletRequest request, HttpServletResponse response)
    				throws ServletException, IOException
    							{
    	
    	RequestDispatcher rd= request.getRequestDispatcher("TicketList.jsp");//New request dispatcher is called
		request.setAttribute("data", this.ticketDatabase);//sets the information that needs to be sent to request
		rd.forward(request, response);//forwards the information to the JPS TicketList.jsp
    	
    }

    private void downloadAttachment(HttpServletRequest request,
                                    HttpServletResponse response)
            throws ServletException, IOException
    {
        String idString = request.getParameter("ticketId");
        Ticket ticket = this.getTicket(idString, response);
        if(ticket == null)
            return;

        String name = request.getParameter("attachment");
        if(name == null)
        {
            response.sendRedirect("tickets?action=view&ticketId=" + idString);
            return;
        }

        Attachment attachment = ticket.getAttachment(name);
        if(attachment == null)
        {
            response.sendRedirect("tickets?action=view&ticketId=" + idString);
            return;
        }

        response.setHeader("Content-Disposition",
                "attachment; filename=" + attachment.getName());
        response.setContentType("application/octet-stream");

        ServletOutputStream stream = response.getOutputStream();
        stream.write(attachment.getContents());
    }

    /*old code
    private void listTickets(HttpServletResponse response, HttpServletRequest request)
            throws ServletException, IOException
    {
    	
    	//ALL OF THIS IS OLD CODE AND NOT BEING USED CURRENTLY
    	//if(this.ticketDatabase.size() == 0) {
    	
    		//response.sendRedirect("TicketList.jsp");
    	//}
        
        PrintWriter writer = this.writeHeader(response);
        
        writer.append("<h2>Tickets</h2>\r\n");
        writer.append("<a href=\"tickets?action=create\">Create Ticket")
              .append("</a><br/><br/>\r\n");
        
        RequestDispatcher rd= request.getRequestDispatcher("TicketList.jsp");
        
        request.setAttribute("data", this.ticketDatabase);
        
        if(this.ticketDatabase.size() == 0) {
        	
           writer.append("<i>There are no tickets in the system.</i>\r\n");
        } else
        {
        	
        	request.setAttribute("data", this.ticketDatabase);
            for(int id : this.ticketDatabase.keySet())
            {
                String idString = Integer.toString(id);
                Ticket ticket = this.ticketDatabase.get(id);
                
               
                
                writer.append("Ticket #").append(idString)
                      .append(": <a href=\"tickets?action=view&ticketId=")
                      .append(idString).append("\">").append(ticket.getSubject())
                      .append("</a> (customer: ").append(ticket.getCustomerName())
                      .append(")<br/>\r\n");
            }
        }
        	
        rd.forward(request, response);
        this.writeFooter(writer);
        
        
    }
    END OF ALL OLD CODE
        */

    private void createTicket(HttpServletRequest request,
                              HttpServletResponse response)
            throws ServletException, IOException
    {
    	
         
        Ticket ticket = new Ticket();
        ticket.setCustomerName(request.getParameter("customerName"));
        ticket.setSubject(request.getParameter("subject"));
        ticket.setBody(request.getParameter("body"));

        Part filePart = request.getPart("file1");
        if(filePart != null && filePart.getSize() > 0)
        {
            Attachment attachment = this.processAttachment(filePart);
            if(attachment != null)
                ticket.addAttachment(attachment);
        }

        int id;
        synchronized(this)
        {
            id = this.TICKET_ID_SEQUENCE++;
            this.ticketDatabase.put(id, ticket);
        }
        
        response.sendRedirect("tickets?action=view&ticketId=" + id);
       
        
    }

    private Attachment processAttachment(Part filePart)
            throws IOException
    {
        InputStream inputStream = filePart.getInputStream();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        int read;
        final byte[] bytes = new byte[1024];

        while((read = inputStream.read(bytes)) != -1)
        {
            outputStream.write(bytes, 0, read);
        }

        Attachment attachment = new Attachment();
        attachment.setName(filePart.getSubmittedFileName());
        attachment.setContents(outputStream.toByteArray());

        return attachment;
    }

    private Ticket getTicket(String idString, HttpServletResponse response)
            throws ServletException, IOException
    {
        if(idString == null || idString.length() == 0)
        {
            response.sendRedirect("tickets");
            return null;
        }

        try
        {
            Ticket ticket = this.ticketDatabase.get(Integer.parseInt(idString));
            if(ticket == null)
            {
                response.sendRedirect("tickets");
                return null;
            }
            return ticket;
        }
        catch(Exception e)
        {
            response.sendRedirect("tickets");
            return null;
        }
    }

    private PrintWriter writeHeader(HttpServletResponse response)
            throws ServletException, IOException
    {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        PrintWriter writer = response.getWriter();
        writer.append("<!DOCTYPE html>\r\n")
              .append("<html>\r\n")
              .append("    <head>\r\n")
              .append("        <title>Customer Support</title>\r\n")
              .append("    </head>\r\n")
              .append("    <body>\r\n");

        return writer;
    }

    private void writeFooter(PrintWriter writer)
    {
        writer.append("    </body>\r\n").append("</html>\r\n");
    }
}
