package com.gateway.service;

import java.sql.SQLException;

import com.gateway.bo.HomeBo;
import com.gateway.bo.ResponseBo;
import com.gateway.dao.HomeDao;

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
