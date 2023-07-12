package com.service;

import java.util.ArrayList;
import java.util.List;
import com.management.EnrollmentManagement;
import com.model.Enrollment;
import com.util.ApplicationUtil;

public class EnrollmentService {

	public List<Enrollment> buildEnrollmentList(List<String> enrollmentDetails){
		
		List<Enrollment> enrollmentDetailList = new ArrayList<Enrollment>();
		String DELIMETER = ":";
		for(String i : enrollmentDetails) {
			String arr[] = i.split(DELIMETER);
			Enrollment obj = new Enrollment(arr[0],arr[1],arr[2],arr[3]);
			enrollmentDetailList.add(obj);
		}
    	return enrollmentDetailList;
	}

    public int addEnrollment(String... enrollmentDetails){
    	
    	EnrollmentManagement obj = new EnrollmentManagement();
    	int result = obj.insertEnrollmentDetails(buildEnrollmentList(ApplicationUtil.extractEnrollmentDetails(enrollmentDetails))); 
    	return result;
    }
    
    public boolean modifyEnrollment(String EnrollmentId, String EnrollmentName) {
    	
    	EnrollmentManagement obj = new EnrollmentManagement();
    	int n = obj.updateEnrollmentDetails(EnrollmentId, EnrollmentName);
    	return (n>0);
    }
    
    public List<Enrollment> fetchEnrollmentDetails(String EnrollmentId){
    	
    	List<Enrollment> enrollmentDetailList = new ArrayList<Enrollment>();
    	EnrollmentManagement obj = new EnrollmentManagement();
    	enrollmentDetailList = obj.selectEnrollmentDetails(EnrollmentId);
    	return enrollmentDetailList;
    }
 
    public boolean deleteEnrollment(String EnrollmentId) {
    	
    	EnrollmentManagement obj=new EnrollmentManagement();
    	int n = obj.deleteEnrollmentDetails(EnrollmentId);
    	return (n<0);
    }
}
