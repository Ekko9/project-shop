package com.user.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;

import com.user.bean.Order;
import com.user.bean.OrderItem;
import com.user.bean.Product;
import com.user.utils.DataSourceUtils;

public class OrderDao {

	public void addOrderItem(OrderItem orderItem) throws Exception {// 插入到订单项的数据库

		QueryRunner qr = new QueryRunner(DataSourceUtils.getDatasource());
		String sql = "insert into orderitem values(?,?,?,?,?) ";
		qr.update(sql, orderItem.getItemid(), orderItem.getCount(), orderItem.getSubtotal(),
				orderItem.getProduct().getPid(), orderItem.getOrder().getOid());
	}

	public void addOrder(Order order) throws Exception {// 插入到订单的数据库

		QueryRunner qr = new QueryRunner(DataSourceUtils.getDatasource());
		String sql = "insert into orders values(?,?,?,?,?,?,?,?)";
		qr.update(sql, order.getOid(), order.getOrdertime(), order.getTotal(), order.getState(), order.getAddress(),
				order.getName(), order.getTelephone(), order.getUser().getUid());
	}

	public List<Order> findAllOrder(String uid) throws Exception {
		
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDatasource());
		//sql
		String sql = "select * from orders where uid = ?";
		
		// 执行查询操作
		List<Order> list = qr.query(sql, new BeanListHandler<Order>(Order.class), uid);
		for (Order order : list) {
            //订单项表和商品表符合条件的查询出来
			String sqlq = "select *  from  product p ,orderitem o where p.pid = o.pid and o.oid = ? ";
		
			List<Map<String, Object>> listq = qr.query(sqlq, new MapListHandler(), order.getOid());
			for (Map<String, Object> map : listq) {
				
				//数据的封装
				// 商品的封装
				 Product product = new Product();
				 BeanUtils.populate(product, map);
				//封装订单项
				 OrderItem orderItem = new OrderItem();
				 BeanUtils.populate(orderItem, map);
				//将商品放到订单项中
				 orderItem.setProduct(product);
				//将订单项放到订单中
				 order.getList().add(orderItem);
				
			}
			
			
		}
		 
		 
		return list;
	}

	public Order findByoid(String oid) throws Exception {
		QueryRunner  qr = new QueryRunner(DataSourceUtils.getDatasource());
		String sql = "select * from orders where oid = ?";
		Order order = qr.query(sql, new BeanHandler<Order>(Order.class), oid);
		
		String sqlq = "select *  from  product p ,orderitem o where p.pid = o.pid and o.oid = ? ";
		
		List<Map<String, Object>> list = qr.query(sqlq, new MapListHandler(), order.getOid());
		
		for (Map<String, Object> map : list) {
			
			// 对象的封装
			 Product  product = new Product();
			 BeanUtils.populate(product, map);
			 //订单项
			 OrderItem orderItem = new OrderItem();
			 BeanUtils.populate(orderItem, map);
			 orderItem.setProduct(product);
			 
			 //将订单项放到订单中
			 order.getList().add(orderItem);
			
			
		}
		
		return order;
	}

}
