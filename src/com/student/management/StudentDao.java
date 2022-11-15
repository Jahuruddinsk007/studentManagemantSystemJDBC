package com.student.management;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

//import com.mysql.cj.xdevapi.Statement;

public class StudentDao {
	
	public static boolean insertStudentToDB(Student st) {
		
		boolean status = false;
		try {
			//jdbc connection
			Connection con = ConnectionDB.create();
			
			String que = "insert into students(sname,sphone,scity) values(?,?,?)";
			
			PreparedStatement pstmt = con.prepareStatement(que);
			
			//set the value of parameter
			
			pstmt.setString(1, st.getStudentName());
			pstmt.setString(2, st.getStudentPhone());
			pstmt.setString(3, st.getStudentCity());
			
			//execute
			
			pstmt.executeUpdate();
			
			status = true;
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return status;
	}

	public static boolean deleteStudent(int studentId) {
		// TODO Auto-generated method stub
		
		boolean status = false;
		try {
			//jdbc connection
			Connection con = ConnectionDB.create();
			
			String que = "delete from students where sid = ?";
			
			PreparedStatement pstmt = con.prepareStatement(que);
			
			//set the value of parameter
			
			pstmt.setInt(1, studentId);
			
			
			//execute
			
			pstmt.executeUpdate();
			
			status = true;
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return status;
		
	}

	public static void showAllStudent() {
		// TODO Auto-generated method stub
		
		
		try {
			//jdbc connection
			Connection con = ConnectionDB.create();
			
			String que = "select * from students";
			
			Statement stmt = con.createStatement();
			
			ResultSet set = stmt.executeQuery(que);
			
			while(set.next()) {
				int id = set.getInt(1);
				String name = set.getString(2);
				String phone = set.getString(3);
				String city = set.getString(4);
				
				System.out.println("Student Id is : "+id);
				System.out.println("Student Name is : "+name);
				System.out.println("Student Phone is : "+phone);
				System.out.println("Student City is : "+city);
				
				System.out.println("**************************************");
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
	}

}
