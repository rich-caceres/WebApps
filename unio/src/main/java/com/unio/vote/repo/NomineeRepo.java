package com.unio.vote.repo;

import org.springframework.data.repository.CrudRepository;

import com.unio.vote.pojo.Nominee;

public interface NomineeRepo extends CrudRepository<Nominee, Integer>{

	public String getNomineeByName(String name);
	
}
