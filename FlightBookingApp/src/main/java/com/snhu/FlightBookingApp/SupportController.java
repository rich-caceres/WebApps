package com.snhu.FlightBookingApp;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.Part;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class SupportController {

	@RequestMapping(value = "/support")
	private String createSupport(@RequestParam (required = false) String name, @RequestParam (required = false) String subject, @RequestParam (required = false) String body,  
								 @RequestParam (required = false) Part file1, ModelMap model){
		
		System.out.println(name +""+ subject);
		SupportTicket support = new SupportTicket();
		support.supportInit();
		 
		 support.setName(name);//storing name in this variable for later use
	     support.setSubject(subject);//storing subject in this variable for later use
	     support.setBody(body);//storing body in this variable for later use
	     Part filePart = file1;//grabbing the file
	     
	     
	     model.put("response", "Your Ticket Has Been Processed!!!");
	     
	     
	    /*
	     if(filePart != null && filePart.getSize() > 0) {
	    	 
	    	 Attchment attachment = this.processAttachment(filePart);
	    	 
	    	 if(attachment != null) {
	    		 
	    		 support.addAttachment(attachment);
	    		 
	    	 }
	    	 }
	    	*/ //FIXME Need a new way to pass attachments in spring
	    	
	     return "Support";
	     
	}
	
}

