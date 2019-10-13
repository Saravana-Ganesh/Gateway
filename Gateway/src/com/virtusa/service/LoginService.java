package com.virtusa.service;

import com.virtusa.bo.LoginBo;
import com.virtusa.dao.LoginDao;

public class LoginService {
	public boolean checkUserLogin(LoginBo loginBo) {
		/*
		 * author Saravana Ganesh
		 * created on 12-oct-2019
		 */
		boolean userVerified=false;
		try {
		LoginDao loginDao = new LoginDao();
		userVerified =  loginDao.validateUser(loginBo);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return userVerified;
	}
}
