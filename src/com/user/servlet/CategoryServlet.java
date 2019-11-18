package com.user.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.user.bean.Category;
import com.user.service.CategoryService;
import com.user.utils.BaseServlet;

public class CategoryServlet extends BaseServlet {

	private static final long serialVersionUID = 1L;

	public String findCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		CategoryService cs = new CategoryService();
	    try {
			List<Category> list = cs.findCategory();
			ObjectMapper om = new ObjectMapper();
			String str = om.writeValueAsString(list);
			response.getWriter().print(str);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

}
