package com.wrox.MathServlet;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(
        name = "mathServlet",
        urlPatterns = {"/maths"},
        loadOnStartup = 1
)

public class MathServlet extends HttpServlet{
	
	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {

		
		this.math(request, response);
		
    }
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		this.math(request, response);
	}
	
	
	private void math(HttpServletRequest request, HttpServletResponse response) 
					throws ServletException, IOException{
		
		int num1 = 6;
		int num2 = 4;
		
		int num3 = num1 * num2;
		
		RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
		request.setAttribute("num3", num3);
		rd.forward(request, response);
		
	}
	
}