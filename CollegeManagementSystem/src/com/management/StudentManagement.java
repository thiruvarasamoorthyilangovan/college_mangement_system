package com.management;
import com.model.Student;
//import com.util.ApplicationUtil;

import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
//import com.management.DBconnectionManager;

public class StudentManagement {
	
	public int insertStudentDetails(List<Student> studentDetails) {
		
		int recordsAdded = 0;
		Connection con = null;
		try{
		    con = DBconnectionManager.getConnection();
		    PreparedStatement pst = con.prepareStatement("INSERT INTO television VALUES(?,?,?,?,?,?,?,?,?,?,?)");
		    for(Student i:studentDetails){
		        pst.setString(1,i.getAdmissionNumber());
		        pst.setString(2,i.getStudentId());
		        pst.setString(3,i.getStudentName());
		        pst.setDate(4,i.getDob());
		        pst.setInt(5,i.getYearOfStudy());
		        pst.setInt(6,i.getYearOfJoining());
		        pst.setDouble(7,i.getTenthGradeMark());
		        pst.setInt(8,i.getTwelthGradeMark());
		        pst.setString(9,i.getFirstGraduate());
		        pst.setString(10,i.getEmailId());
		        pst.setLong(11,i.getPhoneNumber());
		        recordsAdded = recordsAdded+pst.executeUpdate();		        
		    }
		    }catch(SQLException e){
		        e.printStackTrace();
		    }
		    finally{
		        try{con.close();}
		        catch(Exception e){}
		    }
		
		return recordsAdded;
	}
	
	public boolean updateStudentDetails() {
		
		return false;
	}
	public boolean deleteStudentDetails() {
		
		return false;
	}
	
	public ArrayList<Student> selectStudentDetails(){
		
		return new ArrayList<Student>();
	}

}

