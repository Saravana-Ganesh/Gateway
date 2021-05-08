package com.gateway.service;

import java.sql.SQLException;

import com.gateway.bo.AnswerBo;
import com.gateway.bo.ResponseBo;
import com.gateway.dao.AnswerDao;

public class AnswerService {
	public ResponseBo viewAnswer(AnswerBo answerBo) throws SQLException {
		ResponseBo responseBo = new ResponseBo();
		AnswerDao answerDao = new AnswerDao();
		responseBo = answerDao.viewAnswer(answerBo);
		return responseBo;
		
	}
}
