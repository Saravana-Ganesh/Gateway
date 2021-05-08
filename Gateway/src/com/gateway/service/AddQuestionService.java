package com.gateway.service;

import com.gateway.bo.AddQuestionBo;
import com.gateway.bo.ResponseBo;
import com.gateway.dao.AddQuestionDao;

public class AddQuestionService {
	public ResponseBo addQuestion(AddQuestionBo addQuestionBo) {
		/*
		 * author Saravana Ganesh
		 * created on 17-oct-2019
		 */
		ResponseBo responseBo = new ResponseBo();
		try {			
			AddQuestionDao addQuestionDao = new AddQuestionDao();
			responseBo = addQuestionDao.addQuestion(addQuestionBo);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return responseBo;
	}

}
