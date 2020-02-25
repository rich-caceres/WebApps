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
	
	@Autowired
	ReadXml userInfo;
	
	@Autowired
	User user;
	
	@Autowired
	WriteXml xml;
	
	@RequestMapping(value = "/", method = RequestMethod.GET )
	private String login() {
		
		return "Login";
		
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	private String loginHandeler(@RequestParam String username, @RequestParam String password, ModelMap model) {
		
		user = userInfo.user();
		
		if(!loginService.validateUser(username, password, user)) {
			model.put("error", "Incorrect Username or Password.");
			return "Login";
		}
			
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy"); //used to format the date
		Date date = new Date(); //creates a date object
		model.put("date", formatter.format(date));//setting data that needs to be sent to jsp
		return "index";	
		
	}
	
	@RequestMapping(value= "/createUser", method = RequestMethod.GET)
	private String userCreation(){
		
		
		return "createUser";
	}
	
	@RequestMapping(value= "/createUser", method = RequestMethod.POST)
	private String createUser(@RequestParam String userName, @RequestParam String name, @RequestParam String password) {
		
		xml.createXml(userName, password, name);
		
		return "Login";
	}
}
