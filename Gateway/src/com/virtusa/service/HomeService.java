package com.virtusa.service;

import java.sql.SQLException;

import com.virtusa.bo.HomeBo;
import com.virtusa.bo.ResponseBo;
import com.virtusa.dao.HomeDao;

public class HomeService {
	public ResponseBo getUserInfo(HomeBo homeBo) {
		HomeDao homeDao = new HomeDao();
		ResponseBo responseBo = new ResponseBo();
		try {
			responseBo = homeDao.getUserInfo(homeBo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return responseBo;
	}

}
