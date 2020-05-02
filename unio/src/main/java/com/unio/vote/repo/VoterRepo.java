package com.unio.vote.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.unio.vote.pojo.Voter;

//Repo to save the user information
@Repository
public interface VoterRepo extends CrudRepository<Voter, Integer> {

	
}
