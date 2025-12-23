package com.riya;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Acid10{
	
	static String url= "jdbc:mysql://localhost:3306/jdbc";
	static String uname = "root";
	static String pass = "root";
	static Scanner scan = new Scanner (System.in);
	static Connection connection = null;
	
	
	
	
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(url, uname, pass);
			connection.setAutoCommit(false);
			transaction();
			} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	public static void transaction() throws Exception {
		System.out.println("Enter the sender");
		String sender = scan.next();
		System.out.println("Enter the receiver");
		String receiver = scan.next();
		System.out.println("Enter the amount");
	    int amount = scan.nextInt();
	    int n1 = update(-amount,sender);
	    int n2 = update(amount,receiver);
	    if(n1==n2)	 {
	    	connection.commit();
	    	System.out.println("Transaction Sucess");//Consistency
	    }
	    else {
	    	connection.rollback();
	    	System.out.println("Transaction Failure");
	    }
	    
    
	    }
	
	public static int update(int amount,String user)throws Exception{
		String sql = "UPDATE employee SET salary = salary+? WHERE name = ?";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1,amount);
		statement.setString(2, user);
		return statement.executeUpdate();
		
		
	}
	
}