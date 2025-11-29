package com.riya;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Display {

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/jdbc";
		String username = "root";
		String password = "root";
		Connection connection = null;
		Statement statement = null;
		ResultSet res = null;
		String  query = "Select* FROM `employee` WHERE `department`= 'finance'"; 
		
	
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver loaded");
			connection = DriverManager.getConnection(url, username, password); //to create connection use get connection method from DriverMaanger class
			System.out.println("Connection sucess");
			statement = connection.createStatement();
			res = statement.executeQuery(query);
			while(res.next()) {
				System.out.println(res.getInt("id")+" "+res.getString("name")+" "+res.getString("email")+" "+res.getString("department")+ " "+res.getInt("salary") );
			}
			
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	
	}

}
