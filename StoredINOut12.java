package com.riya;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Types;
import java.util.Scanner;
import java.sql.CallableStatement;

public class StoredINOut12{
	
	static String url= "jdbc:mysql://localhost:3306/jdbc";
	static String uname = "root";
	static String pass = "root";
	static Scanner scan = new Scanner (System.in);
	static Connection connection = null;
	
	
	
	
	
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(url, uname, pass);
			CallableStatement prepareCall = connection.prepareCall("{call emp(?,)}");

			
			
			System.out.println("Enter the amount");
			String amt = scan.next();
			prepareCall.setString(1,amt);
			prepareCall.registerOutParameter(1,Types.INTEGER);
			
			prepareCall.execute();
			int res = prepareCall.getInt(1);
			System.out.println(res);
			
			
		} catch (Exception e) {
		e.printStackTrace();
	}
}
}