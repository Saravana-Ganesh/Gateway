package com.gateway.singleton;
import java.sql.Connection;
import java.sql.DriverManager;

import com.gateway.constants.DBConstants;  

public class DatabaseConnection {
	public  Connection con = null;
	public static  DatabaseConnection db = null;
	private DatabaseConnection(){	
		/*
		 * author Saravana Ganesh
		 * created on 10-oct-2019
		 */
		try{  			
			Class.forName(DBConstants.DRIVER_NAME);  //load the driver class  
			//create  the connection object  
			con=DriverManager.getConnection(DBConstants.URL,DBConstants.USERNAME,DBConstants.PASSWORD);			
		}
		catch(Exception e){
			System.out.println(e);
		}		 
	}  
	public static DatabaseConnection getDbConnection() {
		if(db==null) {
			db = new DatabaseConnection();
		}
		return db;
	}
} 