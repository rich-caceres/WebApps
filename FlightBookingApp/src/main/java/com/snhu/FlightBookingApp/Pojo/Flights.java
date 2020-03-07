package com.snhu.FlightBookingApp.Pojo;

public class Flights {
	
	private int flightNumber;
	private String airline;
	private String airport;
	private String departure;
	private String arrival;
	
	
	public void setFlightNumber(int flightNumber) {
		
		this.flightNumber= flightNumber;
		
	}
	
	public void setAirline(String airline) {
		
		this.airline= airline;
		
	}

	public void setAirport(String airport) {
	
		this.airport= airport;
	
	}

	public void setDeparture(String departure) {
	
		this.departure= departure;
	
	}

	public void setArrival(String arrival) {
	
		this.arrival= arrival;
	
	}
	
	public int getFlightNumber() {
		
		
		return flightNumber;
	}
	
	public String getAirline() {
		
		return airline;
	}
	
	public String getAirport() {
		
		return airport;
	}
	
	public String getDeparture() {
		
		return departure;
	}
	
	public String getArrival() {
		
		return arrival;
	}
	
	public Flights() {
		
		flightNumber = 0;
		airline = "";
		airport="";
		departure="";
		arrival="";
		
	}

}
