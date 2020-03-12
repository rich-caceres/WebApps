package com.snhu.FlightBookingApp;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.Part;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.snhu.FlightBookingApp.Pojo.Attchment;
import com.snhu.FlightBookingApp.Pojo.SupportTicket;

@MultipartConfig(
        fileSizeThreshold = 5_242_880, //5MB
        maxFileSize = 20_971_520L, //20MB
        maxRequestSize = 41_943_040L //40MB
)

@Controller
public class SupportController {

	@RequestMapping(value = "/support", method = RequestMethod.POST)
	private ModelAndView createSupport(@RequestParam (required = false) String name, @RequestParam (required = false) String subject, @RequestParam (required = false) String body,  
								 @RequestParam (required = false) Part file1) throws IOException{
		
		ModelAndView model = new ModelAndView(); 
		
		System.out.println(name +""+ subject);
		SupportTicket support = new SupportTicket();
		
		 
		 support.setName(name);//storing name in this variable for later use
	     support.setSubject(subject);//storing subject in this variable for later use
	     support.setBody(body);//storing body in this variable for later use
	     Part filePart = file1;//grabbing the file
	     
	     
	     model.addObject("response", "Your Ticket Has Been Processed!!!");
	     model.setViewName("Support");
	     
	     
	    //Processes attachments and adds to support ticket
	     if(filePart != null && filePart.getSize() > 0) {
	    	 
	    	 Attchment attachment = this.processAttachment(filePart);
	    	 
	    	 if(attachment != null) {
	    		 
	    		 support.addAttachment(attachment);
	    		 
	    	 }
	    	 }
	   
	     return model;
	     
	}
	
	private Attchment processAttachment(Part filePart)
            throws IOException
    {
        InputStream inputStream = filePart.getInputStream();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        int read;
        final byte[] bytes = new byte[1024];

        while((read = inputStream.read(bytes)) != -1)
        {
            outputStream.write(bytes, 0, read);
        }

        Attchment attachment = new Attchment();
        attachment.setName(filePart.getSubmittedFileName());
        attachment.setContents(outputStream.toByteArray());

        return attachment;
    }
	
	
}

