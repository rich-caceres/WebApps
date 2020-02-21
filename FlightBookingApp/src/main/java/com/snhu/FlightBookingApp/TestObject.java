package com.snhu.FlightBookingApp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestObject {
	
	@RequestMapping("/test")
	@ResponseBody
	public String test() {
		return "test";
		
	}

}
