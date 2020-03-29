package com.snhu.FlightBookingApp.Configuration;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@EntityScan(basePackages = "com.snhu.FlightBookingApp.Pojo")
@EnableJpaRepositories(basePackages= "com.snhu.FlightBookingApp.Repo")
@EnableTransactionManagement
public class RepoConfig {

}
