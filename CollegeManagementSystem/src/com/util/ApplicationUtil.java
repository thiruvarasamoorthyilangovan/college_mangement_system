package com.util;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import com.exception.InvalidStudentException;

public class ApplicationUtil {
	
	public static List<String> extractStudentDetails(String... studentDetails){
		
		List<String> studentDetailList = new ArrayList<String>();
		String DELIMITER = ":";
		for(String i:studentDetails) {
			String arr[]=i.split(DELIMITER);
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
		
		if(Pattern.matches("AD20[1-2]{1}[1-9]{1}-00[0-9]", admissionId)) {
			return true;
		}else {
			throw new InvalidStudentException(admissionId+" Invalid Admission Id");
		}
	}
	
	public static List<String> extractCourseDetails(String... courseDetails){
		
		List<String> courseDetailList = new ArrayList<String>();
		String DELIMITER = ":";
		for(String i:courseDetails) {
			String arr[]=i.split(DELIMITER);
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
		
		if(Pattern.matches("[A-Z]00[0-9]", courseId)) {
			return true;
		}else {
			return false;
		}
	}
	public static List<String> extractEnrollmentDetails(String... enrollmentDetails){
		
		List<String> enrollmentDetailList = new ArrayList<String>();
		String DELIMITER = ":";
		for(String i:enrollmentDetails) {
			String arr[]=i.split(DELIMITER);
			if(validateEnrollmentId(arr[0])) {
				enrollmentDetailList.add(i);
			}
			else {
				System.out.println(arr[0]+" is invalid Enrollment Id");
			}
		}
    	return enrollmentDetailList;
	}
	public static boolean validateEnrollmentId(String enrollmentId) {
		
		if(Pattern.matches("EM20[1-2]{1}[1-9]{1}-00[0-9]", enrollmentId)) {
			return true;
		}else {
			return false;
		}
	}
	

}

