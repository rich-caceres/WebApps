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
	//this is now a private string much more secure
	private String previousPage= "";
	
	@Autowired
	VoterRepo voteeRepo;
	
	@Autowired
	NomineeRepo nomineeRepo;
	
	@Autowired
	Nominee nominee;
	
	@Autowired
	Voter votee;
	
	//This is our landing page for the application.
	@RequestMapping(value= {"/", "/greeting"}, method = RequestMethod.GET)
	public ModelAndView helloWorld() {
		//previous page is added here
		String previousPage= "";
		previousPage= "index";
		pageGetter(previousPage); //this is our method to return to the previous page
		
		ModelAndView model = new ModelAndView();
		model.setViewName("index");
		
		return model; 
	}
	
	//this will be used by the admin, this will only be accessible by the admin in spring security when spring security is implemented.
	@RequestMapping(value="/CreateNominee", method = RequestMethod.GET)
	public ModelAndView createNominee(){
		
		ModelAndView model = new ModelAndView();
		//TODO test this implementation
		//TODO add method to create a nominee from existing users and set up JSP's for all views
		ArrayList<Voter> noms= new ArrayList();
		noms =  (ArrayList<Voter>) voteeRepo.findAll();
		
		//Set objects to be shown in the nominee area
		model.addObject("users", noms);
		model.setViewName("NomineeCreation");
		
		return model;
		
	}
	//Assigns the previous page that was seen by the user.
	protected void pageGetter(String previousPage) {
		
		 this.previousPage = previousPage;
	}
	//Returna previous page
	protected String pageReturn() {
		
		return previousPage;
	}
	
	//this is a back button implementation because its just easier. This could change possibly.
	@RequestMapping(value="/back", method = RequestMethod.GET)
	public String backToPreviousPage() {
		
		String previousPage = pageReturn();
		
		return previousPage;
	}
	
	//method to create the user, will be used by all users, only returns the jsp
	@RequestMapping(value="/CreateUser", method = RequestMethod.GET)
	public String voterCreationPage() {
		
		return "userCreation";
	}
	
	//creates a user, disregard the name of the actual method. will be used by the user who is considered the voter
	@RequestMapping(value="/CreateVoter*", method = RequestMethod.POST)
	public ModelAndView createVoter(@RequestParam String name, @RequestParam String password) {
		ModelAndView model = new ModelAndView();
		
			votee.setName(name);
			votee.setPassword(password);
			votee.setUserRole("ROLE_USER");
			//TODO this will save the user information to database
			//saves votee information
			//voteeRepo.save(votee);
			model.setViewName("redirect:/greeting");
		
		return model;
	}
	
	//TODO This method is for voting, still in development does not actualy work yet.
	@RequestMapping(value= "/vote*", method= RequestMethod.GET)
	public ModelAndView getNominee() {
		ModelAndView model = new ModelAndView();
		
		Nominee noms = new Nominee();
		
		noms.setName("Rich");
		noms.setPosition("president");
		noms.setVotes(99);
		
		//This might not work during testing. Please Verify.
		//Iterable<Nominee> nominees = new ArrayList<Nominee>(); 
		//nominees =  nomineeRepo.findAll();
		ArrayList<Nominee> nominees = new ArrayList(); 	
		nominees.add(noms);
		
		model.addObject("data", nominees);
		model.setViewName("index");	
		
		return model;
	}
	//TODO Will be used to return the vote/let the user vote, UNDER DEVELOPMENT STILL
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
