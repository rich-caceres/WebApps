package com.snhu.FlightBookingApp;

import org.springframework.stereotype.Service;

//This is a dummy login service to validate information passed
@Service
public class LoginService {
	
	public boolean validateUser(String userName, String Password) {
		
		return userName.equalsIgnoreCase("User") 
					&& Password.equals("Pass");
				
	}		
}
