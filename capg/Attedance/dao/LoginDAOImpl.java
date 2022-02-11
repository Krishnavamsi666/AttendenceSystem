package com.capg.Attedance.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import com.capg.Attendance.Beans.Login;
import com.capg.Attendance.util.DBConnection;

public class LoginDAOImpl implements LoginDAO {
	
	public boolean checkUserName(String email,String password)
	{
		boolean result=false;
		List<String> username=new ArrayList<String>();
		List<String> pass=new ArrayList<String>();
		
		username.add("manoj65@gmail.com");
		username.add("vamsi98@gmail.com");
		username.add("aarti27@gmail.com");
		username.add("swetha98@gmail.com");
		
		pass.add("#123");
		pass.add("12@krishna");
		pass.add("aarti6");
		pass.add("swetha&re");
		
		String regex = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$";
		if(email.matches(regex)) {
			if(username.contains(email) && pass.contains(password)) {
				if(username.indexOf(email)==pass.indexOf(password)) {
					System.out.println("You are Logged in");
					result=true;
				}
			}
			else {
				System.out.println("Please,Enter the correct Username and Password");
				result=false;
			}
		}
		else {
			System.out.println("Enter valid Username");
			result=false;
		}
		return result;
		
	}
	
	public boolean checkAdminName(String uname, String password1)
	{
		boolean result=false;
		String adminname="attendanceapp@gmail.com";
		String pass1="Admin123";
		String regex = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$";
		if(uname.matches(regex)) {
			if(adminname.contains(uname) && pass1.contains(password1)) {
				if(adminname.indexOf(uname)==pass1.indexOf(password1)) {
					System.out.println("You are Logged in");
					result=true;
				}
			}
			else {
				System.out.println("Please,Enter the correct Username and Password");
				result=false;
			}
		}
		else {
			System.out.println("Enter valid Username");
			result=false;
		}
		return result;
	}

}
