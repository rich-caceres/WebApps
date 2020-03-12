package com.snhu.FlightBookingApp;



import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.snhu.FlightBookingApp.Pojo.Itenerary;



@Controller
public class BookingServlet  {

	
	@RequestMapping(value= "/create**", method = RequestMethod.GET)
	private ModelAndView createPage () {
		
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy"); //used to format the date
		Date date = new Date(); //creates a date object
		
		
		ModelAndView model = new ModelAndView();
		model.addObject("date", formatter.format(date));//setting data that needs to be sent to jsp
		//model.addObject(attributeValue); placeholder for other data
		model.setViewName("index");
		return model;
		
		
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.POST )
	private ModelAndView createFlight(@RequestParam String travelers, @RequestParam String startLoc, @RequestParam String endLoc, @RequestParam String startDate, @RequestParam String endDate){
		
		ModelAndView model = new ModelAndView();
		
		Itenerary itenerary = new Itenerary();
	
		
		itenerary.setTravelers(travelers);//requesting parameters for travelers
		itenerary.setStartLoc(startLoc);//assigning starting location
		itenerary.setEndLoc(endLoc);//assigning end location
		itenerary.setStartDate(startDate);//assigning start date
		itenerary.setEndDate(endDate);//assigning end date
		
		System.out.print(itenerary.getTravelers());
		
	    model.addObject("traveler", itenerary.getTravelers());//setting data that needs to be sent to jsp
		model.addObject("startLoc", itenerary.getStartLoc());//setting data that needs to be sent to jsp
		model.addObject("endLoc", itenerary.getEndLoc());//setting data that needs to be sent to jsp
		model.addObject("startDate", itenerary.getStartDate());//setting data that needs to be sent to jsp
		model.addObject("endDate", itenerary.getEndDate());//setting data that needs to be sent to jsp
		model.setViewName("BookedFlight");
		
		return model;
	
		
	}
	


}
