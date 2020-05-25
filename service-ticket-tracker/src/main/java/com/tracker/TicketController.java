package com.tracker;

import javax.websocket.server.ServerEndpoint;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.tracker.pojo.SupportTicket;

@Controller
public class TicketController {
	
	@RequestMapping(value= "/")
	public ModelAndView tester() {
		
		ModelAndView test = new ModelAndView();
		
		test.setViewName("index");
		
		return test;
		
	}
	
	@RequestMapping(value= "/submitTicket")
	public ModelAndView ticketSubmitted(@RequestParam String name, @RequestParam String date, 
			@RequestParam String subject, @RequestParam String content) {
		
		SupportTicket ticket = new SupportTicket();
		
		ticket.setName(name);
		ticket.setDate(date);
		ticket.setSubject(subject);
		ticket.setContent(content);
		
		ModelAndView model = new ModelAndView();
		
		return model;
		
	}

}
