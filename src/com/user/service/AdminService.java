package com.user.service;

import com.user.bean.Admin;
import com.user.dao.AdminDao;

public class AdminService {

	public Admin findName(String uname) throws Exception {
		AdminDao rd = new AdminDao();
		return rd.findName(uname);
	
	}

	public Admin loginer(Admin admin) throws Exception {
		AdminDao ud = new AdminDao();
		return ud.loginer(admin);
	}
}
