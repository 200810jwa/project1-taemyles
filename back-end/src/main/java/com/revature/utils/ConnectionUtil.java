package com.revature.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
 * The Connection utility class that is designed to obtain a Connection to the database
 * is often structured as a Singleton
 */
public class ConnectionUtil {

	private static Connection conn = null;
	
	private ConnectionUtil() {
		super();
	}
	
	public static Connection getConnection() {
		try {
			if(conn != null && !conn.isClosed()) {
				return conn;
			}
		} catch(SQLException e) {
			e.printStackTrace();
			System.out.println("WE FAILED TO REUSE A CONNECTION");
			return null;
		}
		
		String url = System.getenv("DB_URL");
		String username = System.getenv("DB_USERNAME");
		String password = System.getenv("DB_PASSWORD");
		
		try {
			Class.forName("org.postgresql.Driver");
			conn = DriverManager.getConnection(url, username, password);
		} catch(SQLException | ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("WE FAILED TO GET A CONNECTION!");
			return null;
		}
		
		return conn;
	}
}
