package com.tracker.pojo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SupportTicket {
	
	
	private String name;
	private String date;
	private String vehicle;
	private String subject;
	private String content;
	private String outcome;
	private StatusEnum status;
	public enum StatusEnum {Read, Complete, Sent};
	
	public StatusEnum getStatus() {
		return status;
	}
	public void setStatus(StatusEnum status) {
		this.status = status;
	}
	public void setOutcome(String outcome) {
		this.outcome=outcome;
	}
	public String outcome() {
		return outcome;
	}
	public String getName() {
		return name;
	}
	public String getVehicle() {
		return vehicle;
	}
	public void setVehicle(String vehicle) {
		this.vehicle = vehicle;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	public SupportTicket() {
		
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy"); //used to format the date
		Date theDate = new Date(); //creates a date object
		
		name="";
		date=formatter.format(theDate);
		vehicle="";
		subject="";
		content="";
		outcome="";
		status= StatusEnum.Sent;
		
	}
	
	public SupportTicket(String name, String vehicle, String subject, String content) {
		
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy"); //used to format the date
		Date theDate = new Date(); //creates a date object
		
		this.name=name;
		date=formatter.format(theDate);
		this.vehicle=vehicle;
		this.subject=subject;
		this.content=content;
		status= StatusEnum.Sent;
	}
	
}
