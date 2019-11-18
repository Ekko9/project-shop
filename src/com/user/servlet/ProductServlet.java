package com.user.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.user.bean.PageBean;
import com.user.bean.Product;
import com.user.service.ProductService;
import com.user.utils.BaseServlet;
import com.user.utils.UUIDUtils;

public class ProductServlet extends BaseServlet {

	public String findBypid(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pid = request.getParameter("pid");
		ProductService ps = new ProductService();
		try {
			Product product = ps.findByPid(pid);
			request.setAttribute("pro", product);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "/jsp/product_info.jsp";

	}
	
	public String findBycid(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cid = request.getParameter("cid");
		ProductService ps = new ProductService();
		int pageNumber = Integer.parseInt(request.getParameter("pageNumber")) ;
		try {
			PageBean pb =  ps.findBycid(cid,pageNumber);
			request.setAttribute("pb", pb);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "/jsp/product_list.jsp";

	}

	
	public String findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProductService ps = new ProductService();
		try {
			List<Product> productList = ps.findAll();
			
			request.setAttribute("productList", productList);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "/jsp/findProduct.jsp";
		
	}
	
	public String delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pid = request.getParameter("pid");
		ProductService ps = new ProductService();
		try {
			ps.delete(pid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "/jsp/adminProduct.jsp";
	}
	
	public String update(HttpServletRequest request, HttpServletResponse response) {
		String pid = request.getParameter("pid");
		ProductService ps = new ProductService();
		try {
		Product product = ps.selectProductById(pid);
		
		request.setAttribute("product", product);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "/jsp/saveProduct.jsp";
	}
	
}

