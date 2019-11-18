package com.user.bean;

public class OrderItem {
	
	private  String    itemid  ;//订单项的idvarchar(32) NOT NULL,
	private  int    count ;//商品的数量` int(11) DEFAULT NULL,# 购买数量
	private  Double    subtotal;  //小计 double DEFAULT NULL,# 小计
	private  Product product;   // 商品
	private  Order  order;    //订单
	
	
	public String getItemid() {
		return itemid;
	}
	public void setItemid(String itemid) {
		this.itemid = itemid;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public Double getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(Double subtotal) {
		this.subtotal = subtotal;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	
	
	
}
