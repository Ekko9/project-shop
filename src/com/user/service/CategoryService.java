package com.user.service;

import java.util.List;

import com.user.bean.Category;
import com.user.dao.CategoryDao;

public class CategoryService {

	public List<Category> findCategory() throws Exception {
		CategoryDao cd = new CategoryDao();
		return cd.findCategory();
	}

}
