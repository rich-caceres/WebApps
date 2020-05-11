package com.snhu.FlightBookingApp;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.snhu.FlightBookingApp.Pojo.*;

//This is a dummy login service to validate information passed, this is not utilized anymore because of spring security.
@Service
public class LoginService{

	
	public boolean validateUser(String userName, String Password, UserProfile user) {
		
		return userName.equalsIgnoreCase(user.getUserName()) 
					&& Password.equals(user.getPassword());
				
	}		
}
