package com.management;

import java.util.ArrayList;
import java.util.List;
import com.model.Attendance;
import java.sql.*;

public class AttendanceManagement {
	
	public int insertAttendanceDetails(List <Attendance> attendanceDetails) {
		
		int recordsAdded = 0;
		Connection con = null;
		try{
		    con = DBconnectionManager.getConnection();
		    PreparedStatement pst = con.prepareStatement("INSERT INTO ATTENDANCE VALUES(?,?,?,?,?,?,?,?)");
		    for(Attendance i:attendanceDetails){
		        pst.setString(1,i.getAttendanceId());
		        pst.setString(2,i.getStudentId());
		        pst.setString(3,i.getEnrollmentId());
		        pst.setInt(4,i.getSemester());
		        pst.setInt(5,i.getToatalWorkingDays());
		        pst.setInt(6,i.getPresentDays());
		        pst.setInt(7,i.getAbsentDays());
		        pst.setInt(8,i.getAttendancePercentage());
		        recordsAdded = recordsAdded+pst.executeUpdate();	
		    }
		}
		catch(SQLException e){
			return 0;
		    }
		catch (ClassNotFoundException e) {
		    return 0;			
		    }
		finally{
			try{
				con.close();
			}
			catch(Exception e){
		        		
			}
		}
		return recordsAdded;
	}
	public ArrayList<Attendance> selectAttendanceDetails(String studentId){
		
		ArrayList<Attendance> attendanceList = new ArrayList<Attendance>();
		try {
			Connection con = DBconnectionManager.getConnection() ;
			PreparedStatement pst = con.prepareStatement("SELECT * FORM ATTENDANCE WHERE STUDENT_ID = ?");
			pst.setString(1, studentId);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				Attendance attendance = new Attendance(rs.getString(1),rs.getString(2), rs.getString(3),rs.getInt(4), rs.getInt(5), rs.getInt(6), rs.getInt(7), rs.getInt(8));
				attendanceList.add(attendance);
			}
			
		}catch(SQLException e) {
			return attendanceList;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return attendanceList;
	}
	public int updateAttendanceDetails(String updateColumn, String updateValue, String referenceColumn, String referenceValue) {

		int rowsAffected = 0;
		try{
            Connection con = DBconnectionManager.getConnection();
            PreparedStatement pst = con.prepareStatement("update Attendance set ?? = ? where ?? = ?");
            pst.setString(1,updateColumn);
            pst.setString(2,updateValue);
            pst.setString(3,referenceColumn);
            pst.setString(4,referenceValue);
            rowsAffected = pst.executeUpdate();
            con.close();
            return rowsAffected;
            
        }
        catch(SQLException e){
        	System.out.println(e.getMessage());
        }
        catch(ClassNotFoundException e){
        	System.out.println(e.getMessage());
        }
		return 0;
	}
}
