package com.unio.vote.repo;

import org.springframework.data.repository.CrudRepository;

import com.unio.vote.pojo.Voter;

public interface VoterRepo extends CrudRepository<Voter, Integer> {

	
}
