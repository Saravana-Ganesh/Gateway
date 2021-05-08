package com.gateway.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.gateway.bo.EditOrDeleteBo;
import com.gateway.bo.ResponseBo;
import com.gateway.constants.QueryConstants;
import com.gateway.singleton.DatabaseConnection;

public class EditOrDeleteDao {
	public ResponseBo editOrDelete(EditOrDeleteBo editOrDeleteBo) throws SQLException {
		/*
		 * author Saravana Ganesh
		 * created on 23-oct-2019
		 * Purpose:For deleting or editing the question
		 */
		ResponseBo responseBo = new ResponseBo();
		DatabaseConnection db = null;
		PreparedStatement preparedStatement=null;
		try {
			db = DatabaseConnection.getDbConnection();	
			if(editOrDeleteBo.getOperation().equalsIgnoreCase("delete")) {
				preparedStatement = db.con.prepareStatement(QueryConstants.DELETE_QUESTION);
				preparedStatement.setInt(1,1);
				preparedStatement.setInt(2,editOrDeleteBo.getQuestionId());
				
			}else if(editOrDeleteBo.getOperation().equalsIgnoreCase("edit")) {
				preparedStatement = db.con.prepareStatement(QueryConstants.EDIT_QUESTION);
				preparedStatement.setString(1,editOrDeleteBo.getQuestion());
				preparedStatement.setInt(2,editOrDeleteBo.getQuestionId());
			}
			int status = preparedStatement.executeUpdate();
			if(status==1) {
				responseBo.setStatus("1");
			}else {
				responseBo.setStatus("0");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			db.con.close();
			DatabaseConnection.db=null;
		}
		
		return responseBo;
		
	}
}
