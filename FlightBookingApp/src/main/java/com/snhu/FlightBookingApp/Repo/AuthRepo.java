package com.snhu.FlightBookingApp.Repo;



import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.snhu.FlightBookingApp.Pojo.UserAuthorities;
//Deals with authorization information in database used by spring security
@Repository
public interface AuthRepo extends CrudRepository<UserAuthorities, Integer> {
	
}
