package com.service;
import com.model.Student;
import java.util.List;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import com.management.StudentManagement;
import com.util.ApplicationUtil;

public class StudentService {
	
	public List<Student> buildStudentList(List<String> studentDetails){
		
		List<Student> studentDetailList = new ArrayList<Student>();
		for(String i:studentDetails) {
			String arr[]=i.split(":");
			Student obj=new Student(arr[0], generateStudentId(), arr[1], utilToSqlDateConverter(stringToDateConverter(arr[2])), Integer.parseInt(arr[3]),
			Integer.parseInt(arr[4]), Integer.parseInt(arr[5]), Integer.parseInt(arr[6]), arr[7], arr[8],
			Long.parseLong(arr[9]));
			studentDetailList.add(obj);
		}
    	return studentDetailList;
	}

    public int addStudent(String... studentDetails){
    	
    	StudentManagement obj= new StudentManagement();
    	int result = obj.insertStudentDetails(buildStudentList(ApplicationUtil.extractStudentDetails(studentDetails))); 
    	return result;
    }
    
    public String generateStudentId() {
    	
    	return "studentId";
    }
    public boolean modifyStudent(String studentId, String studentName) {
    	
    	StudentManagement obj=new StudentManagement();
    	int n=obj.updateStudentDetails(studentId, studentName);
    	return (n>0);
    }
    
    public boolean deleteStudent(String studentId) {
    	
    	StudentManagement obj=new StudentManagement();
    	int n = obj.deleteStudentDetails(studentId);
    	return (n<0);
    }
    
    public List<Student> fetchStudentDetails(String studentId){
    	
    	List<Student> studentDetailList = new ArrayList<Student>();
    	StudentManagement obj=new StudentManagement();
    	studentDetailList = obj.selectStudentDetails();
    	return studentDetailList;
    }
    
    public static java.util.Date stringToDateConverter(String stringDate) {
		
		java.util.Date date = null;
		SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd",java.util.Locale.getDefault());
		try
		{
		if(stringDate!=null)
			{return df.parse(stringDate);}
		}catch(ParseException e) {}
		return date;
		
	}

	public static java.sql.Date utilToSqlDateConverter(java.util.Date utDate) {
		
		java.sql.Date sqlDate = null;
		if(utDate!=null)
		{
			sqlDate=new java.sql.Date(utDate.getTime());
		}
		return sqlDate;
	}
	
	public static java.util.Date sqlToUtilDateConverter(java.sql.Date sDate) {
	    
	    java.util.Date utDate = null;
			if (sDate != null) {
				utDate = new java.util.Date(sDate.getTime());
			}
			return utDate;
	}
}
