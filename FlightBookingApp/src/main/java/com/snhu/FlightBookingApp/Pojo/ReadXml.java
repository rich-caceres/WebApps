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
	User user;
	
	public User user(String username) {
	
		File file = new File(username+".xml");
		
		if(!file.exists()) {
			
			user.setUserName("NothingHere");
			return user;
			
		}else {
		
		 try {
	            
	            JAXBContext jaxbContext = JAXBContext.newInstance(User.class);
	            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
	            user = (User) jaxbUnmarshaller.unmarshal(file);
	        } catch (JAXBException e) {
	            e.printStackTrace();
	        }
		
		return user;
		}
	}
	
}
