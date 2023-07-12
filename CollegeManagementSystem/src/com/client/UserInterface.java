package com.client;
import java.util.Scanner;
import com.service.*;
import com.model.*;
import java.util.ArrayList;
import java.util.List;

import com.service.StudentService;
public class UserInterface {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		StudentService ss = new StudentService();
		CourseService cs = new CourseService();
		EnrollmentService es = new EnrollmentService();
		int choice = 0;
		do {
			System.out.println("Enter your choice\n1. Student\n2. course\n3. Enrollment\n4. Payment\n5. Attendance\n6. Mark\n7. Exit");
			choice = s.nextInt();
			if(choice == 1) {
				int choice1=0;
				do {
					System.out.println("Enter your choice\n1. Add Student Details\n2. Update Student Details\n3. Slow Student Details\n4. Delete Student Details\n5. Go to main menu");
					choice1 = s.nextInt();
					if(choice1==1) {
						System.out.println("Enter the Number Records to be Add");
						int size = s.nextInt();
						String[] studentDetails = new String[size];
						System.out.println("Enter the Student Details");
						for(int i = 0; i < size; i++) {
							studentDetails[i] = s.next();
						}
						List<Student> studentDetailList =ss.addStudent(studentDetails);
						for(Student i:studentDetailList) {
							System.out.println(i.getStudentId()+" Student record added successfully");
						}
					}
					else if(choice1==2) {
						System.out.println("Enter the choice to be update\n1.studetname");
						System.out.println("Enter the Student to be Update");
						String studentId = s.next();
						System.out.println("Enter the Student Name to be Update");
						s.nextLine();
						String studentName = s.nextLine();
						boolean flag = ss.modifyStudent("STUDENT-NAME",studentName,"STUDENT-ID",studentId );
						if(flag) {
							System.out.println(studentId+" details Updated successfully");
						}
						else {
							System.out.println(studentId+" details not Updated successfully");
						}
					}
					else if(choice1==3) {
						System.out.println("Enter the Student Id to be Show the Details");
						String studentId = s.next();
						List<Student> list = new ArrayList<Student>();
						list = ss.fetchStudentDetails(studentId);
						if(list.isEmpty()) {
							System.out.println(studentId+" is not available");
						}
						for(Student i:list) {
							System.out.println(i.toString());
						}
					}
					else if(choice1==4) {
						System.out.println("Enter the Student Id to be Delete");
						String studentId = s.next();
						boolean flag = ss.deleteStudent(studentId);
						if(flag) {
							System.out.println(studentId+" details Deleted successfully");
						}
						else {
							System.out.println(studentId+" details not Deleted successfully");
						}
					}
					else if(choice1==5) {
						choice = 0;
						break;
					}
					else {
						System.out.println("Invalid input");
					}
				}while(choice1!=5);
			}
			else if(choice == 2) {
				int choice1=0;
				do {
					System.out.println("Enter your choice\n1. Add Course Details\n2. Update Course Details\n3. Show Course Details\n4. Delete Course Details\n5. Go to main menu");
					choice1 = s.nextInt();
					if(choice1==1) {
						System.out.println("Enter the Number Records to be Add");
						int size = s.nextInt();
						String[] courseDetails = new String[size];
						System.out.println("Enter the Course Details");
						for(int i = 0 ; i < size; i++ ) {
							courseDetails[i] = s.next();
						}
						int recordAdded = cs.addCourse(courseDetails);
						System.out.println(recordAdded+" Course record added successfully");
					}
					else if(choice1==2) {
						System.out.println("Enter the Course Id to be Update");
						String courseId = s.next();
						System.out.println("Enter the Student Name to be Update");
						String courseName = s.next();
						boolean flag = cs.modifyCourse(courseId, courseName);
						if(flag) {
							System.out.println(courseId+" details Updated successfully");
						}
						else {
							System.out.println(courseId+" details not Updated successfully");
						}
						
					}
					else if(choice1==3) {
						System.out.println("Enter the Course Id to be Show the Details");
						String courseId = s.next();
						List<Course> list = new ArrayList<Course>();
						list = cs.fetchCourseDetails(courseId);
						for(Course i:list) {
							System.out.println(i.toString());
						}
					}
					else if(choice1==4) {
						System.out.println("Enter the Course Id to be Delete");
						String courseId = s.next();
						boolean flag = cs.deleteCourse(courseId);
						if(flag) {
							System.out.println(courseId+" details Deleted successfully");
						}
						else {
							System.out.println(courseId+" details not Deleted successfully");
						}
					}
					else if(choice1==5) {
						choice = 0;
						break;
					}
					else {
						System.out.println("Invalid input");
					}
				}while(choice1 == 0);
			}else if(choice == 3) {
				int choice1=0;
				do {
					System.out.println("Enter your choice\n1. Add Enrollment Details\n2. Update Enrollment Details\n3. Show Enrollment Details\n4. Delete Enrollment Details\n5. Go to main menu");
					choice1 = s.nextInt();
					if(choice1==1) {
						System.out.println("Enter the Number Records to be Add");
						int size = s.nextInt();
						String[] enrollmentDetails = new String[size];
						System.out.println("Enter the Enrollment Details");
						for(int i = 0 ; i < size; i++ ) {
							enrollmentDetails[i] = s.next();
						}
						int recordAdded = es.addEnrollment(enrollmentDetails);
						System.out.println(recordAdded+" Enrollment record added successfully");
					}
					else if(choice1==2) {
						System.out.println("Enter the Enrollment Id to be Update");
						String enrollmentId = s.next();
						System.out.println("Enter the Student Name to be Update");
						String enrollmentName = s.next();
						boolean flag = cs.modifyCourse(enrollmentId, enrollmentName);
						if(flag) {
							System.out.println(enrollmentId+" details Updated successfully");
						}
						else {
							System.out.println(enrollmentId+" details not Updated successfully");
						}
						
					}
					else if(choice1==3) {
						System.out.println("Enter the Enrollment Id to be Show the Details");
						String enrollmentId = s.next();
						List<Enrollment> list = new ArrayList<Enrollment>();
						list = es.fetchEnrollmentDetails(enrollmentId);
						for(Enrollment i:list) {
							System.out.println(i.toString());
						}
					}
					else if(choice1==4) {
						System.out.println("Enter the Enrollment Id to be Delete");
						String enrollmentId = s.next();
						boolean flag = es.deleteEnrollment(enrollmentId);
						if(flag) {
							System.out.println(enrollmentId+" details Deleted successfully");
						}
						else {
							System.out.println(enrollmentId+" details not Deleted successfully");
						}
					}
					else if(choice1==5) {
						choice = 0;
						break;
					}
					else {
						System.out.println("Invalid input");
					}
				}while(choice1 == 0);
			}
			
	}while(choice!=7);
	s.close();
	}
}
