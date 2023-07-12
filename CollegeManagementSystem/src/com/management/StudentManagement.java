package com.management;
import com.model.Student;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
public class StudentManagement {
	
	public List<Student> insertStudentDetails(List<Student> studentDetails) {
		
		Connection con = null;
		    for(Student i:studentDetails){
		    	try{
		    	con = DBconnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement("INSERT INTO Student VALUES(?,?,?,?,?,?,?,?,?,?,?)");
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
		        pst.executeUpdate();		        	
		    }
		catch(SQLException e){
			System.out.println(i.getStudentName()+"'s records are not added successfully!!!\nBecause of "+e.getMessage());
			studentDetails.remove(i);
			return studentDetails;
		    }
		catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
			return studentDetails;			
		    }
		    
		finally{
			try{
				con.close();
			}
			catch(Exception e){
		        		
			}
		}
		    }
		return studentDetails;
	}
	
	public int updateStudentDetails(String updateColumn, String updateValue, String referenceColumn, String referenceValue) {

		int rowsAffected = 0;
		try{
            Connection con = DBconnectionManager.getConnection();
            PreparedStatement pst = con.prepareStatement("update Student set ?? = ? where ?? = ?");
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
	
	public int deleteStudentDetails(String StudentId) {
		
        try{
            Connection con = DBconnectionManager.getConnection();
            PreparedStatement pst = con.prepareStatement("delete from Student where Student_Id = ?");
            pst.setString(1,StudentId);
            int rowsAffected = pst.executeUpdate();
            con.close();
            return rowsAffected;
        }catch(ClassNotFoundException e){
        	System.out.println(e.getMessage());
        }catch(SQLException e){
        	System.out.println(e.getMessage());
        }
		return 0;
	}
	
	public ArrayList<Student> selectStudentDetails(){

        ArrayList<Student> list = new ArrayList<Student>();
        try{
        Connection con = DBconnectionManager.getConnection();
        PreparedStatement pst = con.prepareStatement("select * from Student ");
        ResultSet rs = pst.executeQuery();
        while(rs.next()){
            Student obj1 = new Student(rs.getString(1),rs.getString(2),rs.getString(3),rs.getDate(4),rs.getInt(5),rs.getInt(6),rs.getInt(7),rs.getInt(8),rs.getString(9),rs.getString(10),rs.getLong(11));
            list.add(obj1);
        }
        con.close();
        return list;
        }catch(SQLException e){
        	return list;
        }catch(ClassNotFoundException e){
        	return list;
        }
	}

}
