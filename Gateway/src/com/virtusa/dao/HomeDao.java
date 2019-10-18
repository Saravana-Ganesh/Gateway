package com.virtusa.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.virtusa.bo.HomeBo;
import com.virtusa.bo.ResponseBo;
import com.virtusa.constants.TableConstants;
import com.virtusa.singleton.DatabaseConnection;

public class HomeDao {	
	public ResponseBo getUserInfo(HomeBo homeBo) throws SQLException {
		/*
		 * author Saravana Ganesh
		 * created on 16-oct-2019
		 */
		ResponseBo responseBo = new ResponseBo();
		DatabaseConnection db = null;
		String sessionName = null;
		try {
			db = DatabaseConnection.getDbConnection();
			StringBuilder query = new StringBuilder();			
			query.append("SELECT "+TableConstants.NAME+" FROM "+TableConstants.USER_PROFILE+" ");
			query.append(" Where "+TableConstants.EMAIL+"=?");
			PreparedStatement preparedStatement = db.con.prepareStatement(query.toString());
			preparedStatement.setString(1,homeBo.getSessionEmail());
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()) {
				sessionName = rs.getString(TableConstants.NAME);
			}
			responseBo.setSessionName(sessionName);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			db.con.close();
			DatabaseConnection.db=null;
		}
		return responseBo;
	}
}
