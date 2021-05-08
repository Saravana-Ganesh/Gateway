package com.gateway.ui;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gateway.bo.AnswerBo;
import com.gateway.bo.ResponseBo;
import com.gateway.service.AnswerService;
import com.google.gson.Gson;

public class AnswerUi extends HttpServlet{
	public void doPost(HttpServletRequest request,HttpServletResponse response) {
		ResponseBo responseBo = new ResponseBo();
		Gson gson = new Gson();
		responseBo = viewAnswer(request);
		String jsonResponse = gson.toJson(responseBo);
		response.setContentType("text/plain");
	    response.setCharacterEncoding("UTF-8"); 
	    try {
			response.getWriter().write(jsonResponse);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	private ResponseBo viewAnswer(HttpServletRequest request) {
		//questionId
		ResponseBo responseBo = new ResponseBo();
		AnswerService answerService = new AnswerService();
		AnswerBo answerBo = new AnswerBo();	
		String questionId = request.getParameter("questionId");
		answerBo.setQuestionId(questionId);
		try {
			responseBo = answerService.viewAnswer(answerBo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return responseBo;
	}
}
