package com.user.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {
	
	private   String   oid; //订单id` varchar(32) NOT NULL,
	private   Date   ordertime; //添加订单的时间 datetime DEFAULT NULL,
	private   Double   total  ;  //总金额  double DEFAULT NULL,
	private   int      state = 0;  //0 :未付款   1：已付款  2 ：已发货  3：交易结束   int(11) DEFAULT NULL,
	private   String   address;    //收货地址 varchar(30) DEFAULT NULL,
	private   String   name;   //收货人 varchar(20) DEFAULT NULL,
	private   String   telephone ; //电话varchar(20) DEFAULT NULL,
	
	private   User   user;
	
	private List<OrderItem> list = new ArrayList<OrderItem>();

	public String getOid() {
		return oid;
	}

	public void setOid(String oid) {
		this.oid = oid;
	}

	public Date getOrdertime() {
		return ordertime;
	}

	public void setOrdertime(Date ordertime) {
		this.ordertime = ordertime;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<OrderItem> getList() {
		return list;
	}

	public void setList(List<OrderItem> list) {
		this.list = list;
	}

	
	
	

}
