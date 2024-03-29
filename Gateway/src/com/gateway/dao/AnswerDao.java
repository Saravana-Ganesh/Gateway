package com.gateway.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gateway.bo.AnswerBo;
import com.gateway.bo.ResponseBo;
import com.gateway.bo.SearchBo;
import com.gateway.constants.QueryConstants;
import com.gateway.constants.TableConstants;
import com.gateway.singleton.DatabaseConnection;

public class AnswerDao {
	public ResponseBo viewAnswer(AnswerBo answerBo) throws SQLException {
		ResponseBo responseBo = new ResponseBo();
		PreparedStatement preparedStatement = null;
		DatabaseConnection db = null;
		List<AnswerBo> AnswerDataList = new ArrayList<AnswerBo>();
		try {
			db = DatabaseConnection.getDbConnection();
			preparedStatement = db.con.prepareStatement(QueryConstants.VIEW_ANSWER);
			System.out.println(QueryConstants.VIEW_ANSWER);
			preparedStatement.setString(1,answerBo.getQuestionId());
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				AnswerBo answerBO = new AnswerBo();
				answerBO.setName(resultSet.getString(TableConstants.NAME));
				answerBO.setEmail(resultSet.getString(TableConstants.ANSWER_MASTER_EMAIL));
				answerBO.setQuestionId(resultSet.getString(TableConstants.ANSWER_MASTER_QUESTION_Id));
				//answerBO.setQuestion(resultSet.getString(TableConstants.QUESTION));
				answerBO.setAnswerId(resultSet.getString(TableConstants.ANSWER_MASTER_ANSWER_Id));
				answerBO.setAnswer(resultSet.getString(TableConstants.ANSWER));
				AnswerDataList.add(answerBO);
			}
			responseBo.setStatus("1");
			responseBo.setAnswerData(AnswerDataList);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			db.con.close();
			DatabaseConnection.db=null;
		}
		
		return responseBo;
	}
}
