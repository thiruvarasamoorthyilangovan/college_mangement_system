package com.management;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import com.management.*;
import com.model.Attendance;
import java.sql.*;

public class AttendanceManagement {
	
	public boolean insertAttendanceDetails() {
		
		return false ;
	}
	public ArrayList<Attendance> selectAttendanceDetails(String studentId){
		
		ArrayList<Attendance> attendanceList = new ArrayList<Attendance>();
		try {
			DBconnectionManager dbcm= new DBconnectionManager();
			Connection con = dbcm.getConnection() ;
			PreparedStatement pst = con.prepareStatement("SELECT * FORM ATTENDANCE WHERE STUDENT_ID = ?");
			pst.setString(1, studentId);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				Attendance attendance = new Attendance(rs.getString(1),rs.getString(2), rs.getString(3),rs.getInt(4), rs.getInt(5), rs.getInt(6), rs.getInt(7), rs.getInt(8));
				attendanceList.add(attendance);
			}
			
		}catch(SQLException e) {
			return attendanceList;
		}
		return attendanceList;
	}

}
