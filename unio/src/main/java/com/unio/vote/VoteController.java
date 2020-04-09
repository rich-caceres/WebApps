package com.unio.vote;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.unio.vote.pojo.Voter;
import com.unio.vote.pojo.Nominee;
import com.unio.vote.repo.NomineeRepo;
import com.unio.vote.repo.VoterRepo;


@Controller
public class VoteController {
	
	@Autowired
	VoterRepo voteeRepo;
	
	@Autowired
	NomineeRepo nomineeRepo;
	
	@Autowired
	Nominee nominee;
	
	@Autowired
	Voter votee;
	
	@RequestMapping(value= {"/", "/greeting"}, method = RequestMethod.GET)
	public ModelAndView helloWorld() {
		String hello = "Hello World";
		ModelAndView model = new ModelAndView();
		
		model.addObject("greeting", hello);
		model.setViewName("index");
		
		return model; 
	}
	
	@RequestMapping(value="/CreateNominee", method = RequestMethod.POST)
	
	public ModelAndView createNominee(@RequestParam String name, @RequestParam String position){
		
		ModelAndView model = new ModelAndView();
		//TODO add method to create a nominee from existing users and set up JSP's for all views
		
		return model;
		
	}
	
	@RequestMapping(value="/CreateVoter", method = RequestMethod.POST)
	public ModelAndView createVoter(@RequestParam String name, @RequestParam String password, @RequestParam boolean isNominee, @RequestParam String position) {
		ModelAndView model = new ModelAndView();
		
		
		if(isNominee = true) {
		
			nominee.setName(name);
			nominee.setPosition(position);
			//This will save nominee if the nominee option is checked
			//nomineeRepo.save(nominee);
			
		}else {
			
			votee.setName(name);
			votee.setPassword(password);
			//saves votee information
			//voteeRepo.save(votee);
			
		}
		
		return model;
	}
	
	
	@RequestMapping(value= "/vote*", method= RequestMethod.GET)
	public ModelAndView getNominee() {
		ModelAndView model = new ModelAndView();
		
		//This might not work during testing. Please Verify.
		Iterable<Nominee> nominees = new ArrayList<Nominee>(); 
		nominees =  nomineeRepo.findAll();
			
		model.addObject("nominee", nominees);
			
		
		return model;
	}
	
	@RequestMapping(value= "/vote", method= RequestMethod.POST)
	public ModelAndView getVote(@RequestParam String name) {
		
		ModelAndView model = new ModelAndView();
		
		int vote = 0;
		
		
		//gets nominee by name from JSP that was checked by the user to vote
		nominee = nomineeRepo.getNomineeByName(name);
		
		//adds the vote to the nominee
		vote = nominee.getVotes();
		vote = vote + 1;
		//sets the vots to the nominee
		nominee.setVotes(vote);
		
		//updates the nominee information
		//nomineeRepo.save(nominee);
		
		model.addObject("name", name);
		model.setViewName("index");
		
		return model;
	}

}
