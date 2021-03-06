package com.unio.vote.pojo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Service;

/* Nominee object will be used to create the nominee. Added to the database once the nominee
 * is created. Once the ballots are closed, the table holding this information will be droped. */

@Service
@Entity
@Table(name = "Nominee")
public class Nominee {
	//This will need to be entered into a database
	@Id
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
