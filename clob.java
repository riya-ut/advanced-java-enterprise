package com.riya;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Types;
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileReader;
import java.sql.CallableStatement;

public class clob{
	
	static String url= "jdbc:mysql://localhost:3306/jdbc";
	static String uname = "root";
	static String pass = "root";
	static Scanner scan = new Scanner (System.in);
	static Connection connection = null;
	
	
	
	
	
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(url, uname, pass);
			PreparedStatement statement = connection.prepareStatement("UPDATE employee SET intro = ? WHERE id = ?");
			System.out.println("Enter the id");
			statement.setInt(2, scan.nextInt());
			FileReader fr = new FileReader("D:\\SKILLS\\Java learning\\src\\AdvJava\\JdbcCrud\\myIntro.txt");
			statement.setCharacterStream(1, fr);
			System.out.println(statement.executeUpdate());
			
			
		} catch (Exception e) {
		e.printStackTrace();
	}
}
}