package com.virtusa.singleton;
import java.sql.Connection;
import java.sql.DriverManager;

import com.virtusa.constants.DBConstants;  

public class DatabaseConnection {
	public  Connection con = null;
	public static  DatabaseConnection db = null;
	private DatabaseConnection(){		
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
