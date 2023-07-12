package com.service;

import java.util.ArrayList;
import java.util.List;
import com.management.CourseManagement;
import com.model.Course;
import com.util.ApplicationUtil;

public class CourseService {
	
	public List<Course> buildCourseList(List<String> courseDetails){
		
		List<Course> courseDetailList = new ArrayList<Course>();
		String DELIMETER = ":";
		for(String i : courseDetails) {
			String arr[] = i.split(DELIMETER);
			Course obj = new Course(arr[0],arr[1],arr[2],arr[3],Double.parseDouble(arr[4]));
			courseDetailList.add(obj);
		}
    	return courseDetailList;
	}

    public int addCourse(String... courseDetails){
    	
    	CourseManagement obj = new CourseManagement();
    	int result = obj.insertCourseDetails(buildCourseList(ApplicationUtil.extractCourseDetails(courseDetails))); 
    	return result;
    }
    
    public boolean modifyCourse(String courseId, String courseName) {
    	
    	CourseManagement obj = new CourseManagement();
    	int n = obj.updateCourseDetails(courseId, courseName);
    	return (n>0);
    }
    
    public List<Course> fetchCourseDetails(String studentId){
    	
    	List<Course> courseDetailList = new ArrayList<Course>();
    	CourseManagement obj = new CourseManagement();
    	courseDetailList = obj.selectCourseDetails();
    	return courseDetailList;
    }
 
    public boolean deleteCourse(String courseId) {
    	
		CourseManagement obj=new CourseManagement();
    	int n = obj.deleteCourseDetails(courseId);
    	return (n<0);
    }
}
