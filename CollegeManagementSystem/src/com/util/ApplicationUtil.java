package com.util;

import java.util.ArrayList;
import java.util.List;
import com.exception.InvalidStudentException;

public class ApplicationUtil {
	
	public static List<String> extractStudentDetails(String... studentDetails){
		
		List<String> studentDetailList = new ArrayList<String>();
		for(String i:studentDetails) {
			String arr[]=i.split(":");
			try {
				validateAdmissionId(arr[0]);
				studentDetailList.add(i);
			}catch(InvalidStudentException e){
				System.out.println(e.getMessage());
			}
		}
    	return studentDetailList;
	}
	
	public static boolean validateAdmissionId(String admissionId) throws InvalidStudentException{
		
		if(admissionId!=null) {
			return true;
		}else {
			throw new InvalidStudentException(admissionId+" Invalid Admission Id");
		}
	}
	
	public static List<String> extractCourseDetails(String... courseDetails){
		
		List<String> courseDetailList = new ArrayList<String>();
		for(String i:courseDetails) {
			String arr[]=i.split(":");
			if(validateCourseId(arr[0])) {
				courseDetailList.add(i);
			}
			else {
				System.out.println(arr[0]+" is invalid Course Id");
			}
		}
    	return courseDetailList;
	}
	
	public static boolean validateCourseId(String courseId) {
		
		if(courseId!=null) {
			return true;
		}else {
			return false;
		}
	}
	public static List<String> extractEnrollmentDetails(String... enrollmentDetails){
		
		List<String> enrollmentDetailList = new ArrayList<String>();
		for(String i:enrollmentDetails) {
			String arr[]=i.split(":");
			if(validateCourseId(arr[0])) {
				enrollmentDetailList.add(i);
			}
			else {
				System.out.println(arr[0]+" is invalid Course Id");
			}
		}
    	return enrollmentDetailList;
	}
	

}

