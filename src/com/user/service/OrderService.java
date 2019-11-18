package com.user.service;

import java.util.List;

import com.user.bean.Order;
import com.user.bean.OrderItem;
import com.user.dao.OrderDao;

public class OrderService {

	public void addOrder(Order order) throws Exception {
		
		OrderDao od = new OrderDao();
		od.addOrder(order);
		for(OrderItem orderItem : order.getList()) {
			
			od.addOrderItem(orderItem);
		}
	}

	public List<Order> findAllOrder(String uid) throws Exception {
		OrderDao od = new OrderDao();
		return od.findAllOrder(uid);
	}

	public Order findByoid(String oid) throws Exception {
		OrderDao  oder =  new OrderDao(); 
		return oder.findByoid(oid);
	}

}
