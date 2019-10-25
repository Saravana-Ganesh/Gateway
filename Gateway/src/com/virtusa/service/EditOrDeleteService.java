package com.virtusa.service;

import java.sql.SQLException;

import com.virtusa.bo.EditOrDeleteBo;
import com.virtusa.bo.ResponseBo;
import com.virtusa.dao.EditOrDeleteDao;

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
