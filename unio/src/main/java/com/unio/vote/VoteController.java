package com.unio.vote;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class VoteController {
	
	@RequestMapping(value= {"/", "/greeting"}, method = RequestMethod.GET)
	public ModelAndView helloWorld() {
		String hello = "Hello World";
		ModelAndView model = new ModelAndView();
		
		model.addObject("greeting", hello);
		model.setViewName("index");
		
		return model; 
	}
	
	@RequestMapping(value= "/vote", method= RequestMethod.POST)
	public ModelAndView getVote(@RequestParam String name) {
		
		ModelAndView model = new ModelAndView();
		
		int vote = 0;
		
		model.addObject("name", name);
		model.setViewName("index");
		//TODO add a voting pojo/method to keep track of voting
		return model;
	}

}
