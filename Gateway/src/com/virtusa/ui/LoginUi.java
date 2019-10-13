package com.virtusa.ui;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.virtusa.bo.LoginBo;
import com.virtusa.service.LoginService;
import com.virtusa.utils.StringUtils;

public class LoginUi extends HttpServlet {
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException {
		LoginBo loginBo = new LoginBo();
		LoginService loginService = new LoginService();
		String email,password;
		email = request.getParameter("email");
		password = request.getParameter("password");
		if(!StringUtils.isNullOrEmpty(email)&&!StringUtils.isNullOrEmpty(password)) {
			loginBo.setEmail(email);
			loginBo.setPassword(password);
			if(loginService.checkUserLogin(loginBo)) {
				 HttpSession session=request.getSession();  
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
}
