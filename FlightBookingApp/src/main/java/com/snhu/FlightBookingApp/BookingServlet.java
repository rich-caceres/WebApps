package com.snhu.FlightBookingApp;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.snhu.FlightBookingApp.Pojo.Itenerary;




/**
 * Servlet implementation class BookingServlet
 */

@Controller
public class BookingServlet  {


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	/*Keeping this for future reference
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
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
	 *//*
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
	*/

	
	@RequestMapping(value = "/create", method = RequestMethod.POST )
	private String createFlight(@RequestParam String travelers, @RequestParam String startLoc, @RequestParam String endLoc, @RequestParam String startDate, @RequestParam String endDate,
								ModelMap model){
		
		Itenerary itenerary = new Itenerary();
	
		
		itenerary.setTravelers(travelers);//requesting parameters for travelers
		itenerary.setStartLoc(startLoc);//assigning starting location
		itenerary.setEndLoc(endLoc);//assigning end location
		itenerary.setStartDate(startDate);//assigning start date
		itenerary.setEndDate(endDate);//assigning end date
		
		System.out.print(itenerary.getTravelers());
		
	    model.put("traveler", itenerary.getTravelers());//setting data that needs to be sent to jsp
		model.put("startLoc", itenerary.getStartLoc());//setting data that needs to be sent to jsp
		model.put("endLoc", itenerary.getEndLoc());//setting data that needs to be sent to jsp
		model.put("startDate", itenerary.getStartDate());//setting data that needs to be sent to jsp
		model.put("endDate", itenerary.getEndDate());//setting data that needs to be sent to jsp
		
		return "BookedFlight";
	
		
	}
	


}
