package com.snhu.FlightBookingApp;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.snhu.FlightBookingApp.Pojo.ReadXml;
import com.snhu.FlightBookingApp.Pojo.UserProfile;
import com.snhu.FlightBookingApp.Pojo.WriteXml;

@Controller
public class LoginController {
	
	@Autowired
	LoginService loginService;
	
	@Autowired
	ReadXml userInfo;
	
	@Autowired
	UserProfile user;
	
	@Autowired
	WriteXml xml;
	
	@RequestMapping(value = {"/" , "/login"} , method = RequestMethod.GET )
	private ModelAndView login(
				@RequestParam(value = "error", required = false) String error) {
		
		ModelAndView model = new ModelAndView();
		
		if(error != null ) {
			
			model.addObject("error", "Username was nout found or is incorrect.");
			
		}
		
		model.setViewName("Login");
		
		return model;
		
	}
	
	@RequestMapping(value= "/create*", method = RequestMethod.GET)
	private ModelAndView userCreation(){
		
		ModelAndView model = new ModelAndView();
		
		model.setViewName("createUser");
		
		return model;
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
		return "createUser";
		
	}
}
