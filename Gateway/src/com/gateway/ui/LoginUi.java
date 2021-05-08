package com.gateway.ui;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.gateway.bo.LoginBo;
import com.gateway.service.LoginService;
import com.gateway.utils.StringUtils;

public class LoginUi extends HttpServlet {
	
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException {
		LoginBo loginBo = new LoginBo();
		LoginService loginService = new LoginService();
		HttpSession session=request.getSession();
		String email,password;
		email = request.getParameter("email");
		password = request.getParameter("password");
		if(!StringUtils.isNullOrEmpty(email)&&!StringUtils.isNullOrEmpty(password)) {
			loginBo.setEmail(email);
			loginBo.setPassword(password);
			if(loginService.checkUserLogin(loginBo)) {				
			     session.setAttribute("email",email); 
			     //Setting response
			     response.setContentType("text/plain");
			     response.setCharacterEncoding("UTF-8"); 
			     response.getWriter().write("1");    		
			}else {
				//Setting response
				response.getWriter().write("0");
			}
		}else {
			throw new NullPointerException("Null or Empty String");
		}
	}
	
	//Get request
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException{
		String getSession;
		HttpSession session=request.getSession();
		getSession = request.getParameter("session");
		if(!StringUtils.isNullOrEmpty(getSession) && session.getAttribute(getSession)!=null) {
			getSession = session.getAttribute("email").toString();
			response.getWriter().write(getSession);
		}else {
			response.getWriter().write("0");
		}
		
	}
}