package com.lp.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	
	public static Connection getConexao() throws ClassNotFoundException, SQLException{
		Class.forName("com.mysql.jdbc.Driver");
		
	    return DriverManager.getConnection("jdbc:mysql://localhost:3306/app-database", "root" , "tatu1715");
		

	}
	
	
	public static void main(String args[]){
		try {
			System.out.println(getConexao());
		} catch (ClassNotFoundException | SQLException  e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
}
