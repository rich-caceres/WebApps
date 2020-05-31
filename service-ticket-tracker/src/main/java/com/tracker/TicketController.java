package com.tracker;
//Java imports
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
//Spring imports
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
//JSON imports
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
//POJO imports
import com.tracker.pojo.SupportTicket;



@Controller
public class TicketController {
	
	//This is only used to check functionality, will change when database is used.
	ArrayList<SupportTicket> ticketList = new ArrayList<>();
	protected volatile int TICKET_ID_SEQ= 1;
	protected Map<Integer, SupportTicket> ticketData= new LinkedHashMap<>();
	
	
	@RequestMapping(value= "/")
	public ModelAndView landingPage() {
		
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
		model.setViewName("index");
		return model;
		
	}
	
	//Will return list of tickets when database is implemented
	@RequestMapping(value= "/listOfTickets")
	public ModelAndView ticketList() throws JsonProcessingException {
		
		Map<String, ArrayList<SupportTicket>> vehicleLists = new LinkedHashMap<>();
		ModelAndView model = new ModelAndView();
		
		//this does not work will try something different to list all vehicles in categories
		for(int key : ticketData.keySet()) {
			ArrayList<SupportTicket> engine1List = new ArrayList<>();
			ArrayList<SupportTicket> engine2List = new ArrayList<>();
			ArrayList<SupportTicket> engine4List = new ArrayList<>();
			ArrayList<SupportTicket> engine5List = new ArrayList<>();
			ArrayList<SupportTicket> engine6List = new ArrayList<>();
			ArrayList<SupportTicket> tower2List = new ArrayList<>();
			ArrayList<SupportTicket> ladder1List = new ArrayList<>();
			ArrayList<SupportTicket> car1List = new ArrayList<>();
			ArrayList<SupportTicket> car2List = new ArrayList<>();
			
			SupportTicket ticket = ticketData.get(key);
			if(ticket.getVehicle().equalsIgnoreCase("Engine 1")) {
				engine1List.add(ticket);
			}else if(ticket.getVehicle().equalsIgnoreCase("Engine 2")) {
				engine2List.add(ticket);
			}else if(ticket.getVehicle().equalsIgnoreCase("Engine 4")) {
				engine4List.add(ticket);
			}else if(ticket.getVehicle().equalsIgnoreCase("Engine 5")) {
				engine5List.add(ticket);
			}else if(ticket.getVehicle().equalsIgnoreCase("Engine 6")) {
				engine6List.add(ticket);
			}else if(ticket.getVehicle().equalsIgnoreCase("Tower Ladder 2")) {
				tower2List.add(ticket);
			}else if(ticket.getVehicle().equalsIgnoreCase("Ladder 1")) {
				ladder1List.add(ticket);
			}else if(ticket.getVehicle().equalsIgnoreCase("Car 1")) {
				car1List.add(ticket);
			}else if(ticket.getVehicle().equalsIgnoreCase("Car 2")) {
				car2List.add(ticket);
			}
			vehicleLists.put("E1", engine1List);
			vehicleLists.put("E2", engine2List);
			vehicleLists.put("E4", engine4List);
			vehicleLists.put("E5", engine5List);
			vehicleLists.put("TL2", tower2List);
			vehicleLists.put("L1", ladder1List);
			vehicleLists.put("C1", car1List);
			vehicleLists.put("C2", car2List);
			model.addObject("E1", engine1List);
		}
		
		
		
		model.setViewName("TicketList");
		
	 return model;
	}

}
