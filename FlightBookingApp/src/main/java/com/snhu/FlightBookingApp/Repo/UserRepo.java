package com.snhu.FlightBookingApp.Repo;



import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.snhu.FlightBookingApp.Pojo.UserProfile;
//deaks with user information stored on database to validate by spring secuurity
@Repository
public interface UserRepo extends CrudRepository<UserProfile, Integer> {

}
