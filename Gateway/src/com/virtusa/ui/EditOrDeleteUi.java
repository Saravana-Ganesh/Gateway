package com.virtusa.ui;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.virtusa.bo.EditOrDeleteBo;
import com.virtusa.bo.ResponseBo;
import com.virtusa.service.EditOrDeleteService;
import com.virtusa.utils.StringUtils;

public class EditOrDeleteUi extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		EditOrDeleteBo editOrDeleteBo = new EditOrDeleteBo();
		EditOrDeleteService editOrDeleteService = new EditOrDeleteService(); 
		ResponseBo responseBo = new ResponseBo();
		int questionId =  Integer.parseInt(request.getParameter("questionId"));
		String operation = request.getParameter("operation");
		String question = request.getParameter("question");
		if(!StringUtils.isNullOrEmpty(questionId+"")&&!StringUtils.isNullOrEmpty(operation)&&
				!StringUtils.isNullOrEmpty(question)) {
			editOrDeleteBo.setQuestionId(questionId);
			editOrDeleteBo.setOperation(operation);
			editOrDeleteBo.setQuestion(question);
			responseBo = editOrDeleteService.editOrDelete(editOrDeleteBo);
		}					
		//Setting response
	    response.setContentType("text/plain");
	    response.setCharacterEncoding("UTF-8"); 
	    response.getWriter().write(responseBo.getStatus());  
	}

}
