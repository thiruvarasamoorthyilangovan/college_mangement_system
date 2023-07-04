package com.util;

import java.util.ArrayList;
import java.util.List;
import com.exception.InvalidStudentException;

import com.model.Student;

public class ApplicationUtil {
	
	public static List<String> extractStudentDetails(String... studentDetails){
		
		List<String> studentDetailList = new ArrayList<String>();
		for(String i:studentDetails) {
			String arr[]=i.split(":");
			try {
				validateAdmissionId(arr[0]);
			}catch(InvalidStudentException e){
				System.out.println(e.getMessage());
			}
		}
    	return studentDetailList;
	}
	
	public static boolean validateAdmissionId(String admissionId) throws InvalidStudentException{
		
		if(admissionId==null) {
			return true;
		}else {
			throw new InvalidStudentException("invalid admission id");
		}
	}

}

