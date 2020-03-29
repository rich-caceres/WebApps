package com.snhu.FlightBookingApp.Pojo;



//import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.xml.bind.annotation.XmlElement;
//import javax.xml.bind.annotation.XmlRootElement;
import javax.persistence.Table;

import org.springframework.stereotype.Service;

/*
 * This POJO is used to write a new user using DBO spring security 
 */
@Service
@Entity
@Table(name = "UserFlights.dbo.users")
//@XmlRootElement
public class UserProfile {

	@Id
	private String username;
	private String password;
	private byte enabled;
	


	
	//@XmlElement
	public void setEnabled(byte enabled) {
		
		this.enabled = enabled;
		
	}
	
	

	//@XmlElement
	public void setUserName (String username) {
		
		this.username = username;
		
	}
	
	//@XmlElement
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