package com.virtusa.service;

import java.sql.SQLException;

import com.virtusa.bo.SignupBo;
import com.virtusa.dao.SignupDao;

public class SignupService {
	public void addNewUser(SignupBo signupBo) {
		SignupDao signupDao = new SignupDao();
		try {
			signupDao.addNewUser(signupBo);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
