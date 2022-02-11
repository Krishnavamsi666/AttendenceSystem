package com.capg.Attendance.service;
import java.util.List;
import com.capg.Attendance.Beans.User;
import com.capg.Attendance.exception.InvalidUserId;
import com.capg.Attendance.exception.InvalidUserInput;

public interface UserService {
	public boolean insertUser(User user);
	public User getUserbyId1(int userid)throws InvalidUserId;
	public User getUserbyName1(String userName)throws InvalidUserInput;
	public List<User> getallUser();
	public boolean deleteUser(int userid);
	public boolean modifyUser(int userid,String newpassword);
	public User displayAttendance(String userName);
	public boolean modifyAttendance(int userid,int attendance);
}
