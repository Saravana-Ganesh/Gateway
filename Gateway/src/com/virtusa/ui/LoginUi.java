package com.virtusa.ui;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.virtusa.bo.LoginBo;
import com.virtusa.service.LoginService;
import com.virtusa.utils.StringUtils;

public class LoginUi extends HttpServlet {
	public void doPost(HttpServletRequest request,HttpServletResponse response) {
		LoginBo loginBo = new LoginBo();
		LoginService loginService = new LoginService();
		String name,password;
		name = request.getParameter("email");
		password = request.getParameter("password");
		if(!StringUtils.isNullOrEmpty(name)&&!StringUtils.isNullOrEmpty(password)) {
			loginBo.setEmail(name);
			loginBo.setPassword(password);
			loginService.checkUserLogin(loginBo);
		}else {
			throw new NullPointerException("Null or Empty String");
		}
	}
}
