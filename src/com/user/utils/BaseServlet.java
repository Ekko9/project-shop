package com.user.utils;

import java.io.IOException;
import java.lang.reflect.Method;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BaseServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		        // 解决请求乱码
				request.setCharacterEncoding("utf-8");
				// 接收method的方法名字
				String methodName = request.getParameter("method");
				if (methodName == null || methodName.trim().length() == 0) {

					methodName = "index"; // 实际项目需要
				}
				// 获得字节码对象
				Class clazz = this.getClass();
				// 获得方法对象
				try {
					Method method = clazz.getMethod(methodName, HttpServletRequest.class,HttpServletResponse.class);
				    String path = (String) method.invoke(this, request,response);
				    if(path!=null) {
				    	request.getRequestDispatcher(path).forward(request, response);
				    }
				
				} catch (Exception e) {
					e.printStackTrace();
				} 

			}

		}
