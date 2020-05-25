package com.tracker;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TicketController {
	
	@RequestMapping(value= "/")
	public ModelAndView tester() {
		
		ModelAndView test = new ModelAndView();
		
		test.setViewName("index");
		
		return test;
		
	}

}
