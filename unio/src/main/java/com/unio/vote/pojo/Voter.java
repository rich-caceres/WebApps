package com.unio.vote.pojo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import org.springframework.stereotype.Service;

/* Creates the voter/user of the application. Will be saved in a database
 * and the table will remain.*/

@Service
@Entity
@Inheritance(strategy= InheritanceType.SINGLE_TABLE)
@Table(name = "Member")
public class Voter {
	//Database will be needed to store this data
	@Id
	String name;
	String password;
	String userRole;
	//Might change boolean to enum, need to test this boolean method first.
	boolean voted;
	
	public String getUserRole() {
		return userRole;
	}
	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public void setPassword(String password) {
		this.password = password;	
	}
	
	public String getPassword() {
		return password;
	}
	
	public boolean isVoted() {
		return voted;
	}
	public void setVoted(boolean voted) {
		this.voted = voted;
	}

	public Voter() {
		
		name= "";
		voted= false;
		password="";
		userRole= "";
	}
	
}
