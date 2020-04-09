package com.unio.vote.repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.unio.vote.pojo.Nominee;

public interface NomineeRepo extends CrudRepository<Nominee, String>{

	public Nominee getNomineeByName(String name);
	
	@Query("SELECT votes FROM Nominee WHERE name = nominee.name ")
	public int getNomineeVotes();
	
	@Query("SELECT position FROM Nominee Where name = noinee.name")
	public String getNomineePosition();
	
}
