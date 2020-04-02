package com.unio.vote.pojo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Inheritance(strategy= InheritanceType.SINGLE_TABLE)
@Table(name = "Member")
public class Voter {
	//Database will be needed to store this data
	@Id
	String name;
	boolean voted;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isVoted() {
		return voted;
	}
	public void setVoted(boolean voted) {
		this.voted = voted;
	}
	
	public class Nominee extends Voter{
		
		protected String position;
		
		protected int votes;
	}
	
	public Voter() {
		
		name= "";
		voted= false;
		
	}
	
}
