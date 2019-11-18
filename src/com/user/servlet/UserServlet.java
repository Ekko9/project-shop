package com.user.servlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;

import com.user.bean.Admin;
import com.user.bean.User;
import com.user.service.AdminService;
import com.user.service.UserService;
import com.user.utils.BaseServlet;
import com.user.utils.UUIDUtils;

public class UserServlet extends BaseServlet {

	private static final long serialVersionUID = 1L;

	// 注册
	public String register(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");// 处理请求中文乱码
		Map<String, String[]> map = request.getParameterMap();
		User u = new User();
		try {
			BeanUtils.populate(u, map);
			UserService us = new UserService();
			u.setUid(UUIDUtils.getUuuids());
			us.reg(u);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "/jsp/login.jsp";

	}

	// 验证用户名
	public String registerUname(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");// 处理请求中文乱码
		request.getParameter("uname");
		String uname = request.getParameter("uname");
		UserService rs = new UserService();

		try {
			User u = rs.findName(uname);

			if (u == null) {
				response.getWriter().print("1");
			} else {
				response.getWriter().print("0");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		  
		return null;
	}

	//管理员登录
	
	public String adminLogin(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");// 处理请求中文乱码
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String rn = request.getParameter("rememberName");
		Admin admin = new Admin();
		admin.setUsername(username);
		admin.setPassword(password);
		AdminService as = new AdminService();
		try {
			Admin admin1 = as.loginer(admin);
			if (admin1 == null) {
				request.setAttribute("message", "用户名或密码错误");
				return "/jsp/login1.jsp";
			} else {
				// 创建Session对象
				/*HttpSession session = request.getSession();
				session.setAttribute("user", admin1);
				if(rn != null) {
					Cookie c = new Cookie("username",admin1.getUsername());
					c.setMaxAge(60 * 60);
					response.addCookie(c);
					//response.sendRedirect(request.getContextPath()+"/index.jsp");
				}else {
					Cookie c = new Cookie("username",admin1.getUsername());
					c.setMaxAge(0);
					response.addCookie(c);
				}*/
				/*response.sendRedirect(request.getContextPath()+"/register.jsp");*/
				return "/jsp/adminProduct.jsp";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	// 登录
	public String login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");// 处理请求中文乱码
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String rn = request.getParameter("rememberName");
		User u = new User();
		u.setUsername(username);
		u.setPassword(password);
		UserService us = new UserService();
		try {
			User user = us.loginer(u);
			if (user == null) {
				request.setAttribute("message", "用户名或密码错误");
				return "/jsp/login.jsp";
			} else {
				// 创建Session对象
				HttpSession session = request.getSession();
				session.setAttribute("user", user);
				if(rn != null) {
					Cookie c = new Cookie("username",user.getUsername());
					c.setMaxAge(60 * 60);
					response.addCookie(c);
					//response.sendRedirect(request.getContextPath()+"/index.jsp");
				}else {
					Cookie c = new Cookie("username",user.getUsername());
					c.setMaxAge(0);
					response.addCookie(c);
				}
				response.sendRedirect(request.getContextPath()+"/index.jsp");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}
	//退出
	public String exit(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");// 处理请求中文乱码
		request.getSession().invalidate();
		response.sendRedirect(request.getContextPath()+"/index.jsp");
		return null;
	}
}
