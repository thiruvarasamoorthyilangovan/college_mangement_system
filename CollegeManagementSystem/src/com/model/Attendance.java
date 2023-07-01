package com.model;

public class Attendance {
	
	private String attendanceId;
	private String studentId;
	private String enrollmentId;
	private int semester;
	private int toatalWorkingDays;
	private int presentDays;
	private int absentDays;
	private int attendancePercentage;
	
	public Attendance() {
		super();
	}
	public Attendance(String attendanceId, String studentId, String enrollmentId, int semester, int toatalWorkingDays,
			int presentDays, int absentDays, int attendancePercentage) {
		super();
		this.attendanceId = attendanceId;
		this.studentId = studentId;
		this.enrollmentId = enrollmentId;
		this.semester = semester;
		this.toatalWorkingDays = toatalWorkingDays;
		this.presentDays = presentDays;
		this.absentDays = absentDays;
		this.attendancePercentage = attendancePercentage;
	}
	public String getAttendanceId() {
		return attendanceId;
	}
	public void setAttendanceId(String attendanceId) {
		this.attendanceId = attendanceId;
	}
	public String getStudentId() {
		return studentId;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	public String getEnrollmentId() {
		return enrollmentId;
	}
	public void setEnrollmentId(String enrollmentId) {
		this.enrollmentId = enrollmentId;
	}
	public int getSemester() {
		return semester;
	}
	public void setSemester(int semester) {
		this.semester = semester;
	}
	public int getToatalWorkingDays() {
		return toatalWorkingDays;
	}
	public void setToatalWorkingDays(int toatalWorkingDays) {
		this.toatalWorkingDays = toatalWorkingDays;
	}
	public int getPresentDays() {
		return presentDays;
	}
	public void setPresentDays(int presentDays) {
		this.presentDays = presentDays;
	}
	public int getAbsentDays() {
		return absentDays;
	}
	public void setAbsentDays(int absentDays) {
		this.absentDays = absentDays;
	}
	public int getAttendancePercentage() {
		return attendancePercentage;
	}
	public void setAttendancePercentage(int attendancePercentage) {
		this.attendancePercentage = attendancePercentage;
	}

}
