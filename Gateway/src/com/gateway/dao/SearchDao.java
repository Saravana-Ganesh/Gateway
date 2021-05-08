package com.gateway.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gateway.bo.ResponseBo;
import com.gateway.bo.SearchBo;
import com.gateway.constants.QueryConstants;
import com.gateway.constants.TableConstants;
import com.gateway.singleton.DatabaseConnection;
import com.gateway.utils.StringUtils;

public class SearchDao {
	public ResponseBo wholeSearch(SearchBo searchBo) throws SQLException {
		/*
		 * author Saravana Ganesh
		 * created on 20-oct-2019
		 */
		ResponseBo responseBo = new ResponseBo();
		List<SearchBo> searchDataList = new ArrayList<SearchBo>();
		//Gson gson = new Gson();
		DatabaseConnection db = null;
		PreparedStatement preparedStatement;
		String searchText = StringUtils.arrayToString(searchBo.getSearchValues());
		try {
			db = DatabaseConnection.getDbConnection();
			preparedStatement = db.con.prepareStatement(QueryConstants.SEARCH_QUERY);
			preparedStatement.setString(1,"%" + searchText + "%");
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()) {
				searchBo = new SearchBo();
				searchBo.setName(rs.getString(TableConstants.NAME));
				searchBo.setEmail(rs.getString(TableConstants.EMAIL));
				searchBo.setQuestion(rs.getString(TableConstants.QUESTION));	
				searchBo.setQuestionId(rs.getInt(TableConstants.QUESTION_Id));	
				searchDataList.add(searchBo);
				//System.out.println(rs.getString(TableConstants.QUESTION));
			}
			responseBo.setStatus("1");
			responseBo.setSearchData(searchDataList);
			//String json = gson.toJson(responseBo);
			//System.out.println(json);
		}catch(Exception e) {
			e.printStackTrace();			
		}finally {
			db.con.close();
			DatabaseConnection.db=null;
		}
		
		return responseBo;
	}
	public ResponseBo splitSearch(SearchBo searchBo) {
		ResponseBo responseBo = new ResponseBo();
		return responseBo;
	}

}
