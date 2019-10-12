package com.virtusa.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.virtusa.bo.LoginBo;
import com.virtusa.constants.TableConstants;
import com.virtusa.singleton.DatabaseConnection;

public class LoginDao {
	public void validateUser(LoginBo loginBo) throws SQLException {
		/*
		 * author Saravana Ganesh
		 * created on 12-oct-2019
		 */
		DatabaseConnection db = null;
		try {
			db = DatabaseConnection.getDbConnection();
			StringBuilder query = new StringBuilder();
			query.append("SELECT "+TableConstants.EMAIL+","+TableConstants.PASSWORD+" From "+
					TableConstants.USER_PROFILE+" ");
			query.append("WHERE "+TableConstants.EMAIL+"=? AND "+TableConstants.PASSWORD+"=?");
			
			PreparedStatement preparedStatement = db.con.prepareStatement(query.toString());
			preparedStatement.setString(1,loginBo.getEmail());
			preparedStatement.setLong(2,loginBo.getPassword());
			ResultSet rs = preparedStatement.executeQuery();
			if(rs.next()) {
				System.out.println("valid user");
			}
			else {
				System.out.println("Invalid user");
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			db.con.close();
			DatabaseConnection.db=null;
		}
	}
}
