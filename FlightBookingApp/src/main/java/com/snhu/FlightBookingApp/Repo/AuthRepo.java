package com.snhu.FlightBookingApp.Repo;



import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.snhu.FlightBookingApp.Pojo.UserAuthorities;

@Repository
public interface AuthRepo extends CrudRepository<UserAuthorities, Integer> {
	
}
