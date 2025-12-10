package com.riya;

import java.sql.Connection;
import java.util.Scanner;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Delete6 {

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/jdbc";
		String username = "root";
		String password = "root";
		Connection connection = null;
		Statement statement1= null;
		PreparedStatement statement2 = null;
		ResultSet res = null;
		String  query1 = "DELETE FROM employee WHERE department = ?";
		String query2 = "SELECT *FROM employee";
		Scanner scan = new Scanner(System.in);
		
	
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(url, username, password); //to create connection use get connection method from DriverMaanger class
			statement1 = connection.createStatement();
			display(statement1,res,query2);
			System.out.println("---------------------------------------------------------------");
			
			statement2 = connection.prepareStatement(query1);
			System.out.println("Enter the department to delete");
			String dept = scan.next();
			System.out.println("---------------------------------------------------------------");
			statement2.setString(1, dept);
			statement2.executeUpdate();
			
			
			
			display(statement1,res,query2);
			
			
			
				
			
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	
	}
public static void display(Statement statement1, ResultSet res, String query2 ) {
	try {
		res = statement1.executeQuery(query2);
		System.out.println("---------------------------------------------------------------");
		while(res.next()) {
			System.out.printf("%-2d | %-11s | %-20s | %-10s | %d\n",res.getInt("id"),res.getString("name"), res.getString("email"),res.getString("department"),res.getInt("salary"));
		}
		System.out.println("---------------------------------------------------------------");
	} catch (SQLException e) {
		e.printStackTrace();
	}
	

}
}
//+" "++" "++" "++ " "+
