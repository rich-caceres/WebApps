package com.snhu.FlightBookingApp.Pojo;

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
