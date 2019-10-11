package com.virtusa.dao;

import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.CallableStatement;

import com.virtusa.bo.SignupBo;
import com.virtusa.constants.PlSqlConstants;
import com.virtusa.constants.TableConstants;
import com.virtusa.singleton.DatabaseConnection;

public class SignupDao {
	public void addNewUser(SignupBo signupBo) throws SQLException {
		DatabaseConnection db = null;
		int count=0;
		try {
			db = DatabaseConnection.getDbConnection();
			StringBuilder query = new StringBuilder();
			query.append("Insert into "+TableConstants.USER_PROFILE+" (");
			query.append(TableConstants.NAME+","+TableConstants.EMAIL+","
		    +TableConstants.PASSWORD+","+TableConstants.PHONE_NUMBER+") ");
			query.append("values(?,?,?,?)");
			PreparedStatement preparedStatement = db.con.prepareStatement(query.toString());
			preparedStatement.setString(1,signupBo.getUserName());
			preparedStatement.setString(2, signupBo.getEmail());
			preparedStatement.setLong(3, signupBo.getPassword());
			preparedStatement.setString(4, signupBo.getPhoneNumber());
		    count= preparedStatement.executeUpdate();
			if(count!=0) {
				CallableStatement callableStatement = db.con.prepareCall ("begin "+PlSqlConstants.IDENTITY_INSERT_USER_PROFILE+";end;");
				callableStatement.execute ();
			}
			System.out.println("Number of rows affected--->"+count);
		}catch(Exception e)
		{
			e.printStackTrace();
		}finally
		{
			db.con.close();
			DatabaseConnection.db=null;
		}

	}

}