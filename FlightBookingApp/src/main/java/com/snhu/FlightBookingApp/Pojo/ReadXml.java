package com.snhu.FlightBookingApp.Pojo;

//pulls an XML file and breaks it down and adds it as a user to validate the user. This is no longer used because of spring security.
import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReadXml {

	@Autowired
	UserProfile user;
	
	public UserProfile user(String username) {
	
		File file = new File(username+".xml");
		
		if(!file.exists()) {
			
			user.setUserName("NothingHere");
			return user;
			
		}else {
		
		 try {
	            
	            JAXBContext jaxbContext = JAXBContext.newInstance(UserProfile.class);
	            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
	            user = (UserProfile) jaxbUnmarshaller.unmarshal(file);
	        } catch (JAXBException e) {
	            e.printStackTrace();
	        }
		
		return user;
		}
	}
	
}
