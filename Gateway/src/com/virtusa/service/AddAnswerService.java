package com.virtusa.service;

import java.sql.SQLException;

import com.virtusa.bo.AddanswerBo;
import com.virtusa.bo.ResponseBo;
import com.virtusa.dao.AddAnswerDao;

public class AddAnswerService {
	public ResponseBo addAnswer(AddanswerBo addanswerBo) {
		ResponseBo responseBo = new ResponseBo();
		AddAnswerDao addAnswerDao = new AddAnswerDao();
		try {
			responseBo = addAnswerDao.addAnswer(addanswerBo);
		} catch (SQLException e) {			
			e.printStackTrace();
		}
		return responseBo;
		
	}

	public ResponseBo checkAnswerExists(AddanswerBo addanswerBo) {

		ResponseBo responseBo = new ResponseBo();
		AddAnswerDao addAnswerDao = new AddAnswerDao();
		try {
			responseBo = addAnswerDao.checkAnswerExists(addanswerBo);
		} catch (SQLException e) {			
			e.printStackTrace();
		}
		return responseBo;
		
	}

}
