package com.snhu.FlightBookingApp;

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
	
	public User user() {
		
		 try {
	            File file = new File("users.xml");
	            JAXBContext jaxbContext = JAXBContext.newInstance(User.class);
	            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
	            user = (User) jaxbUnmarshaller.unmarshal(file);
	        } catch (JAXBException e) {
	            e.printStackTrace();
	        }
		
		return user;
		
	}
	
}
