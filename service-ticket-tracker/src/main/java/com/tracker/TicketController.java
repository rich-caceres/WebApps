package com.tracker;
//Java imports
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
//Spring imports
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
//JSON imports
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
//POJO imports
import com.tracker.pojo.SupportTicket;
import com.tracker.pojo.SupportTicket.StatusEnum;
import com.tracker.pojo.User;

@Controller
public class TicketController {
	
	//This is only used to check functionality, will change when database is used.
	ArrayList<SupportTicket> ticketList = new ArrayList<>();
	protected volatile int TICKET_ID_SEQ= 1;
	protected Map<Integer, SupportTicket> ticketData= new LinkedHashMap<>();
	//user created to test user functionality
	protected User currentUser = new User();
	//back button variable
	protected String page = "";
	
	@RequestMapping(value= "/")
	public ModelAndView landingPage() {
		
		currentUser.setJobFunction("User");
		
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy"); //used to format the date
		Date theDate = new Date(); //creates a date object
		ModelAndView landingPage = new ModelAndView();
		
		landingPage.addObject("date", formatter.format(theDate));
		landingPage.setViewName("index");
		
		return landingPage;
		
	}
	
	@RequestMapping(value= "/submitTicket")
	public ModelAndView ticketSubmitted(@RequestParam String name, 
		@RequestParam String vehicle, @RequestParam String subject, @RequestParam String content) {
		
		SupportTicket ticket = new SupportTicket();
		
		ticket.setName(name);
		ticket.setVehicle(vehicle);
		ticket.setSubject(subject);
		ticket.setContent(content);	
		
		int id;
        synchronized(this)
        {
            id = this.TICKET_ID_SEQ++;
            this.ticketData.put(id, ticket);
        }
		
		ModelAndView model = new ModelAndView();
		
		model.addObject("date", ticket.getDate());
		model.setViewName("redirect:/");
		return model;
		
	}
	
	//Will return list of tickets when database is implemented
	@RequestMapping(value= "/listOfTickets")
	public ModelAndView ticketList() throws JsonProcessingException {
		
		ModelAndView model = new ModelAndView();
		page = "redirect:/";
		ObjectMapper objectMapper = new ObjectMapper();
		model.addObject("ticket", objectMapper.writeValueAsString(this.ticketData));
		model.addObject("Tickets", this.ticketData);
		model.setViewName("TicketList");
		
	 return model;
	}
	
	@RequestMapping(value= "/getTicket/{ticketId}")
	public ModelAndView ticketRetrieval(@PathVariable int ticketId) {
		
		ModelAndView model = new ModelAndView();
		SupportTicket ticket = new SupportTicket();
		
		ticket = ticketData.get(ticketId);
		page = "redirect:/listOfTickets";
		model.addObject("name", ticket.getName());
		model.addObject("date", ticket.getDate());
		model.addObject("subject", ticket.getSubject());
		model.addObject("vehicle", ticket.getVehicle());
		model.addObject("content", ticket.getContent());
		
		
		if (this.currentUser.getJobFunction().equals("Mechanic") && ticket.getStatus()!= StatusEnum.Complete) {
			
			ticket.setStatus(StatusEnum.Read);
			
		}
		
		model.addObject("status", ticket.getStatus());
		model.setViewName("TicketView");
		
		return model;
	}
	
	@RequestMapping(value="/back")
	public ModelAndView backButton(){
		ModelAndView model = new ModelAndView();
		model.setViewName(page);
		return model;
	}
	
	@RequestMapping(value= "/getTickAdm/{ticketId}")
	public ModelAndView admTicketRetrieval(@PathVariable int ticketId) {
		
		ModelAndView model = new ModelAndView();
		
		return model;
		
	}
}
