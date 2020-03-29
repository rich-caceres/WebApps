package com.snhu.FlightBookingApp.Pojo;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Service;

/*
 * This POJO is used to write a new user using DBO spring security 
 */
@Service
@Entity
@Table(name = "UserFlights.dbo.users")

public class UserProfile {

	@Id
	private String username;
	private String password;
	private byte enabled;
	

	public void setEnabled(byte enabled) {
		
		this.enabled = enabled;
		
	}
	
	public void setUserName (String username) {
		
		this.username = username;
		
	}
	
	public void setPassword(String password) {
		
		this.password = "{noop}" + password;
		
	}
	
	public byte getEnabled() {
		
		return enabled;
		
	}
	
	public String getPassword() {
		
		return password;
	}
	
	public String getUserName() {
		
		return username;
	}
	
	public UserProfile() {
		
		username= "";
		password= "";
		enabled = 1;
	}


}