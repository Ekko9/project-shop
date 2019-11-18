package com.user.dao;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.user.bean.Admin;
import com.user.utils.DataSourceUtils;

public class AdminDao {

	public Admin findName(String uname) throws Exception {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDatasource());
		
		return qr.query("select * from admin where username=?", new BeanHandler<Admin>(Admin.class), uname);
	}

	public Admin loginer(Admin admin) throws Exception {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDatasource());
	return	qr.query("select * from admin where username=? and password=?", new BeanHandler<Admin>(Admin.class),admin.getUsername(),admin.getPassword());
		
	}
}
