package com.snhu.FlightBookingApp.Pojo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Service;
//authorities is used in spring security, currently only uses the user role but we can expand the web app to have an admin that can view support tickets.
@Service
@Entity
@Table(name = "UserFlights.dbo.authorities")
public class UserAuthorities {
	
	@Id
	private String username;
	private String roles;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getAuthority() {
		return roles;
	}
	public void setAuthority(String roles) {
		this.roles = roles;
	}
	
	public UserAuthorities(){
		
		username= "";
		roles= "ROLE_USER";
		
	}

}
