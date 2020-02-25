package com.snhu.FlightBookingApp;


import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class User {

	private String userName;
	private String password;

	@XmlElement
	public void setUserName (String userName) {
		
		this.userName = userName;
		
	}
	@XmlElement
	public void setPassword(String password) {
		
		this.password = password;
		
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
		
	}
	
}
