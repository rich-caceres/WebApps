package com.tracker.pojo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SupportTicket {
	
	private enum StatusEnum {Read, Complete, Sent};
	private String name;
	private String date;
	private String vehicle;
	private String subject;
	private String content;
	private StatusEnum status;
	
	public StatusEnum getStatus() {
		return status;
	}
	public void setStatus(StatusEnum status) {
		this.status = status;
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
		status= StatusEnum.Sent;
	}
	
}
