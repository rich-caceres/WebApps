package com.snhu.FlightBookingApp;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WriteXml {
	
	@Autowired
	User user;
	
	public void createXml(String userName, String password, String name) {
		
		user.setName(name);
		user.setUserName(userName);
		user.setPassword(password);
		
		try {
			
			File file = new File("users.xml");
			JAXBContext jaxbcontext = JAXBContext.newInstance(User.class);
			Marshaller marshaller = jaxbcontext.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			marshaller.marshal(user, file);
			
		}catch (JAXBException e) {
			
			e.printStackTrace();
		}
		
	}
}
