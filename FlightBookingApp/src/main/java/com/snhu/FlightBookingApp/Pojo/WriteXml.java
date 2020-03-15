package com.snhu.FlightBookingApp.Pojo;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WriteXml {
	
	@Autowired
	UserProfile user;
	
	public void createXml(String userName, String password, String name) {
		
		user.setName(name);
		user.setUserName(userName);
		user.setPassword(password);
		
		try {
			
			File file = new File(user.getUserName()+".xml");
			JAXBContext jaxbcontext = JAXBContext.newInstance(UserProfile.class);
			Marshaller marshaller = jaxbcontext.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			marshaller.marshal(user, file);
			
		}catch (JAXBException e) {
			
			e.printStackTrace();
		}
		
	}
}
