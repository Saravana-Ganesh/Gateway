package com.gateway.ui;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gateway.bo.AddanswerBo;
import com.gateway.bo.ResponseBo;
import com.gateway.service.AddAnswerService;
import com.gateway.utils.StringUtils;
import com.google.gson.Gson;

public class AddAnswerUi extends HttpServlet {
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException {
		ResponseBo responseBo = new ResponseBo(); 
		Gson gson = new Gson();
		if(request.getParameter("purpose").equals("checkAnswerExists")) {
			responseBo = checkAnswerExists(request,response);
		}else {
			responseBo = addOrUpdateAnswer(request,response);
		}
		//Setting response	
		String jsonResponse = gson.toJson(responseBo);
	    response.setContentType("text/plain");
	    response.setCharacterEncoding("UTF-8"); 
	    response.getWriter().write(jsonResponse);
	}
	private ResponseBo checkAnswerExists(HttpServletRequest request, HttpServletResponse response) {
		ResponseBo responseBo = new ResponseBo();
		AddanswerBo addanswerBo = new AddanswerBo();
		AddAnswerService addAnswerService = new AddAnswerService();
		//Get rparams 
		String questionId = request.getParameter("questionId");
		String email = request.getParameter("session_email");
		if(!StringUtils.isNullOrEmpty(questionId)&&!StringUtils.isNullOrEmpty(email)) {
			addanswerBo.setQuestionId(Integer.parseInt(questionId));
			addanswerBo.setEmail(email);
			responseBo = addAnswerService.checkAnswerExists(addanswerBo);
		}		
		return responseBo;
	}
	private ResponseBo addOrUpdateAnswer(HttpServletRequest request,HttpServletResponse response) {
		ResponseBo responseBo = new ResponseBo();
		AddanswerBo addanswerBo = new AddanswerBo();
		AddAnswerService addAnswerService = new AddAnswerService();
		//Get rparams 
		String questionId = request.getParameter("questionId");
		String answer = request.getParameter("answer");
		String email = request.getParameter("session_email");
		String type  = request.getParameter("purpose");
		if(!StringUtils.isNullOrEmpty(questionId)&&!StringUtils.isNullOrEmpty(answer)&&!StringUtils.isNullOrEmpty(questionId)) {
			addanswerBo.setAnswer(answer);
			addanswerBo.setQuestionId(Integer.parseInt(questionId));
			addanswerBo.setEmail(email);
			addanswerBo.setType(type);
			responseBo = addAnswerService.addOrUpdateAnswer(addanswerBo);
		}
		return responseBo;
	}

		
}
