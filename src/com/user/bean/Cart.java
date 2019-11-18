package com.user.bean;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Cart {
	private Double totalCount = 0.0;// 总金额
	private Map<String, CartItem> map = new HashMap<String, CartItem>();

	public void addToCart(CartItem cartItem) {// 添加商品到购物车

		// 获得商品的ID
		String pid = cartItem.getProduct().getPid();
		// 判断之前是否买过该商品
		if (!map.containsKey(pid)) {
			map.put(pid, cartItem);
		} else {
			// 获得之前购物车中商品的数量
			int oldCount = map.get(pid).getCount();
			// 新添加的加上之前的
			int newCount = oldCount + cartItem.getCount();
			CartItem cartItem2 = map.get(pid);
			cartItem2.setCount(newCount);// 添加后购物车中的商品数量
		}
		totalCount = totalCount + cartItem.getSubprice();// 小计
	}

	// 移除购物车中的商品,通过商品的id移除
	public void removeCart(String pid) {
		CartItem cartItem = map.remove(pid);
		totalCount = totalCount - cartItem.getSubprice();
	}

	public Collection<CartItem> getItem() {
		Collection<CartItem> values = map.values();
		return values;
	}

	// 清除购物车
	public void clearCart() {
		map.clear();
		totalCount = 0.0;
	}

	public Double getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Double totalCount) {
		this.totalCount = totalCount;
	}

	public Map<String, CartItem> getMap() {
		return map;
	}

	public void setMap(Map<String, CartItem> map) {
		this.map = map;
	}

}
