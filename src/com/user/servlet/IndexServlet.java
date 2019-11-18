package com.user.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.user.bean.Product;
import com.user.service.ProductService;
import com.user.utils.BaseServlet;

public class IndexServlet extends BaseServlet {

	/*public String index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		return "/jsp/index.jsp";

	}*/
	/*public String index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		CategoryService cs = new CategoryService();
		try {
			List<Category> list = cs.findCategory();
			request.setAttribute("list", list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "/jsp/index.jsp";

	}*/
	
	public String index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		  ProductService  ps = new ProductService();
		    try {
				List<Product>  fns  =   ps.fnews();
				List<Product>  fhs  =  ps.fhots();
				
				request.setAttribute("fns", fns);  //最新
				request.setAttribute("fhs", fhs);  //最热门
				
			} catch (Exception e) {
				
				e.printStackTrace();
			}
		
			return "/jsp/index.jsp";
		}
}
