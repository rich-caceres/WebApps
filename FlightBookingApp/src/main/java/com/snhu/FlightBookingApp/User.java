package com.snhu.FlightBookingApp;


import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.stereotype.Service;

/*
 * This POJO is used to write a new user to XML for the login service.
 */
@Service
@XmlRootElement
public class User {

	private String userName;
	private String password;
	private String name;

	@XmlElement
	public void setName(String name) {
		
		this.name = name;
		
	}
	
	@XmlElement
	public void setUserName (String userName) {
		
		this.userName = userName;
		
	}
	@XmlElement
	public void setPassword(String password) {
		
		this.password = password;
		
	}
	
	public String getName() {
		
		return name;
		
	}
	
	public String getPassword() {
		
		return password;
	}
	
	public String getUserName() {
		
		return userName;
	}
	
	public User() {
		
		userName= "Admin";
		password= "Pass";
		name = "";
	}
	
}
