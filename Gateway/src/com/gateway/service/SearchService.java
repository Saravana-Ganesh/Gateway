package com.gateway.service;

import java.sql.SQLException;

import com.gateway.bo.ResponseBo;
import com.gateway.bo.SearchBo;
import com.gateway.dao.SearchDao;

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
