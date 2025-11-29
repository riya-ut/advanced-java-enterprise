package com.riya;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Launch {

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/jdbc";
		String username = "root";
		String password = "root";
		Connection connection = null;
		Statement statement = null;
		String  query = "UPDATE employee SET salary = salary+10000 WHERE department = 'IT'"; 
		
	
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver loaded");
			connection = DriverManager.getConnection(url, username, password); //to create connection use get connection method from DriverMaanger class
			System.out.println("Connection sucess");
			statement = connection.createStatement();
			int n=statement.executeUpdate(query);
			System.out.println(n);
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	
	}

}
