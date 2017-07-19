package com.revature.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connections {

	private static final String USERNAME = "mini_db";
	private static final String PASSWORD =  "p4ssw0rd";
	private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	protected static Connection connect;
	public static Connection getConnection(){

		try{
			Connection connect =  DriverManager.getConnection(URL,USERNAME,PASSWORD);
			Connections.connect=connect;
	
		} catch (SQLException e) {
			e.printStackTrace();
		}
      

	return connect;	
	}
}
