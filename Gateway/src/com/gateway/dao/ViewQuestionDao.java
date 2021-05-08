package com.gateway.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gateway.bo.ResponseBo;
import com.gateway.bo.ViewQuestionBo;
import com.gateway.constants.QueryConstants;
import com.gateway.constants.TableConstants;
import com.gateway.singleton.DatabaseConnection;
import com.google.gson.Gson;

public class ViewQuestionDao {
	public ResponseBo viewQuestion() throws SQLException {
		ResponseBo responseBo = new ResponseBo();	
		List<ViewQuestionBo> questionList = new ArrayList<ViewQuestionBo>();
    	Gson gson = new Gson();
		DatabaseConnection db = null;
		PreparedStatement preparedStatement; 
		try {
			db = DatabaseConnection.getDbConnection();						
			preparedStatement = db.con.prepareStatement(QueryConstants.TIMELINE_QUESTIONS);
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()) {
				ViewQuestionBo viewQuestionBo = new ViewQuestionBo();
				viewQuestionBo.setName(rs.getString(TableConstants.NAME));
				viewQuestionBo.setEmail(rs.getString(TableConstants.EMAIL));
				viewQuestionBo.setQuestion(rs.getString(TableConstants.QUESTION));
				viewQuestionBo.setQuestionId(rs.getInt(TableConstants.QUESTION_Id));
				viewQuestionBo.setAnswer_count(rs.getInt("ANSWER_COUNT"));
				questionList.add(viewQuestionBo);
			}
			responseBo.setQuestionData(questionList);
			responseBo.setStatus("1");
			/*String json = gson.toJson(responseBo);
			System.out.println(json);*/
						
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			db.con.close();
			DatabaseConnection.db=null;
		}
		return responseBo;
		
	}
}
