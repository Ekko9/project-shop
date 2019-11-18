package com.user.bean;

public class CartItem {//购物项
	private Product product;//商品
	private int count=0;//数量
	private double subprice;//小计
	
	
	public CartItem() {
	
	}
	
	public CartItem(Product product, int count) {
		super();
		this.product = product;
		this.count = count;
	}

	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public double getSubprice() {
		return product.getShop_price()*count;
	}
	/*public void setSubprice(double subprice) {
		this.subprice = subprice;
	}*/
	
}
