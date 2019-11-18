package com.user.servlet;

import java.io.IOException;
import java.util.Date;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.tomcat.util.buf.StringUtils;

import com.user.bean.Product;
import com.user.bean.User;
import com.user.service.ProductService;
import com.user.service.UserService;
import com.user.utils.BaseServlet;
import com.user.utils.UUIDUtils;

/**
 * Servlet implementation class SaveProductServlet
 */
public class SaveProductServlet extends BaseServlet {

	private static final long serialVersionUID = 1L;

	// 注册
	public String saveProduct(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");// 处理请求中文乱码
		// 存入到数据库
				String pid = request.getParameter("pid");
				String cid = request.getParameter("cid");
				String pname = request.getParameter("pname");
				String pdesc = request.getParameter("pdesc");
				//String pimage = ;
				Double market_price = Double.parseDouble(request.getParameter("market_price"));
				Double shop_price = Double.parseDouble(request.getParameter("shop_price"));
				Product p = new Product();
				ProductService ps = new ProductService();
				try {
					
					p.setCid(cid);
					p.setPname(pname);
					p.setPdate("2019-05-28");
					p.setPdesc(pdesc);
					p.setPimage("products/"+2+"/"+request.getParameter("pimage"));
					p.setMarket_price(market_price);
					p.setShop_price(shop_price);
					p.setPflag(0);
					p.setIs_hot(0);
					p.setPid(UUIDUtils.getUuuids());
					ps.reg(p);
					System.out.println("保存成功");
											
					if(pid != null) {
						p.setPimage(request.getParameter("pimage"));
						
						ps.updateProduct(p, pid);	
					
					}
						
					
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
				
				
				return "/jsp/adminProduct.jsp";

	}
}
