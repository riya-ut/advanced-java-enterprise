package com.riya;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Types;
import java.util.Scanner;
import java.io.FileInputStream;
import java.sql.CallableStatement;

public class blob{
	
	static String url= "jdbc:mysql://localhost:3306/jdbc";
	static String uname = "root";
	static String pass = "root";
	static Scanner scan = new Scanner (System.in);
	static Connection connection = null;
	
	
	
	
	
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(url, uname, pass);
			
			PreparedStatement statement = connection.prepareStatement("UPDATE employee SET db = ? WHERE id = ?");
			System.out.println("Enter the id");
			statement.setInt(2, scan.nextInt());
			FileInputStream fis = new FileInputStream("D:\\SKILLS\\Java learning\\src\\AdvJava\\JdbcCrud\\images\\P20250806MR-0248_President_Donald_Trump_delivers_investment_remarks_alongside_Apple_CEO_Tim_Cook_(cropped).jpg");

			statement.setBinaryStream(1,fis);
			System.out.println(statement.executeUpdate());
			
			
			
		} catch (Exception e) {
		e.printStackTrace();
	}
}
}