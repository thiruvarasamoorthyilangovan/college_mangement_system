package com.model;

public class Enrollment {
	
	private String enrollmentId;
	private String studentId;
	private String courseId;
	private String feeStatus;
	
	
	public Enrollment() {
		super();
	}


	public String getEnrollmentId() {
		return enrollmentId;
	}


	public void setEnrollmentId(String enrollmentId) {
		this.enrollmentId = enrollmentId;
	}


	public String getStudentId() {
		return studentId;
	}


	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}


	public String getCourseId() {
		return courseId;
	}


	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}


	public String getFeeStatus() {
		return feeStatus;
	}


	public void setFeeStatus(String feeStatus) {
		this.feeStatus = feeStatus;
	}


	public Enrollment(String enrollmentId, String studentId, String courseId, String feeStatus) {
		super();
		this.enrollmentId = enrollmentId;
		this.studentId = studentId;
		this.courseId = courseId;
		this.feeStatus = feeStatus;
	}
	

}
