package com.virtusa.ui;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.virtusa.bo.HomeBo;
import com.virtusa.bo.ResponseBo;
import com.virtusa.service.HomeService;

public class HomeUi extends HttpServlet{
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException {
		HomeBo homeBo = new HomeBo();
		HomeService homeService = new HomeService();
		ResponseBo responseBo = new ResponseBo();
		String sessionEmail;
		sessionEmail = request.getParameter("session_email");
		homeBo.setSessionEmail(sessionEmail);	
		responseBo = homeService.getUserInfo(homeBo);		
		//Setting response
	    response.setContentType("text/plain");
	    response.setCharacterEncoding("UTF-8"); 
	    response.getWriter().write(responseBo.getSessionName());  
	}
}
