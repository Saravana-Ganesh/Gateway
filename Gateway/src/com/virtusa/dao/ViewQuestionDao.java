package com.virtusa.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.virtusa.bo.ResponseBo;
import com.virtusa.bo.ViewQuestionBo;
import com.virtusa.constants.QueryConstants;
import com.virtusa.constants.TableConstants;
import com.virtusa.singleton.DatabaseConnection;

public class ViewQuestionDao {
	public ResponseBo viewQuestion() throws SQLException {
		ResponseBo responseBo = new ResponseBo();	
		ViewQuestionBo viewQuestionBo = new ViewQuestionBo();
		List<ViewQuestionBo> questionList = new ArrayList<ViewQuestionBo>();
    	Gson gson = new Gson();
		DatabaseConnection db = null;
		PreparedStatement preparedStatement; 
		try {
			db = DatabaseConnection.getDbConnection();						
			preparedStatement = db.con.prepareStatement(QueryConstants.TIMELINE_QUESTIONS);
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()) {
			/*	ViewQuestionBo viewQuestionBo = new ViewQuestionBo();*/
				viewQuestionBo.setName(rs.getString(TableConstants.NAME));
				viewQuestionBo.setQuestionId(rs.getInt(TableConstants.QUESTION_Id));
				viewQuestionBo.setQuestion(rs.getString(TableConstants.QUESTION));
				questionList.add(viewQuestionBo);
			}
			responseBo.setQuestionData(questionList);
			responseBo.setStatus("1");
			String json = gson.toJson(responseBo);
			System.out.println(json);
						
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			db.con.close();
			DatabaseConnection.db=null;
		}
		return responseBo;
		
	}
}
