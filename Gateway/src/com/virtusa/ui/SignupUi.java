package com.virtusa.ui;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.virtusa.bo.SignupBo;
import com.virtusa.service.SignupService;
import com.virtusa.utils.StringUtils;

public class SignupUi extends HttpServlet {
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException {
		/*
		 * author Saravana Ganesh
		 * created on 12-oct-2019
		 */
		SignupBo signupBo = new SignupBo();
		SignupService service = new SignupService();
		String name,email,password,phoneNumber;
		//Getting rparams
		name = request.getParameter("userName");
		email = request.getParameter("email");
		password = request.getParameter("password");
		phoneNumber = request.getParameter("phoneNumber");
		//Validation
		if(!StringUtils.isNullOrEmpty(name)&&!StringUtils.isNullOrEmpty(email)&&
				!StringUtils.isNullOrEmpty(password)&&!StringUtils.isNullOrEmpty(phoneNumber)) {
			signupBo.setUserName(name);
			signupBo.setEmail(email);
			signupBo.setPassword(password);
			signupBo.setPhoneNumber(phoneNumber);
			if(service.addNewUser(signupBo)) {
				//Successfully created new user
				 HttpSession session=request.getSession();
				 session.setAttribute("email",email); //Set session
			     response.setContentType("text/plain");
			     response.setCharacterEncoding("UTF-8"); 
			     response.getWriter().write("1");   
			}else {//User Already Exists
				 response.setContentType("text/plain");
			     response.setCharacterEncoding("UTF-8"); 
			     response.getWriter().write("0");   
			}
		}else {
			throw new NullPointerException("Null or Empty String");
		}
	}
}
