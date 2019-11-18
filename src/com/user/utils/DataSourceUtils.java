package com.user.utils;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class DataSourceUtils {
	//主要的目的是获得连接池对象
	private static final ComboPooledDataSource dataSource = new ComboPooledDataSource();
	
	public  static DataSource getDatasource() {
		
		  
		return dataSource;
		
	}

}
