package com.snhu.FlightBookingApp;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.snhu.FlightBookingApp.Pojo.ReadXml;
import com.snhu.FlightBookingApp.Pojo.User;
import com.snhu.FlightBookingApp.Pojo.WriteXml;

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
	
	@RequestMapping(value = "/login", method = RequestMethod.GET )
	private String login() {
		
		return "Login";
		
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	private String loginHandeler(@RequestParam String username, @RequestParam String password, ModelMap model) {
		
		user = userInfo.user(username);
		//forces login information to be validated from XML
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
	
	@RequestMapping(value= "/loginNew", method = RequestMethod.POST)
	private String createUser(@RequestParam String userName, @RequestParam String name, @RequestParam String password, ModelMap model) {
		
		System.out.println(userName);
		//creates XML if the fields are not empty (assuming no spaces this is still not exactly secure)
		if(!password.equals("") || !userName.equals("")) {
		xml.createXml(userName, password, name);
		return "Login";
		}
		model.put("formError", "Please fill out all form information!");
		return "Login";
		
	}
}
