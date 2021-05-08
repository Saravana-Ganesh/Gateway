package com.gateway.service;

import java.sql.SQLException;

import com.gateway.bo.AddanswerBo;
import com.gateway.bo.ResponseBo;
import com.gateway.dao.AddAnswerDao;

public class AddAnswerService {
	public ResponseBo addOrUpdateAnswer(AddanswerBo addanswerBo) {
		ResponseBo responseBo = new ResponseBo();
		AddAnswerDao addAnswerDao = new AddAnswerDao();
		try {
			responseBo = addAnswerDao.addOrUpdateAnswer(addanswerBo);		
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
