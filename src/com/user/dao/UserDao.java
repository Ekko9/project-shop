package com.user.dao;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.user.bean.User;
import com.user.utils.DataSourceUtils;

public class UserDao {

	public void reg(User u) throws Exception {
		
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDatasource());
		qr.update("insert into user values(?,?,?)", u.getUid(),u.getUsername(),u.getPassword());
	}

	public User findName(String uname) throws Exception {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDatasource());
		
		return qr.query("select * from user where username=?", new BeanHandler<User>(User.class), uname);
	}

	public User loginer(User u) throws Exception {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDatasource());
	return	qr.query("select * from user where username=? and password=?", new BeanHandler<User>(User.class),u.getUsername(),u.getPassword());
		
	}

}
