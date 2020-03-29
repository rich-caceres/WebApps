package com.snhu.FlightBookingApp;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.snhu.FlightBookingApp.Pojo.ReadXml;
import com.snhu.FlightBookingApp.Pojo.UserAuthorities;
import com.snhu.FlightBookingApp.Pojo.UserProfile;
import com.snhu.FlightBookingApp.Pojo.WriteXml;
import com.snhu.FlightBookingApp.Repo.AuthRepo;
import com.snhu.FlightBookingApp.Repo.UserRepo;

@Controller
public class LoginController {
	
	@Autowired
	LoginService loginService;
	
	@Autowired
	ReadXml userInfo;
	
	@Autowired
	UserAuthorities userAuth;
	
	@Autowired
	AuthRepo authRepo;
	
	@Autowired
	UserRepo userRepo;
	
	@Autowired
	UserProfile user;
	
	@Autowired
	WriteXml xml;
	
	@RequestMapping(value = {"/" , "/login"} , method = RequestMethod.GET )
	private ModelAndView login(
				@RequestParam(value = "error", required = false) String error) {
		
		ModelAndView model = new ModelAndView();
		
		if(error != null ) {
			
			model.addObject("error", "Username was not found or is incorrect.");
			
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
	private String createUser(@RequestParam String username, @RequestParam String name, @RequestParam String password, ModelMap model) {
		
		
		//creates XML if the fields are not empty (assuming no spaces this is still not exactly secure)
		if(!password.equals("") || !username.equals("")) {
		
			user.setUserName(username);
			user.setPassword(password);
			userAuth.setUsername(username);
			this.userRepo.save(user);
			this.authRepo.save(userAuth);
			
		return "Login";
		}
		
		model.put("formError", "Please fill out all form information!");
		return "createUser";
		
	}
}
