package com.virtusa.service;

import com.virtusa.bo.LoginBo;
import com.virtusa.dao.LoginDao;

public class LoginService {
	public void checkUserLogin(LoginBo loginBo) {
		/*
		 * author Saravana Ganesh
		 * created on 12-oct-2019
		 */
		try {
		LoginDao loginDao = new LoginDao();
		loginDao.validateUser(loginBo);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
