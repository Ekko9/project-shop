package com.user.dao;

import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.user.bean.Category;
import com.user.utils.DataSourceUtils;

public class CategoryDao {

	public List<Category> findCategory() throws Exception {
		
		QueryRunner qr =  new QueryRunner(DataSourceUtils.getDatasource());
		return qr.query("select * from category", new BeanListHandler<Category>(Category.class));
	}

}
