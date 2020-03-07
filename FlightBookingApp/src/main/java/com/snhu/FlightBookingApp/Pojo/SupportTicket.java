package com.snhu.FlightBookingApp.Pojo;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;



public class SupportTicket {
	
	private String name;
	private String subject;
	private String body;
	private Map<String, Attchment> attachments;
	
	public void setName(String name) {
		
		this.name = name;
		
	}
	
	public void setSubject(String subject) {
		
		this.subject = subject;
		
	}
	
	public void setBody(String body) {
	
		this.body = body;
	
	}
	
	
	public String getName() {
		
		return this.name;
		
	}
	
	public String getSubject() {
		
		return this.subject;
		
	}
	
	public String getBody() {
		
		return this.body;
		
	}
	
	public Attchment getAttachment(String name){
		
        return this.attachments.get(name);
    }

    public Collection<Attchment> getAttachments(){
    	
        return this.attachments.values();
    }

    public void addAttachment(Attchment attachment){
    	
        this.attachments.put(attachment.getName(), attachment);
    }

    public int getNumberOfAttachments(){
    	
        return this.attachments.size();
        
    }
    
    public SupportTicket() {
    	
    	name = "";
    	subject = "";
    	body = "";
    	attachments = new LinkedHashMap<>();
    	
    }
}


