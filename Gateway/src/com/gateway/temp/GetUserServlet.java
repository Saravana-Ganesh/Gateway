package com.gateway.temp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
//@WebServlet("/GetUserServlet")
public class GetUserServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.setContentType("text/plain");		
		/*String username = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println("username is "+username+" password is "+password);
		PrintWriter p =  response.getWriter();
		p.print("Hello");
		HttpSession session = request.getSession();
		session.setAttribute("uname", username);
		session.setAttribute("key2","Govind");*/
		RequestDispatcher  rd = request.getRequestDispatcher("secondServlet");
		rd.forward(request, response);
	//	response.sendRedirect("secondServlet");
		}
	}

