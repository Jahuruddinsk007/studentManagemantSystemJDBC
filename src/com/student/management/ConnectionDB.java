package com.student.management;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionDB {
	
	static Connection con;
	
	public static Connection create() {
		
	
	try {
		Class.forName("com.mysql.jdbc.Driver");
		//creating connection
		String user = "root";
		String password = "bahwan$123";
		String url = "jdbc:mysql://localhost:3306/student_management";
		con = DriverManager.getConnection(url, user, password);
		
		System.out.println("Db connection successfully done.....!");
	}
	
	catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
		}
	return con;
	
	
	}
}
