package com.user.service;

import com.user.dao.UserDao;
import com.user.bean.User;

public class UserService {

	public  void reg(User u) throws Exception {
		UserDao ud = new UserDao();
		ud.reg(u);

	}

	public User findName(String uname) throws Exception {
		UserDao rd = new UserDao();
		return rd.findName(uname);
	
	}

	public User loginer(User u) throws Exception {
		UserDao ud = new UserDao();
		return ud.loginer(u);
	}
	
	

	

}
