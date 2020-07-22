package com.tracker.pojo;

public class User {

	private String firstName;
	private String lastName;
	private int badgeNum;
	private String jobFunction;
	private String password;
	
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
	public int getBadgeNum() {
		return badgeNum;
	}
	public void setBadgeNum(int badgeNum) {
		this.badgeNum = badgeNum;
	}
	public String getJobFunction() {
		return jobFunction;
	}
	public void setJobFunction(String jobFunction) {
		this.jobFunction = jobFunction;
	}
	public void getPassword(String password) {
		this.password = password;
	}
	public String getPassword() {	
		return password;
	}
	public User(String firstName, String lastName, int badgeNum, 
			String jobFunction, String password) {
		this.firstName=firstName;
		this.lastName=lastName;
		this.badgeNum=badgeNum;
		this.jobFunction=jobFunction;
		this.password= password;
	}
}
