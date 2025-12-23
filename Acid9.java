package com.riya;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Acid9 {
	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/jdbc";
    	String uname = "root";
    	String passwd = "root";
    	Connection connection = null;
    	String sql = "INSERT INTO Employee(id,name,email,department,salary)Values(12,'Monalisa','mona@gamail.com','hr',50000)";
    	Statement stmt;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(url, uname, passwd);
			connection.setAutoCommit(false);
			stmt = connection.createStatement();
			int n = stmt.executeUpdate(sql);
			connection.commit();
			System.out.println(n);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}