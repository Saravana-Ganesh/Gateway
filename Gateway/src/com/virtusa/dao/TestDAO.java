package com.virtusa.dao;

import java.sql.Statement;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.virtusa.constants.PlSqlConstants;
import com.virtusa.constants.TableConstants;
import com.virtusa.singleton.DatabaseConnection;

public class TestDAO {

	public static void main(String[] args) throws SQLException {
		DatabaseConnection db = null;
		try{		
			db = DatabaseConnection.getDbConnection();
			Statement stmt =db.con.createStatement();  
			StringBuilder query = new StringBuilder();
			query.append("select * from "+TableConstants.LEGEND);
			ResultSet rs=stmt.executeQuery(query.toString());  
			while(rs.next())  {
				System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3)); 
			}
			/*CallableStatement callableStatement = db.con.prepareCall ("begin "+PlSqlConstants.IDENTITY_INSERT_USER_PROFILE+";end;");
			callableStatement.execute ();*/
		}catch(Exception e) {
			e.printStackTrace();
		}finally{
			db.con.close();
		}
	}

}
