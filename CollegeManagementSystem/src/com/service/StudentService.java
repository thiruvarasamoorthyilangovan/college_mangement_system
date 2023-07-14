package com.service;
import com.model.Student;
import java.util.List;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import com.management.StudentManagement;
import com.util.ApplicationUtil;

public class StudentService {
	
	static int studentCount = 000;
	
	public List<Student> buildStudentList(List<String> studentDetails){
		
		List<Student> studentDetailList = new ArrayList<Student>();
		Student obj = new Student();
		for(String i:studentDetails) {
			String arr[]=i.split(":");
			try {
			obj=new Student(arr[0], generateStudentId(arr[1], arr[2]), arr[1], utilToSqlDateConverter(stringToDateConverter(arr[2])), Integer.parseInt(arr[3]),
			Integer.parseInt(arr[4]), Integer.parseInt(arr[5]), Integer.parseInt(arr[6]), arr[7], arr[8],
			Long.parseLong(arr[9]));
			studentDetailList.add(obj);
			}catch(Exception e) {
				System.out.println(arr[1]+" Details are not in the correct format!!!");
				
			}
			
		}
    	return studentDetailList;
	}

    public List<Student> addStudent(String... studentDetails){
    	
    	StudentManagement obj= new StudentManagement();
    	List<Student> studentDetailList =obj.insertStudentDetails((buildStudentList(ApplicationUtil.extractStudentDetails(studentDetails)))); 
    	return studentDetailList;
    	
    }
    
    public static String generateStudentId(String name, String date) {
    	
    	studentCount++;
    	String studentId = "SI"+date.substring(6)+""+(name.substring(0, 3)).toUpperCase()+"00"+studentCount; 
    	return studentId;
    }
    public boolean modifyStudent(String updateColumn, String updateValue, String referenceColumn, String referenceValue) {
    	
    	StudentManagement obj=new StudentManagement();
    	int n=obj.updateStudentDetails(updateColumn, updateValue, referenceColumn, referenceValue);
    	return (n>0);
    }
    
    public boolean deleteStudent(String studentId) {
    	
    	StudentManagement obj=new StudentManagement();
    	int n = obj.deleteStudentDetails(studentId);
    	return (n>0);
    }
    
    public List<Student> fetchStudentDetails(String studentId){
    	
    	List<Student> studentDetailList = new ArrayList<Student>();
    	StudentManagement obj=new StudentManagement();
    	studentDetailList = obj.selectStudentDetails(studentId);
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
