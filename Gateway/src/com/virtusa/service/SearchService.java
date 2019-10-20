package com.virtusa.service;

import java.sql.SQLException;

import com.virtusa.bo.ResponseBo;
import com.virtusa.bo.SearchBo;
import com.virtusa.dao.SearchDao;

public class SearchService {	
	public ResponseBo search(SearchBo searchBo) {
		ResponseBo responseBo = new ResponseBo();
		SearchDao searchDao = new SearchDao();
		try {
			responseBo = searchDao.wholeSearch(searchBo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return responseBo;
	}

}
