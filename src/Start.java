import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.student.management.Student;
import com.student.management.StudentDao;

public class Start {

	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		System.out.println("Welcome to Student Management App!");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			System.out.println("Press 1 to Add student!");
			System.out.println("Press 2 to Delete student!");
			System.out.println("Press 3 to Display student!");
			System.out.println("Press 4 to exit App!");
			
			int choice = Integer.parseInt(br.readLine());
			
			if(choice == 1) {
				//add student
				
				System.out.println("Enter student name : ");
				String sname = br.readLine();
				
				System.out.println("Enter student phone number : ");
				String sphone = br.readLine();
				
				System.out.println("Enter student city : ");
				String scity = br.readLine();
				
				Student st = new Student(sname, sphone, scity);
				boolean ans = StudentDao.insertStudentToDB(st);
				
				if(ans) {
					System.out.println("Student added successfully😍........!");
				}
				else {
					System.out.println("Something went wrong try again.....!");
				}
				System.out.println(st);
			}
			
			else if(choice == 2) {
				//delete
				
				System.out.println("Enter student id to delete : ");
				int studentId = Integer.parseInt(br.readLine());
				
				boolean res = StudentDao.deleteStudent(studentId);
				
				if(res) {
					System.out.println("Student record deleted.......!");
				}
				else {
					System.out.println("Something went wrong try again.....!");
				}
			}
			else if(choice == 3) {
				//display
				
				StudentDao.showAllStudent();
			}
			else if(choice == 4) {
				//exit
				
				break;
			}
			else {
				System.out.println("Invalid choice !!! Try again 😊");
			}
		}
		System.out.println("Thank You 😍😊 for using Student management system !........");
		System.out.println("Visit again 😊😊😊..........!");
	} 

}
