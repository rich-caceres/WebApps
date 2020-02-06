package com.snhu.FlightBookingApp;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


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
		doGet(request, response);
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
		
		String travelers = request.getParameter("travelers");//requesting parameters for travelers
		String startLoc = request.getParameter("startLoc");//assigning starting location
		String endLoc = request.getParameter("endLoc");//assigning end location
		String startDate = request.getParameter("startDate");//assigning start date
		String endDate = request.getParameter("endDate");//assigning end date
		
		RequestDispatcher rd = request.getRequestDispatcher("BookedFlight.jsp");//setting requester to index.jsp
		request.setAttribute("traveler", travelers);//setting data that needs to be sent to jsp
		request.setAttribute("startLoc", startLoc);//setting data that needs to be sent to jsp
		request.setAttribute("endLoc", endLoc);//setting data that needs to be sent to jsp
		request.setAttribute("startDate", startDate);//setting data that needs to be sent to jsp
		request.setAttribute("endDate", endDate);//setting data that needs to be sent to jsp
		
		rd.forward(request, response);//sending the data to the jsp
		
		
	}
	
	private void createSupport(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 String customerName = request.getParameter("name");//storing name in this variable for later use
	     String subject = request.getParameter("subject");//storing subject in this variable for later use
	     String body = request.getParameter("body");//storing body in this variable for later use
	     
	     RequestDispatcher rd = request.getRequestDispatcher("Support.jsp");//setting requester to index.jsp
	     request.setAttribute("response", "Your ticket has been processed!!");//setting data that needs to be sent to jsp
	     rd.forward(request, response);
	     
	     //FIXME add a method to accept the files
	}
	

}
