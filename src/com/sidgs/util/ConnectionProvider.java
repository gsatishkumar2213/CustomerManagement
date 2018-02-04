package com.sidgs.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionProvider {
	
	private static Connection connection;
	private static final String URL = "jdbc:mysql://localhost:3306/cam";
	private static final String USER ="root";
	private static final String PASSWORD ="root";
	private ConnectionProvider(){}
	public static Connection getConnection(){
		try{
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(URL,USER,PASSWORD);
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		return connection;
	}

}
