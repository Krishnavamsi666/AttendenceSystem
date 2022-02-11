package com.capg.Attedance.dao;
import com.capg.Attendance.Beans.User;
import java.util.List;

public interface UserDAO {
	public boolean insertUserDAO(User u);
	public User getUserbyId(int userid);
	public User getUserbyName(String userName);
	public List<User> getAllUser();
	public boolean deleteUser(int userid);
	public boolean modifyUser(int userid,String newpassword);
	public User displayAttendance(String userName);
	public boolean modifyAttendance(int userid,int attendance);
}

