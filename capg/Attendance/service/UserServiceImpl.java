package com.capg.Attendance.service;
import java.util.List;
import com.capg.Attendance.Beans.User;
import com.capg.Attedance.dao.UserDAO;
import com.capg.Attedance.dao.UserDAOImpl;
import com.capg.Attendance.exception.InvalidUserId;
import com.capg.Attendance.exception.InvalidUserInput;

public class UserServiceImpl implements UserService {
	
	UserDAO userdao=new UserDAOImpl();
	public boolean insertUser(User user) {
		userdao.insertUserDAO(user);
		return false;
	}
	
	public User getUserbyId1(int userid) throws InvalidUserId {
		// TODO Auto-generated method stub
		User usr= userdao.getUserbyId(userid); 
		if(usr==null)
		{
			throw new InvalidUserId();
		}
		return usr;
	}
	public User getUserbyName1(String userName) throws InvalidUserInput
	{
		User usr1=userdao.getUserbyName(userName);
		if(usr1==null)
		{
			throw new InvalidUserInput();
		}
		return usr1;
	}
	public List<User> getallUser()
	{
		List<User> users=null;
		users=userdao.getAllUser();
		
		return users;

	}
	public boolean deleteUser(int userid)
	{
		userdao.deleteUser(userid);
		return false;
	}
	public boolean modifyUser(int userid,String newpassword)
	{
		userdao.modifyUser(userid, newpassword);
		return false;
	}
	public User displayAttendance(String userName)
	{
		User usr2=userdao.displayAttendance(userName);
		return usr2;
		
	}
	public boolean modifyAttendance(int userid,int attendance)
	{
		userdao.modifyAttendance(userid,attendance);
		return false;
	}

}
