package com.snhu.FlightBookingApp;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
	
	@Autowired
	LoginService loginService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET )
	private String login() {
		
		return "Login";
		
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	private String loginHandeler(@RequestParam String username, @RequestParam String password, ModelMap model) {
		
		if(!loginService.validateUser(username, password)) {
			model.put("error", "Incorrect Username or Password.");
			return "Login";
		}
			
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy"); //used to format the date
		Date date = new Date(); //creates a date object
		model.put("date", formatter.format(date));//setting data that needs to be sent to jsp
		return "index";	
		
	}
}
