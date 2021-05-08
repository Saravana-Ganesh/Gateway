package com.gateway.temp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SecondServlet extends HttpServlet{
	public void service(HttpServletRequest request,HttpServletResponse response) throws IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println("Inside Second servlet");
		System.out.println("username is "+username+" password is "+password);
		PrintWriter p =  response.getWriter();
		p.print("Second servlet");		
		//response.sendRedirect("http://www.google.com");  
		/*HttpSession session = request.getSession();		
		System.out.println(session.getAttribute("uname"));
		System.out.println(session.getAttribute("key2"));*/
	}
}
