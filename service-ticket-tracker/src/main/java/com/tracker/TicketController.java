package com.tracker;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.websocket.server.ServerEndpoint;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tracker.pojo.SupportTicket;



@Controller
public class TicketController {
	
	//This is only used to check functionality, will change when database is used.
	ArrayList<SupportTicket> ticketList = new ArrayList<>();
	protected volatile int TICKET_ID_SEQ= 1;
	protected Map<Integer, SupportTicket> ticketData= new LinkedHashMap<>();
	
	
	@RequestMapping(value= "/")
	public ModelAndView tester() {
		
		ModelAndView test = new ModelAndView();
		
		test.setViewName("index");
		
		return test;
		
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
		
		model.setViewName("index");
		return model;
		
	}
	
	//Will return list of tickets when database is implemented
	@RequestMapping(value= "/listOfTickets")
	public ModelAndView ticketList() throws JsonProcessingException {
		
		
		ModelAndView model = new ModelAndView();
		
		SupportTicket ticket = new SupportTicket();
		ticket = ticketData.get(1);
		ObjectMapper mapper = new ObjectMapper();
		
		String ticketAsString = mapper.writeValueAsString(ticket);
		
		model.addObject("ticket", ticketAsString);
		model.addObject("tickets", this.ticketData);
		
		model.setViewName("TicketList");
		
	 return model;
	}

}
