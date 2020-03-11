package com.snhu.FlightBookingApp.Pojo;



import java.util.UUID;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.stereotype.Service;

/*
 * This POJO is used to write a new user to XML for the login service.
 */
@Service
@XmlRootElement
public class UserProfile {

	private String userName;
	private String password;
	private String name;
	private UUID id;
	
	@XmlElement
	public void setName(String name) {
		
		this.name = name;
		
	}
	
	
	public void setId () {
		
		this.id = UUID.randomUUID();
		
	}
	
	@XmlElement
	public void setUserName (String userName) {
		
		this.userName = userName;
		
	}
	@XmlElement
	public void setPassword(String password) {
		
		this.password = password;
		
	}
	
	public UUID getid() {
		
		return id;
		
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
	
	public UserProfile() {
		
		userName= "Admin";
		password= "Pass";
		name = "";
	}


}