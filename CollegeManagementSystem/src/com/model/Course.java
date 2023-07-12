package com.model;

public class Course {
	
	private String courseName;
	private String courseCoordinator;
	private String department;
	private double courseFee;
	
	
	private String courseId;
	public Course() {
		super();
	}
	public Course(String courseId, String courseName, String courseCoordinator, String department, double courseFee) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		this.courseCoordinator = courseCoordinator;
		this.department = department;
		this.courseFee = courseFee;
	}
	public String getCourseId() {
		return courseId;
	}
	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getCourseCoordinator() {
		return courseCoordinator;
	}
	public void setCourseCoordinator(String courseCoordinator) {
		this.courseCoordinator = courseCoordinator;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public double getCourseFee() {
		return courseFee;
	}
	@Override
	public String toString() {
		return "Course \nCourse Name = " + courseName + "\nCourse Coordinator = " + courseCoordinator + "\nDepartment = "
				+ department + "\nCourseFee = " + courseFee + "\nCourse Id = " + courseId;
	}
	public void setCourseFee(double courseFee) {
		this.courseFee = courseFee;
	}

	
	

}
