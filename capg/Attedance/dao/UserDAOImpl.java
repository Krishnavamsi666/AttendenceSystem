package com.capg.Attedance.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.capg.Attendance.util.DBConnection;
import com.capg.Attendance.Beans.User;
public class UserDAOImpl implements UserDAO{
	Connection con = DBConnection.con;
	PreparedStatement ps; 
	public boolean insertUserDAO(User user)
	{
		String sqlQuery="insert into attendance.User values(?,?,?,?,?,?,?)";
		try
		{
			ps = con.prepareStatement(sqlQuery);
			ps.setInt(1,user.getUserid());
			ps.setString(2, user.getUserName());
			ps.setString(3, user.getEmail());
			ps.setString(4, user.getPassword());
			ps.setString(5,user.getUserPhoneNumber());
			ps.setString(6, user.getUserAddress());
			ps.setInt(7, user.getAttendance());
			
			int i = ps.executeUpdate(); 
			if(i==1) return true;
			return false;

		}
		catch(Exception e)
		{
			System.out.println("Exeption while Data Insertion "+e);
		}
		return false;
	}
	
	public User getUserbyId(int userid)
	{
		String sqlQuery = "select * from attendance.User where userid = ?";
		try {
			ps = con.prepareStatement(sqlQuery);
			ps.setInt(1, userid);
			
			ResultSet rs =  ps.executeQuery();
			while(rs.next())
			{
				int userid1 = rs.getInt("userId");
				String userName = rs.getString("userName");
				String email = rs.getString("email");
				String userPhoneNumber = rs.getString("userPhoneNumber");
				String userAddress=rs.getString("userAddress");
				
				User u = new User(userid1,userName,email,userPhoneNumber,userAddress);
				
				return u;
			
			}
		} catch (Exception e) {
			
			System.out.println("Exception in getUserId "+e);
		}
		
		
		return null;
	}
	public User getUserbyName(String userName)
	{
		String sqlQuery = "select * from attendance.User where username = ?";
		try {
			ps = con.prepareStatement(sqlQuery);
			ps.setString(1,userName);
			
			ResultSet rs =  ps.executeQuery();
			while(rs.next())
			{
				int userid = rs.getInt("userId");
				String userName1 = rs.getString("userName");
				String email = rs.getString("email");
				String userPhoneNumber = rs.getString("userPhoneNumber");
				String userAddress=rs.getString("userAddress");
				
				User u = new User(userid,userName1,email,userPhoneNumber,userAddress);
				
				return u;
			
			}
		} catch (Exception e) {
			
			System.out.println("Exception in getUserName "+e);
		}
		
		
		return null;
	}
	public List<User> getAllUser() {
		// TODO Auto-generated method stub
		String sqlQuery = "SELECT * FROM attendance.User";
		List<User> alluser = new ArrayList<User>();
		try {
			ps = con.prepareStatement(sqlQuery);
			
			ResultSet rs =  ps.executeQuery();
			while(rs.next())
			{
				int userid = rs.getInt("userId");
				String userName = rs.getString("userName");
				String email = rs.getString("email");
				String password=rs.getString("Password");
				String userPhoneNumber = rs.getString("userPhoneNumber");
				String userAddress=rs.getString("userAddress");
				int attendance=rs.getInt("Attendance");
				
				User u = new User(userid,userName,email,password,userPhoneNumber,userAddress,attendance);

				alluser.add(u);	
			}
			return alluser;
		}
		catch(Exception e) {
			System.out.println("Exception while getting all Users"+e);
		}
		
		return null;
	}
	
	public boolean deleteUser(int userid)
	{
		String sqlQuery = "delete from attendance.User where userid = ?";
		try {
			ps = con.prepareStatement(sqlQuery);
			ps.setInt(1, userid);
			
			int rs =  ps.executeUpdate();
			if(rs>0) return true;
			return false;

		} catch (Exception e) {
			
			System.out.println("Exception in getUserId "+e);
		}
		return false;
	}
	
	public boolean modifyUser(int userid,String newpassword)
	{
		String sqlQuery = "update attendance.User set password=? where userid = ?";
		try {
			ps = con.prepareStatement(sqlQuery);
			ps.setString(1, newpassword);
			ps.setInt(2, userid);
			
			int rs =  ps.executeUpdate();
			if(rs>0) return true;
			return false;

		} catch (Exception e) {
			
			System.out.println("Exception in getUserId "+e);
		}
		return false;
	}
	
	public User displayAttendance(String userName)
	{
		String sqlQuery="select * from attendance.User where username=?";
		try {
			ps = con.prepareStatement(sqlQuery);
			ps.setString(1, userName);
			
			ResultSet rs =  ps.executeQuery();
			while(rs.next())
			{
				int userid = rs.getInt("userId");
				String userName1 = rs.getString("userName");
				String email = rs.getString("email");
				String password=rs.getString("Password");
				String userPhoneNumber = rs.getString("userPhoneNumber");
				String userAddress=rs.getString("userAddress");
				int attendance=rs.getInt("Attendance");
				User u = new User(userid,userName,email,password,userPhoneNumber,userAddress,attendance);
				return u;
			}
		}catch (Exception e) {
			
			System.out.println("Exception in getUserId "+e);
		}
		return null;
		
		
	}
	public boolean modifyAttendance(int userid,int attendance)
	{
		String sqlQuery = "update attendance.User set attendance=? where userid = ?";
		try {
			ps = con.prepareStatement(sqlQuery);
			ps.setInt(1, attendance);
			ps.setInt(2, userid);
			
			int rs =  ps.executeUpdate();
			if(rs>0) return true;
			return false;

		} catch (Exception e) {
			
			System.out.println("Exception in getUserId "+e);
		}
		return false;
	}
	
}