package com.user.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.user.bean.Cart;
import com.user.bean.CartItem;
import com.user.bean.Product;
import com.user.bean.User;
import com.user.service.ProductService;
import com.user.utils.BaseServlet;

public class CartServlet extends BaseServlet {

	private static final long serialVersionUID = 1L;

	public String add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = (User) request.getSession().getAttribute("user");
		if (user == null) {
			request.setAttribute("msg", "请登录");
			return "/jsp/login.jsp";
		}
		// 获得商品的id
		String pid = request.getParameter("pid");
		int count = Integer.parseInt(request.getParameter("count"));
		// 获得购物车
		Cart cart = getCart(request);
		ProductService ps = new ProductService();
		try {
			Product product = ps.findByPid(pid);
			CartItem cartItem = new CartItem(product, count);
			cart.addToCart(cartItem);// 购物项添加到了购物车

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "/jsp/cart.jsp";// 跳转

	}

	// 删除购物车中的商品

	public String delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		User user = (User) request.getSession().getAttribute("user");
		if (user == null) {
			request.setAttribute("msg", "请登录");
			return "/jsp/login.jsp";
		}
		// 获得商品的id
		String pid = request.getParameter("pid");
		Cart cart = getCart(request);
		cart.removeCart(pid);// 移除购物项
		return "/jsp/cart.jsp";// 跳转

	}

	// 清空购物车
	public String clearCart(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		User user = (User) request.getSession().getAttribute("user");
		if (user == null) {
			request.setAttribute("msg", "请登录");
			return "/jsp/login.jsp";
		}
		// 获得商品的id
		Cart cart = getCart(request);
		cart.clearCart();
		return "/jsp/cart.jsp";// 跳转

	}

	// 获得session在session中获得购物车
	private Cart getCart(HttpServletRequest request) {
		Cart cart = (Cart) request.getSession().getAttribute("cart");
		if (cart == null) {
			cart = new Cart();
			// 将购物车放到session中
			request.getSession().setAttribute("cart", cart);
		}

		return cart;
	}

}
