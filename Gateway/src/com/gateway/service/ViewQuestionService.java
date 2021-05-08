package com.gateway.service;

import java.sql.SQLException;

import com.gateway.bo.ResponseBo;
import com.gateway.dao.ViewQuestionDao;

public class ViewQuestionService {
	public ResponseBo viewQuestion() {
		ResponseBo responseBo = new ResponseBo();
		ViewQuestionDao viewQuestionDao = new ViewQuestionDao();
		try {
			responseBo = viewQuestionDao.viewQuestion();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return responseBo;		
	}

}
