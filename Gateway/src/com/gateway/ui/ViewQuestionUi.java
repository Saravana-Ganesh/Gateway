package com.gateway.ui;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gateway.bo.ResponseBo;
import com.gateway.service.ViewQuestionService;
import com.gateway.utils.StringUtils;
import com.google.gson.Gson;

public class ViewQuestionUi extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		ResponseBo responseBo= new ResponseBo();
		Gson gson = new Gson();
		ViewQuestionService viewQuestionService = new ViewQuestionService();
			responseBo = viewQuestionService.viewQuestion();
			//Setting response
			String jsonResponse = gson.toJson(responseBo);
		    response.setContentType("text/plain");
		    response.setCharacterEncoding("UTF-8"); 
		    response.getWriter().write(jsonResponse); 
	}

}
