package com.management;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.model.Course;


public class CourseManagement {
	
	public int insertCourseDetails(List<Course> courseDetails) {
		
		int recordsAdded = 0;
		Connection con = null;
		try{
		    con = DBconnectionManager.getConnection();
		    PreparedStatement pst = con.prepareStatement("INSERT INTO Course VALUES(?,?,?,?,?)");
		    for(Course i:courseDetails){
		        pst.setString(1,i.getCourseId());
		        pst.setString(2,i.getCourseName());
		        pst.setString(3,i.getCourseCoordinator());
		        pst.setString(4,i.getDepartment());
		        pst.setDouble(5,i.getCourseFee());
		        recordsAdded = recordsAdded+pst.executeUpdate();	
		    }
		}
		catch(SQLException e){
			System.out.println(e.getMessage());
		    }
		catch (ClassNotFoundException e) {
		    System.out.println(e.getMessage());
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
	
	public int updateCourseDetails(String courseId, String courseName) {
		
		int rowsAffected = 0;
		try{
            Connection con = DBconnectionManager.getConnection();
            PreparedStatement pst = con.prepareStatement("update Course set Course_Name = ? where Course_Id = ?");
            pst.setString(2,courseId);
            pst.setString(1,courseName);
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
	public int deleteCourseDetails(String courseId) {
		
		try{
            Connection con = DBconnectionManager.getConnection();
            PreparedStatement pst = con.prepareStatement("delete from Course where Course_Id = ?");
            pst.setString(1,courseId);
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
	
	public ArrayList<Course> selectCourseDetails(String courseId){
		
		ArrayList<Course> list = new ArrayList<Course>();
        try{
        Connection con = DBconnectionManager.getConnection();
        PreparedStatement pst = con.prepareStatement("select * from Course where COURSE_ID = ?");
        pst.setString(1, courseId);
        ResultSet rs = pst.executeQuery();
        while(rs.next()){
        	Course obj1 = new Course(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getDouble(5));
            list.add(obj1);
        }
        con.close();
        }catch(SQLException e){
        	System.out.println(e.getMessage());
        }catch(ClassNotFoundException e){
        	System.out.println(e.getMessage());
        }
        return list;
	}

}
