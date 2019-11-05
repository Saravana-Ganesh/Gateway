package com.virtusa.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.virtusa.bo.AddanswerBo;
import com.virtusa.bo.ResponseBo;
import com.virtusa.constants.QueryConstants;
import com.virtusa.constants.TableConstants;
import com.virtusa.singleton.DatabaseConnection;

public class AddAnswerDao {
	public ResponseBo addAnswer(AddanswerBo addanswerBo) throws SQLException {
		ResponseBo responseBo = new ResponseBo();
		DatabaseConnection db = null;
		try {
			int count=0;
			db = DatabaseConnection.getDbConnection();
			PreparedStatement preparedStatement = db.con.prepareStatement(QueryConstants.INSERT_ANSWER);
			preparedStatement.setString(1,addanswerBo.getEmail());
			preparedStatement.setInt(2,addanswerBo.getQuestionId());
			preparedStatement.setString(3,addanswerBo.getAnswer());
			count = preparedStatement.executeUpdate();
			if(count!=0) {
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
