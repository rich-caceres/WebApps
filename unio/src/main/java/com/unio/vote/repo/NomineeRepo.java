package com.unio.vote.repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.unio.vote.pojo.Nominee;

@Repository
public interface NomineeRepo extends CrudRepository<Nominee, String>{

	public Nominee getNomineeByName(String name);
	
	//TODO queries cant be validated, throws exception.
	//@Query("SELECT votes FROM Nominee WHERE name = nominee.name ")
	//public int getNomineeVotes();
	
	//@Query("SELECT position FROM Nominee Where name = noinee.name")
	//public String getNomineePosition();
	
}
