package com.snhu.FlightBookingApp;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;


@MultipartConfig(
        fileSizeThreshold = 5_242_880, //5MB
        maxFileSize = 20_971_520L, //20MB
        maxRequestSize = 41_943_040L //40MB
)
/**
 * Servlet implementation class BookingServlet
 */
public class BookingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		//this.test(request, response);
		
		//switch case works really well with this type of application
		String action = request.getParameter("action");
		if (action == null) 
			action = "wait";
			switch(action)
			{
			
			case "create":
			this.createFlight(request, response);//creates the flight
				break;
			case "support":
			this.createSupport(request, response);//creates the support ticket
				break;
			case "wait":
			default:
				this.date(request, response);//default starting page with date
				break;
			
			}	
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String action = request.getParameter("action");
		if (action == null) 
			action = "wait";
			switch(action)
			{
			case "create":
				this.createFlight(request, response);
				break;
			case "support":
				this.createSupport(request, response);//creates the support ticket
				break;
			case "wait":
			default:
				this.date(request, response);//default starting page with date
				break;
			
			}	
	}
	/* used as a test bed for new methods
	private void test(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = "Rich Caceres";
		RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
		request.setAttribute("names", name);
		rd.forward(request, response);
		
	} ends of test code*/
	
	//Method to return the current date to the user
	private void date(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy"); //used to format the date
		Date date = new Date(); //creates a date object
		
		
		RequestDispatcher rd = request.getRequestDispatcher("index.jsp");//setting requester to index.jsp
		request.setAttribute("date", formatter.format(date));//setting data that needs to be sent to jsp
		rd.forward(request, response);//sending the data to the jsp
		
	}
	
	private void createFlight(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Itenerary itenerary = new Itenerary();
		itenerary.Itenerary();
		
		itenerary.setTravelers(request.getParameter("travelers"));//requesting parameters for travelers
		itenerary.setStartLoc(request.getParameter("startLoc"));//assigning starting location
		itenerary.setEndLoc(request.getParameter("endLoc"));//assigning end location
		itenerary.setStartDate(request.getParameter("startDate"));//assigning start date
		itenerary.setEndDate(request.getParameter("endDate"));//assigning end date
		
		System.out.print(itenerary.getTravelers());
		
		RequestDispatcher rd = request.getRequestDispatcher("BookedFlight.jsp");//setting requester to index.jsp
		request.setAttribute("traveler", itenerary.getTravelers());//setting data that needs to be sent to jsp
		request.setAttribute("startLoc", itenerary.getStartLoc());//setting data that needs to be sent to jsp
		request.setAttribute("endLoc", itenerary.getEndLoc());//setting data that needs to be sent to jsp
		request.setAttribute("startDate", itenerary.getStartDate());//setting data that needs to be sent to jsp
		request.setAttribute("endDate", itenerary.getEndDate());//setting data that needs to be sent to jsp
		
		rd.forward(request, response);//sending the data to the jsp
		
		
	}
	
	private void createSupport(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		SupportTicket support = new SupportTicket();
		support.supportInit();
		 
		 support.setName(request.getParameter("name"));//storing name in this variable for later use
	     support.setSubject(request.getParameter("subject"));//storing subject in this variable for later use
	     support.setBody(request.getParameter("body"));//storing body in this variable for later use
	     Part filePart = request.getPart("file1");//grabbing the file
	     
	     
	     
	     
	     
	    
	     if(filePart != null && filePart.getSize() > 0) {
	    	 
	    	 Attchment attachment = this.processAttachment(filePart);
	    	 
	    	 if(attachment != null) {
	    		 
	    		 support.addAttachment(attachment);
	    		 
	    	 }
	    	 
	    	
	    	 
	     }
	     
	     RequestDispatcher rd = request.getRequestDispatcher("Support.jsp");//setting requester to index.jsp
	     request.setAttribute("response", "Your ticket has been processed!!");//setting data that needs to be sent to jsp
	     rd.forward(request, response);
	     //FIXME add a method to accept the files
	}
	
	private Attchment processAttachment(Part filePart)
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

        Attchment attachment = new Attchment();
        attachment.setName(filePart.getSubmittedFileName());
        attachment.setContents(outputStream.toByteArray());

        return attachment;
    }
	

}
