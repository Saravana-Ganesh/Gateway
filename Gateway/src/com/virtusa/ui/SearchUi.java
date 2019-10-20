package com.virtusa.ui;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.virtusa.bo.ResponseBo;
import com.virtusa.bo.SearchBo;
import com.virtusa.service.SearchService;

public class SearchUi extends HttpServlet{
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException {
		SearchBo searchBo = new SearchBo();
		ResponseBo responseBo = new ResponseBo();
		SearchService searchService = new SearchService();
		Gson gson = new Gson();
		String searchArray[]=request.getParameterValues("search_array[]");
		searchBo.setSearchValues(searchArray);
		responseBo = searchService.search(searchBo);
		//Setting response
		String jsonResponse = gson.toJson(responseBo);
	    response.setContentType("text/plain");
	    response.setCharacterEncoding("UTF-8"); 
	    response.getWriter().write(jsonResponse);
	}
}
