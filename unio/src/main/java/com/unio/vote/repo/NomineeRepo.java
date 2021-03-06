package com.unio.vote.repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.unio.vote.pojo.Nominee;

//Repo used to save the nominee information 
@Repository
public interface NomineeRepo extends CrudRepository<Nominee, String>{

	public Nominee getNomineeByName(String name);
	
	//TODO queries cant be validated, throws exception. Will be tested once database is implemented
	//@Query("SELECT votes FROM Nominee WHERE name = nominee.name ")
	//public int getNomineeVotes();
	
	//@Query("SELECT position FROM Nominee Where name = noinee.name")
	//public String getNomineePosition();
	
}
