package com.snhu.FlightBookingApp.Repo;



import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.snhu.FlightBookingApp.Pojo.UserProfile;

@Repository
public interface UserRepo extends CrudRepository<UserProfile, Integer> {

}
