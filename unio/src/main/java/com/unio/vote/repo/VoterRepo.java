package com.unio.vote.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.unio.vote.pojo.Voter;

@Repository
public interface VoterRepo extends CrudRepository<Voter, Integer> {

	
}
