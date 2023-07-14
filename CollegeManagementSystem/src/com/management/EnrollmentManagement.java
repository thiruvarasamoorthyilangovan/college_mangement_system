package com.management;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.model.Enrollment;

public class EnrollmentManagement {
	
public int insertEnrollmentDetails(List<Enrollment> enrollmentDetails) {
		
	int recordsAdded = 0;
	Connection con = null;
	try{
	    con = DBconnectionManager.getConnection();
	    PreparedStatement pst = con.prepareStatement("INSERT INTO ENROLLMENT (ENROLLMENT_ID,STUDENT_ID,COURSE_ID,FEE_STATUS) VALUES (?,?,?,?)");
	    for(Enrollment i:enrollmentDetails){
	        pst.setString(1,i.getEnrollmentId());
	        pst.setString(2,i.getStudentId());
	        pst.setString(3,i.getCourseId());
	        pst.setString(4,i.getFeeStatus());
	        recordsAdded = recordsAdded+pst.executeUpdate();	
	    }
	}
	catch(SQLException e){
		System.out.println(e.getMessage());
		return 0;
	    }
	catch (ClassNotFoundException e) {
		System.out.println(e.getMessage());
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
	
	public int updateEnrollmentDetails(String updateColumn,String updateValue,String referenceColumn,String referenceValue) {
		
		int rowsAffected = 0;
		try{
            Connection con = DBconnectionManager.getConnection();
            String query = "update ENROLLMENT set "+updateColumn+" = '"+updateValue+"' where "+referenceColumn+" = '"+referenceValue+"'";
            PreparedStatement pst = con.prepareStatement(query);

            rowsAffected = pst.executeUpdate();
            con.close();
            return rowsAffected;
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        catch(ClassNotFoundException e){
        	e.printStackTrace();
        }
		return 0;
	}
	public int deleteEnrollmentDetails(String enrollmentId) {
		
		try{
            Connection con = DBconnectionManager.getConnection();
            PreparedStatement pst = con.prepareStatement("delete from ENROLLMENT where ENROLLMENT_ID = ?");
            pst.setString(1,enrollmentId);
            int rowsAffected = pst.executeUpdate();
            con.close();
            return rowsAffected;
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }catch(SQLException e){
            e.printStackTrace();
        }
		return 0;
	}
	
	public ArrayList<Enrollment> selectEnrollmentDetails(String enrollmentId){
		
		ArrayList<Enrollment> list = new ArrayList<Enrollment>();
        try{
        Connection con = DBconnectionManager.getConnection();
        PreparedStatement pst = con.prepareStatement("select * from ENROLLMENT WHERE ENROLLMENT_ID=?");
        pst.setString(1,enrollmentId);
        ResultSet rs = pst.executeQuery();
        while(rs.next()){
        	Enrollment obj1 = new Enrollment(rs.getString(1),rs.getString(2),rs.getString(3));
            list.add(obj1);
        }
        con.close();
        	return list;
        }catch(SQLException e){
            e.printStackTrace();
            return list;
        }catch(ClassNotFoundException e){
            e.printStackTrace();
            return list;
        }
	}

}
