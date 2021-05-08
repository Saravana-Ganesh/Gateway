package com.gateway.service;

import java.sql.SQLException;

import com.gateway.bo.SignupBo;
import com.gateway.dao.SignupDao;

public class SignupService {
	public boolean addNewUser(SignupBo signupBo) {
		/*
		 * author Saravana Ganesh
		 * created on 11-oct-2019
		 */
		SignupDao signupDao = new SignupDao();
		boolean addUser = false;
		try {
			addUser = signupDao.addNewUser(signupBo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return addUser;
	}

}