package com.virtusa.service;

import java.sql.SQLException;

import com.virtusa.bo.ResponseBo;
import com.virtusa.dao.ViewQuestionDao;

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
