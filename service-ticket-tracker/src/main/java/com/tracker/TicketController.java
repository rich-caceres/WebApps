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
	protected User currentUser;
	protected Map<Integer, User> userList = new LinkedHashMap<>();
	//back button variable to redirect the page
	protected String page = "";
	
	//Default method
	@RequestMapping(value= "/")
	public ModelAndView landingPage() {
		
		ModelAndView landingPage = new ModelAndView();
		landingPage.setViewName("LoginPage");
		return landingPage;
		
	}
	
	//login success method
	@RequestMapping(value= "/loginSuccess")
	public ModelAndView loggedIn() {

		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy"); //used to format the date
		Date theDate = new Date(); //creates a date object
		ModelAndView landingPage = new ModelAndView();
		landingPage.addObject("date", formatter.format(theDate));
		landingPage.setViewName("index");
		
		return landingPage;
	}
	
	//Create user method
	@RequestMapping(value= "/createUser")
	public ModelAndView createUser() {
		
		ModelAndView model = new ModelAndView();
		
		model.setViewName("UserCreation");
		return model;
		
	}
	
	@RequestMapping(value="/createUser*")
	public ModelAndView createUserAction(){
		
		ModelAndView model = new ModelAndView();
		currentUser = new User("Rich", "Caceres", 71, "Firefighter", "something");
		userList.put(currentUser.getBadgeNum(), currentUser);
		model.setViewName("redirect:/");
		return model;
		
	}
	
	
	//Method to submit tickets
	@RequestMapping(value= "/submitTicket")
	public ModelAndView ticketSubmitted(@RequestParam String name, 
		@RequestParam String vehicle, @RequestParam String subject, @RequestParam String content) {
		
		SupportTicket ticket = new SupportTicket(name, vehicle, subject, content);

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
	//Return list of tickets created during runtime
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
	
	//retrieves tickets in the map table for viewing
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
		
		//changes the status from sent to read when the Mechanic user clicks on the ticket
		//if (this.currentUser.getJobFunction().equals("Mechanic") && ticket.getStatus()!= StatusEnum.Complete) {
			
			//ticket.setStatus(StatusEnum.Read);
			
		//}
		
		model.addObject("status", ticket.getStatus());
		model.setViewName("TicketView");
		return model;
	}
	
	//Back button implementation
	@RequestMapping(value="/back")
	public ModelAndView backButton(){
		ModelAndView model = new ModelAndView();
		model.setViewName(page);
		return model;
	}
	
}
