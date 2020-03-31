package com.unio.vote.pojo;

public class Nominee {
	//This will need to be entered into a database
	String name;
	String position;
	int votes;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public int getVotes() {
		return votes;
	}
	public void setVotes(int votes) {
		this.votes = votes;
	}
	
	public Nominee() {
		
		name= "";
		position= "";
		votes= 0;
	}

}
