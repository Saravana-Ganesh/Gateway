package com.virtusa.dao;

import java.sql.PreparedStatement;
import com.virtusa.bo.AddQuestionBo;
import com.virtusa.bo.ResponseBo;
import com.virtusa.constants.TableConstants;
import com.virtusa.singleton.DatabaseConnection;

public class AddQuestionDao {
	public ResponseBo addQuestion(AddQuestionBo addQuestionBo) {
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
			query.append("INSERT INTO "+TableConstants.QUESTION_SPOT+"("+TableConstants.QUSESTION_SPOT_EMAIL+",");
			query.append(TableConstants.QUESTION+","+TableConstants.QUESTION_Id+")VALUES(?,?,?)");
			PreparedStatement preparedStatement = db.con.prepareStatement(query.toString());
			preparedStatement.setString(1,addQuestionBo.getSession_email());
			preparedStatement.setString(2,addQuestionBo.getQuestion());
			preparedStatement.setInt(3,0);
			count = preparedStatement.executeUpdate();
			if(count!=0) {
				System.out.print("inserted rows-->"+count);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		responseBo.setStatus("1");
		return responseBo;
	}
}
