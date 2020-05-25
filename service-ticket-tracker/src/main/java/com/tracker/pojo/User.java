package com.tracker.pojo;

public class User {

	private String firstName;
	private String lastName;
	private String badgeNum;
	private String jobFunction;
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getBadgeNum() {
		return badgeNum;
	}
	public void setBadgeNum(String badgeNum) {
		this.badgeNum = badgeNum;
	}
	public String getJobFunction() {
		return jobFunction;
	}
	public void setJobFunction(String jobFunction) {
		this.jobFunction = jobFunction;
	}
	public User() {
		firstName="";
		lastName="";
		badgeNum="";
		jobFunction="";
	}
}
