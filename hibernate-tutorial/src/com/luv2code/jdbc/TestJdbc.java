package com.luv2code.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String url="jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false";
		String usr="hbstudent";
		String pass="hbstudent";
		
		try {
			System.out.println("Connecting to database:"+url);
			Connection conn=DriverManager.getConnection(url,usr,pass);
			System.out.println("Connection successfully established!!!");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
