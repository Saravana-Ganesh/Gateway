package com.gateway.temp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.gateway.constants.TableConstants;

public class Test {
	public static void main(String[] args) {
		try {
			Context context = new InitialContext();
			DataSource ds   = (DataSource)context.lookup("java/comp/env/myds");
			Connection con  = ds.getConnection();
			Statement stmt  = con.createStatement();  
			StringBuilder query = new StringBuilder();
			query.append("select * from "+TableConstants.LEGEND);
			ResultSet rs=stmt.executeQuery(query.toString());  
			while(rs.next())  {
				System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3)); 
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
