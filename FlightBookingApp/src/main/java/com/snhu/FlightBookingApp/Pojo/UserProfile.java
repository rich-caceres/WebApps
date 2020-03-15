package com.snhu.FlightBookingApp.Pojo;



//import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.xml.bind.annotation.XmlElement;
//import javax.xml.bind.annotation.XmlRootElement;


import org.springframework.stereotype.Service;

/*
 * This POJO is used to write a new user using DBO spring security 
 */
@Service
@Entity
//@XmlRootElement
public class UserProfile {

	@Column(nullable = false, unique = true)
	private String username;
	private String password;
	private String name;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	//@XmlElement
	public void setName(String name) {
		
		this.name = name;
		
	}
	
	
	public void setId (Long id) {
		
		this.id = id;
		
	}
	
	//@XmlElement
	public void setUserName (String userName) {
		
		this.username = userName;
		
	}
	
	//@XmlElement
	public void setPassword(String password) {
		
		this.password = password;
		
	}
	
	public Long getid() {
		
		return id;
		
	}
	
	public String getName() {
		
		return name;
		
	}
	
	public String getPassword() {
		
		return password;
	}
	
	public String getUserName() {
		
		return username;
	}
	
	public UserProfile() {
		
		username= "Admin";
		password= "Pass";
		name = "";
	}


}