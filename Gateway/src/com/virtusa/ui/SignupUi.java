package com.virtusa.ui;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.virtusa.bo.SignupBo;
import com.virtusa.service.SignupService;

public class SignupUi extends HttpServlet {
	public void doPost(HttpServletRequest request,HttpServletResponse response) {
		signupBo(request);
	}
	
	void signupBo(HttpServletRequest request) {
		SignupBo signupBo = new SignupBo();
		signupBo.setUserName(request.getParameter("userName"));
		signupBo.setEmail(request.getParameter("email"));
		signupBo.setPassword(request.getParameter("password"));
		signupBo.setPhoneNumber(request.getParameter("phoneNumber"));
		
		SignupService service = new SignupService();
		service.addNewUser(signupBo);
		
	}
}
