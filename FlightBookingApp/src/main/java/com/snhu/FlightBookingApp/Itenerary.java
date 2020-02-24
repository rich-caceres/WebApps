package com.snhu.FlightBookingApp;


//POJO for itinerary pardon the awful spelling
public class Itenerary {
	
	private String travelers;
	private String startLoc;
	private String endLoc;
	private String endDate;
	private String startDate;
	
	public void setTravelers (String travelers) {
		
		this.travelers = travelers;
		
	}
	
	public void setStartLoc (String startLoc) {
		
		this.startLoc = startLoc;
		
	}
	public void setEndLoc (String endLoc) {
	
		this.endLoc = endLoc;
	
	}
	public void setEndDate (String endDate) {
	
		this.endDate = endDate;
	
	}
	public void setStartDate (String startDate) {
	
		this.startDate = startDate;
	
	}
	
	public String getTravelers() {
		
		return travelers;
		
	}

	public String getStartLoc() {
		
		return startLoc;
		
	}
	public String getEndLoc() {
	
		return endLoc;
	
	}
	public String getEndDate() {
	
		return endDate;
	
	}
	public String getStartDate() {
	
		return startDate;
	
	}
	
	public Itenerary() {
		
		travelers = "";
		startLoc = "";
		endLoc = "";
		endDate = "";
		startDate = "";
		
		
	}
	
}
