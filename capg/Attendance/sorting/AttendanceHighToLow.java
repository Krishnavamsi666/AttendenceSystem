package com.capg.Attendance.sorting;
import java.util.Comparator;

import com.capg.Attendance.Beans.User;

public class AttendanceHighToLow implements Comparator<User> {

	public int compare(User o1, User o2) {
		// TODO Auto-generated method stub
		return o2.getAttendance()-o2.getAttendance();
	}

}