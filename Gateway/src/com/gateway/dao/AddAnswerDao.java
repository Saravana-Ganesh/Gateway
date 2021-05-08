package com.gateway.dao;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.gateway.bo.AddanswerBo;
import com.gateway.bo.ResponseBo;
import com.gateway.constants.PlSqlConstants;
import com.gateway.constants.QueryConstants;
import com.gateway.constants.TableConstants;
import com.gateway.singleton.DatabaseConnection;

public class AddAnswerDao {
	public ResponseBo addOrUpdateAnswer(AddanswerBo addanswerBo) throws SQLException {
		ResponseBo responseBo = new ResponseBo();
		PreparedStatement preparedStatement = null;
		DatabaseConnection db = null;
		try {
			int count=0;
			db = DatabaseConnection.getDbConnection();
			if(addanswerBo.getType().equalsIgnoreCase("add")) {
				preparedStatement = db.con.prepareStatement(QueryConstants.INSERT_ANSWER);	
			}else if(addanswerBo.getType().equalsIgnoreCase("update")) {
				preparedStatement = db.con.prepareStatement(QueryConstants.UPDATE_ANSWER);	
			}
			preparedStatement.setString(1,addanswerBo.getAnswer());
			preparedStatement.setInt(2,addanswerBo.getQuestionId());
			preparedStatement.setString(3,addanswerBo.getEmail());			
			count = preparedStatement.executeUpdate();
			if(count!=0) {
				if(addanswerBo.getType().equalsIgnoreCase("add")) {
					CallableStatement callableStatement = db.con.prepareCall ("begin "+PlSqlConstants.IDENTITY_INSERT_ANSWER_MASTER+";end;");
					callableStatement.execute ();
				}
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

	public ResponseBo checkAnswerExists(AddanswerBo addanswerBo) throws SQLException {

		ResponseBo responseBo = new ResponseBo();
		DatabaseConnection db = null;
		try {
			db = DatabaseConnection.getDbConnection();
			PreparedStatement preparedStatement = db.con.prepareStatement(QueryConstants.CHECK_ANSWER);
			preparedStatement.setString(1,addanswerBo.getEmail());
			preparedStatement.setInt(2,addanswerBo.getQuestionId());
			ResultSet resultset = preparedStatement.executeQuery();
			if(resultset.next()) {
				responseBo.setAnswer(resultset.getString(TableConstants.ANSWER));
				responseBo.setStatus("1");
			}
			else{
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
