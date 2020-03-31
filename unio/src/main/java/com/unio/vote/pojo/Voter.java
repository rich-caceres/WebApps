package com.unio.vote.pojo;

public class Voter {
	//Database will be needed to store this data
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
	
	public Voter() {
		
		name= "";
		voted= false;
		
	}
	
}
