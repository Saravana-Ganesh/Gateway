package com.virtusa.service;

import java.sql.SQLException;

import com.virtusa.bo.AnswerBo;
import com.virtusa.bo.ResponseBo;
import com.virtusa.dao.AnswerDao;

public class AnswerService {
	public ResponseBo viewAnswer(AnswerBo answerBo) throws SQLException {
		ResponseBo responseBo = new ResponseBo();
		AnswerDao answerDao = new AnswerDao();
		responseBo = answerDao.viewAnswer(answerBo);
		return responseBo;
		
	}
}
