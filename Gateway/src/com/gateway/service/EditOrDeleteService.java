package com.gateway.service;

import java.sql.SQLException;

import com.gateway.bo.EditOrDeleteBo;
import com.gateway.bo.ResponseBo;
import com.gateway.dao.EditOrDeleteDao;

public class EditOrDeleteService {
	public ResponseBo editOrDelete(EditOrDeleteBo editOrDeleteBo) { 
    	 //For delete or edit operation
		ResponseBo responseBo = new ResponseBo();
		EditOrDeleteDao editOrDeleteDao = new EditOrDeleteDao();
		try {
			responseBo = editOrDeleteDao.editOrDelete(editOrDeleteBo);
		} catch (SQLException e) {			
			e.printStackTrace();
		}
		return responseBo;
	}
	

}
