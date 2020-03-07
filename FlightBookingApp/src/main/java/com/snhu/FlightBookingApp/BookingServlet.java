package com.snhu.FlightBookingApp;



import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.snhu.FlightBookingApp.Pojo.Itenerary;



@Controller
public class BookingServlet  {

	
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
