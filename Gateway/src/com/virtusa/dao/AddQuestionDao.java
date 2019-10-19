package com.virtusa.dao;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.virtusa.bo.AddQuestionBo;
import com.virtusa.bo.ResponseBo;
import com.virtusa.constants.PlSqlConstants;
import com.virtusa.constants.TableConstants;
import com.virtusa.singleton.DatabaseConnection;

public class AddQuestionDao {
	public ResponseBo addQuestion(AddQuestionBo addQuestionBo) throws SQLException {
		/*
		 * author Saravana Ganesh
		 * created on 17-oct-2019
		 */
		ResponseBo responseBo = new ResponseBo();
		DatabaseConnection db = null;
		try {
			db = DatabaseConnection.getDbConnection();
			StringBuilder query = new StringBuilder();
			int count=0;
			query.append("INSERT INTO "+TableConstants.QUESTION_MASTER+"("+TableConstants.QUESTION_MASTER_EMAIL+",");
			query.append(TableConstants.QUESTION+","+TableConstants.QUESTION_Id+")VALUES(?,?,?)");
			PreparedStatement preparedStatement = db.con.prepareStatement(query.toString());
			preparedStatement.setString(1,addQuestionBo.getSession_email());
			preparedStatement.setString(2,addQuestionBo.getQuestion());
			preparedStatement.setInt(3,0);
			count = preparedStatement.executeUpdate();
			if(count==1) {
				System.out.println("inserted rows-->"+count);
				CallableStatement callableStatement = db.con.prepareCall ("begin "+PlSqlConstants.IDENTITY_INSERT_QUESTION_MASTER+";end;");
				callableStatement.execute ();
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
