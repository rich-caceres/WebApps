package com.snhu.FlightBookingApp.Filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;

@Component
public class ErrorHandleFilter implements Filter {
	

	@Override
	public void destroy() {
		// ...
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		//
	}

	//Sends the user to the login page
	@Override
	public void doFilter(ServletRequest req, 
               ServletResponse res, FilterChain chain)
		throws IOException, ServletException {

		HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
		
		HttpSession session = request.getSession(true);
		
		if(session != null && session.getAttribute("user") != null) {
			
			chain.doFilter(request, response);
		
		} else {
		
			response.sendRedirect("login");

		}

	}
}
