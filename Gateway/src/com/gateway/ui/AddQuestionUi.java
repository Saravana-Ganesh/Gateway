package com.gateway.ui;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gateway.bo.AddQuestionBo;
import com.gateway.bo.ResponseBo;
import com.gateway.service.AddQuestionService;
import com.gateway.utils.StringUtils;

public class AddQuestionUi extends HttpServlet{
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException {
		AddQuestionBo addQuestionBo = new AddQuestionBo();
		ResponseBo responseBo = new ResponseBo();
		AddQuestionService addQuestionService = new AddQuestionService();
		//Get rparams 
		String question = request.getParameter("question");
		String session_email = request.getParameter("session_email");
		if(!StringUtils.isNullOrEmpty(question)) {
			addQuestionBo.setQuestion(question);
			addQuestionBo.setSession_email(session_email);
			responseBo = addQuestionService.addQuestion(addQuestionBo);
			//Setting response
		    response.setContentType("text/plain");
		    response.setCharacterEncoding("UTF-8"); 
		    response.getWriter().write(responseBo.getStatus());  
		}
		
	}

}
