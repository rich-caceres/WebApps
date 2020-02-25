package com.snhu.FlightBookingApp;


import org.springframework.stereotype.Service;

//This is a dummy login service to validate information passed
@Service
public class LoginService {
	
	
	public boolean validateUser(String userName, String Password, User user) {
		
		return userName.equalsIgnoreCase(user.getUserName()) 
					&& Password.equals(user.getPassword());
				
	}		
}
