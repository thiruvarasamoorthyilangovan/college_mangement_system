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
					System.out.println("Enter your choice\n1. Add Student Details\n2. Update Student Details\n3. Show Student Details\n4. Delete Student Details\n5. Go to main menu");
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
						System.out.println("Enter the choice which column to be update\n1.studetname\n2. Date of Brith\n3. Year of Study\n4. Year f Joining\n5. Tenth Grade Mark\n6. Twelth Grade Mark\n7. First Graduate\n8. Email Id\n9. Phone Number");
						int n = s.nextInt();
						String updateColumn ="";
						switch(n) {
						case(1):
							updateColumn="STUDENT_NAME";
							break;
						case(2):
							updateColumn="DOB";
							break;
						case(3):
							updateColumn="YEAR_OF_STUDY";
							break;
						case(4):
							updateColumn="YEAR_OF_JOINING";
							break;
						case(5):
							updateColumn="TENTH_GRADE_MARK";
							break;
						case(6):
							updateColumn="TWELTH_GRADE_MARK";
							break;
						case(7):
							updateColumn="FIRST_GRADUATE";
							break;
						case(8):
							updateColumn="EMAIL_ID";
							break;
						case(9):
							updateColumn="PHONE_NUMBER";
							break;
						}
						
						System.out.println("Enter the "+updateColumn+" detail");
						s.nextLine();
						String updateValue = s.nextLine();
						System.out.println("Enter the choice which column to be update\n1. Admmission Id\n2. Student Id\n3. Studet Name\n4. Date of Brith\n5. Year of Study\n6. Year 0f Joining\n7. Tenth Grade Mark\n8. Twelth Grade Mark\n9. First Graduate\n10. Email Id\n11. Phone Number");
						n = s.nextInt();
						String referenceColumn ="";
						switch(n) {
						case(1):
							referenceColumn="ADMISSION_NUMBER";
							break;
						case(2):
							referenceColumn="STUDENT_ID";
							break;
						case(3):
							referenceColumn="STUDENT_NAME";
							break;
						case(4):
							referenceColumn="DOB";
							break;
						case(5):
							referenceColumn="YEAR_OF_STUDY";
							break;
						case(6):
							referenceColumn="YEAR_OF_JOINING";
							break;
						case(7):
							referenceColumn="TENTH_GRADE_MARK";
							break;
						case(8):
							referenceColumn="TWELTH_GRADE_MARK";
							break;
						case(9):
							referenceColumn="FIRST_GRADUATE";
							break;
						case(10):
							referenceColumn="EMAIL_ID";
							break;
						case(11):
							referenceColumn="PHONE_NUMBER";
							break;
						}
						System.out.println("Enter the "+referenceColumn+" detail");
						s.nextLine();
						String referenceValue = s.nextLine();
						boolean flag = ss.modifyStudent(updateColumn,updateValue,referenceColumn,referenceValue );
						if(flag) {
							System.out.println("Details are Updated successfully");
						}
						else {
							System.out.println("Details are not Updated successfully");
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
						System.out.println("Enter the choice which column to be update\n1. Course Name\n2. Course Coordinator\n3. Department\n4. Course Fee");
						int n = s.nextInt();
						String updateColumn ="";
						switch(n) {
						case(1):
							updateColumn="COURSE_NAME";
							break;
						case(2):
							updateColumn="COURSE_COORDINATOR";
							break;
						case(3):
							updateColumn="DEPARTMENT";
							break;
						case(4):
							updateColumn="COURSE_FEE";
							break;
						
						}
						System.out.println("Enter the "+updateColumn+" detail");
						s.nextLine();
						String updateValue = s.nextLine();
						System.out.println("Enter the choice which column to be update\n1. Course Id\n2. Course Name\n3. Course Coordinator\n4. Department\n5. Course Fee");
						n = s.nextInt();
						String referenceColumn ="";
						switch(n) {
						case(1):
							referenceColumn="COURSE_ID";
							break;
						case(2):
							referenceColumn="COURSE_NAME";
							break;
						case(3):
							referenceColumn="COURSE_COORDINATOR";
							break;
						case(4):
							referenceColumn="DEPARTMENT";
							break;
						case(5):
							referenceColumn="COURSE_FEE";
							break;
						}
						System.out.println("Enter the "+referenceColumn+" detail");
						s.nextLine();
						String referenceValue = s.nextLine();
						boolean flag = cs.modifyCourse(updateColumn,updateValue,referenceColumn,referenceValue);
						if(flag) {
							System.out.println("Details Updated successfully");
						}
						else {
							System.out.println("Details not Updated successfully");
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
				}while(choice1 != 5);
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
						System.out.println("Enter the choice which column to be update\n1. Student Id\n2. Course Id\n3. Fee Status");
						int n = s.nextInt();
						String updateColumn ="";
						switch(n) {
						case(1):
							updateColumn="STUDENT_ID";
							break;
						case(2):
							updateColumn="COURSE_ID";
							break;
						case(3):
							updateColumn="FEE_STATUS";
							break;
						}
						System.out.println("Enter the "+updateColumn+" detail");
						s.nextLine();
						String updateValue = s.nextLine();
						System.out.println("Enter the choice which column to be update\n1. Enrollment Id\n2. Student Id\n3. Course Id");
						n = s.nextInt();
						String referenceColumn ="";
						switch(n) {
						case(1):
							referenceColumn="ENROLLMENT_ID";
							break;
						case(2):
							referenceColumn="STUDENT_ID";
							break;
						case(3):
							referenceColumn="COURSE_ID";
							break;
						}
						System.out.println("Enter the "+referenceColumn+" detail");
						s.nextLine();
						String referenceValue = s.nextLine();
						boolean flag = es.modifyEnrollment(updateColumn, updateValue, referenceColumn, referenceValue);
						if(flag) {
							System.out.println("Details Updated successfully");
						}
						else {
							System.out.println("Details not Updated successfully");
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
				}while(choice1 != 5);
			}
			
	}while(choice!=7);
	s.close();
	}
}
