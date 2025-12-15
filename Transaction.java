package com.riya;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Transaction {
    public static void main(String[] args) {
    	String url = "jdbc:mysql://localhost:3306/jdbc";
    	String uname = "root";
    	String passwd = "root";
    	String querySender ="UPDATE employee SET salary = salary-? WHERE name = ?"; 
    	String queryReceiver ="UPDATE employee SET salary = salary+? WHERE name = ?"; 
    	Connection connection = null;
    	Scanner scan = new Scanner (System.in);
    	PreparedStatement stmt1 = null;
    	PreparedStatement stmt2 = null;
    	
     try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		connection = DriverManager.getConnection(url, uname, passwd);
		System.out.println("Enter the name of the sender");
		String sender = scan.next();
		System.out.println("Enter the name of the Reciever");
		String receiever = scan.next();
		System.out.println("Enter the amount");
		int amount = scan.nextInt();
		//sender
		stmt1 = connection.prepareStatement(querySender);
		stmt1.setInt(1, amount);
		stmt1.setString(2, sender);
		
		//receiver
		stmt2 = connection.prepareStatement(queryReceiver);
		stmt2.setInt(1,amount);
		stmt2.setString(2,receiever);
		
		int n1 = stmt1.executeUpdate();
		int n2 = stmt2.executeUpdate();
	} catch (Exception e) {
		
		e.printStackTrace();
	}
     finally {
    	    // Close Scanner to fix the warning
    	    if (scan != null) {
    	        scan.close();
    	    }
    	    // Close other resources too
    	    try {
    	        if (stmt1 != null) stmt1.close();
    	        if (stmt2 != null) stmt2.close();
    	        if (connection != null) connection.close();
    	    } catch (Exception e) {
    	        e.printStackTrace();
    	    }
    	}

    	



     
    }
}