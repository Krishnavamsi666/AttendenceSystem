package com.capg.Attedance.dao;
import com.capg.Attendance.Beans.Login;
public interface LoginDAO {
	public boolean checkUserName(String email,String password);
	public boolean checkAdminName(String uname, String password1);
}

