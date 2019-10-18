package com.virtusa.service;

import com.virtusa.bo.AddQuestionBo;
import com.virtusa.bo.ResponseBo;
import com.virtusa.dao.AddQuestionDao;

public class AddQuestionService {
	public ResponseBo addQuestion(AddQuestionBo addQuestionBo) {
		/*
		 * author Saravana Ganesh
		 * created on 17-oct-2019
		 */
		ResponseBo responseBo = new ResponseBo();
		try {			
			AddQuestionDao addQuestionDao = new AddQuestionDao();
			addQuestionDao.addQuestion(addQuestionBo);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return responseBo;
	}

}
