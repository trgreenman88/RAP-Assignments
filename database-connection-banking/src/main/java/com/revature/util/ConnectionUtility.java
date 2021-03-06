package com.revature.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectionUtility {
	private static final String CONNECTION_USERNAME = "postgres"; 
	private static final String CONNECTION_PASSWORD = "Falcons88!"; 
	// Connection URL follows this format:
	//Protocol:// localhost or ip address or domain name:port number / database name
	//jdbc:postgresql://localhost:5432/database_name
	private static final String CONNECTION_URL = "jdbc:postgresql://localhost:5432/banking_application" ; 
	
	public String getUsername() {
		return CONNECTION_USERNAME;
	}

	public String getPassword() {
		return CONNECTION_PASSWORD;
	}
	
	public String getUrl() {
		return CONNECTION_URL;
	}
	
	public static void main(String[] args) {
		/*
		 * This code is responsible for registering the driver.
		 * The driver being the supporting code that enables the jdbc connection.
		 */
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			//If the class is not found the driver could not be registered. 
			System.out.println("Could not register driver!");
			e.printStackTrace();
		}
		
		/*
		 * Create a connection object. 
		 * Use the DriverManager and the appropriate connection credentials. 
		 * 
		 * This may throw a SQL exception. 
		 */
		try {
			Connection connection = DriverManager.getConnection(CONNECTION_URL, CONNECTION_USERNAME, CONNECTION_PASSWORD);
			System.out.println("Connection is valid "+connection.isValid(5));
			
		}catch(SQLException ex) {
			System.out.println("Failure");
			ex.printStackTrace();
		}
	}
		
	public void registerDriver() {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			//If the class is not found the driver could not be registered. 
			System.out.println("Could not register driver!");
			e.printStackTrace();
		}
	}
	
	public Connection createConnection() {
		try{
			ConnectionUtility connectionInfo = new ConnectionUtility();
			Connection connection = DriverManager.getConnection(connectionInfo.getUrl(), 
					connectionInfo.getUsername(), connectionInfo.getPassword());
			return connection;
		} catch(SQLException ex){
			System.out.println("Failure");
			ex.printStackTrace();
			return null;
		}
		
	}

}
