package com.capg.Attendance.ui;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import com.capg.Attendance.Beans.Login;
import com.capg.Attendance.Beans.User;
import com.capg.Attedance.dao.LoginDAO;
import com.capg.Attedance.dao.LoginDAOImpl;
import com.capg.Attendance.exception.InvalidUserId;
import com.capg.Attendance.service.UserService;
import com.capg.Attendance.service.UserServiceImpl;
import com.capg.Attendance.sorting.AttendanceHighToLow;
import com.capg.Attendance.sorting.AttendanceLowToHigh;


public class Application {
	Scanner sc=new Scanner(System.in);
	Scanner sc1=new Scanner(System.in);
	LoginDAO login=new LoginDAOImpl();
	UserService userservice=new UserServiceImpl();
	public static void main(String[] args) {
	
	Application ap = new Application();
	ap.Menu();
	}
	
	public void Menu() 
	{
	while(true)
	{
	System.out.println("1.Login");
	System.out.println("0.Logout");
	System.out.println("Enter your option:");
	int op=sc.nextInt();
	switch(op)
	{
	case 1:login();
	break;
	case 0:System.exit(0);
	break;
	}
	}
	}
	public void login() {
		System.out.println("Type of user");
		System.out.println("1.Admin");
		System.out.println("2.User");
		int u=sc.nextInt();
		switch(u) {
		case 1:Admin();
		break;
		case 2:user();
		break;
		}
		}
	public void Admin() {
		 //Admin();
		System.out.println("Enter your Username");
		String username=sc1.nextLine();
		System.out.println("Enter Your Password ");
		String password1=sc1.nextLine();
		if(login.checkAdminName(username,password1))
		{
			System.out.println("Operation to be performed");
			System.out.println("1.Add a new record");
			System.out.println("2.Get User By Id");
			System.out.println("3.Get User By Name");
			System.out.println("4.Display Record");
			System.out.println("5.Remove Record");
			System.out.println("6.Update Record");
			System.out.println("7.Sort Attendance High to Low");
			System.out.println("8.Sort Attendance Low to High");
			System.out.println("9.Modify Attendance");
			int ch=sc.nextInt();
			switch(ch)
			{
			case 1:addRecord();
			break;
			case 2:getUserById();
			break;
			case 3:getUserByName();
			break;
			case 4:displayRecord();
			break;
			case 5:deleteRecord();
			break;
			case 6:modifyRecord();
			break;
			case 7:sortAttendanceHighToLow();
			break;
			case 8:sortAttendanceLowToHigh();
			break;
			 default:System.out.println("Thank You");
			}
		
		}
		else {
			System.out.println("Enter valid Username and Password");
		}
	}

	
	public void user() {
		 //user();
		System.out.println("Enter your Username");
		String Username=sc1.nextLine();
		System.out.println("Enter Your Password ");
		String password=sc1.nextLine();
		if(login.checkUserName(Username,password))
		{
			System.out.println("Operation to be performed");
			System.out.println("1.Display Attendance");
			int ch=sc.nextInt();
			switch(ch)
			{
			case 1:displayAttendance();
			break;
			 default:System.out.println("Thank You");
			}
			
			}
		else {
			System.out.println("Enter valid Username and Password");
		}
		
	
	}
	public void addRecord() 
	{
		User u1=new User(101,"Manoj","manoj65@gmail.com","#123","745892670","Andhra Pradesh",80);
		User u2=new User(103,"Krishna Vamsi","vamsi98@gmail.com","12@krishna","739035534","Telengana",85);
		User u3=new User(104,"Aarti","aarti27@gmail.com","aarti6","984995800","Tamil Nadu",79);
		User u4=new User(109,"Swetha","swetha98@gmail.com","swetha&re","934783679","Andhra Pradesh",92);
		User u5=new User(151,"Vamsi","vamsi21@gmail.com","vamsi*4","96849437","Karnataka",63);
		userservice.insertUser(u1);
		userservice.insertUser(u2);
		userservice.insertUser(u3);
		userservice.insertUser(u4);
		userservice.insertUser(u5);
		System.out.println("Done");
		
	}
	public void getUserById()
	{
		System.out.println("Enter user Id:");
		int uid=sc.nextInt();
		try {
			userservice.getUserbyId1(uid);
		} catch (InvalidUserId e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Task : Get User by Id is done");
	}
	private void getUserByName()  {
		// TODO Auto-generated method stub
		System.out.println("Enter user Name:");
		int uname=sc.nextInt();
		try {
			userservice.getUserbyId1(uname);
		} catch (InvalidUserId e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Task : Get User by Name is done");
	}
	private void deleteRecord() {
		System.out.println("Enter userid to delete the record");
		int uid1=sc.nextInt();
		userservice.deleteUser(uid1);
		System.out.println("Task : Deleting a Record done");
	}

	public void modifyRecord() {
		System.out.println("Enter Userid");
		int uid2=sc.nextInt();
		System.out.println("Enter new password:");
		String str=sc1.nextLine();
		userservice.modifyUser(uid2, str);
		
	}
	public void displayRecord() {
		userservice.getallUser();
	}
	public void displayAttendance() {
		System.out.println("Enter your username:");
		String str3=sc1.nextLine();
		userservice.displayAttendance(str3);
	}
	private void modifyAttendance() {
		System.out.println("Enter userid:");
		int uid3=sc.nextInt();
		System.out.println("Enter updated Attendance:");
		int att=sc.nextInt();
		userservice.modifyAttendance(uid3, att);
	}

	private void sortAttendanceHighToLow() {
		List<User> ulist=new ArrayList<User>();
		ulist.addAll(ulist);
		Collections.sort(ulist, new AttendanceHighToLow());
	}
	private void sortAttendanceLowToHigh() {
		List<User> ulst=new ArrayList<User>();
		ulst.addAll(ulst);
		Collections.sort(ulst, new AttendanceLowToHigh());
	}

}