package com.user.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.user.bean.Product;
import com.user.bean.User;
import com.user.utils.DataSourceUtils;

public class ProductDao {

	public List<Product> fnews() throws Exception {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDatasource());
		String sql = "select * from product where pflag = ? order by pdate desc limit ? ";
		return qr.query(sql, new BeanListHandler<Product>(Product.class), 0,9);
	}

	public List<Product> findAll() throws SQLException{
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDatasource());
		String sql = "select * from product";
		return qr.query(sql, new BeanListHandler<Product>(Product.class));
	}
	
	public List<Product> fhots() throws Exception {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDatasource());
		String sql = "select * from product where pflag = ? and is_hot = ? limit ?";
		return qr.query(sql, new BeanListHandler<Product>(Product.class), 0,1,9);
	}


	public Product findByPid(String pid) throws Exception {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDatasource());
		return qr.query("select * from product where pid=?", new BeanHandler<Product>(Product.class),pid);
	}

	public List<Product> findBycid(String cid,int startIndex,int pageSize) throws Exception {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDatasource());
		return qr.query("select * from product where cid=? limit ? , ? ", new BeanListHandler<Product>(Product.class),cid,startIndex,pageSize);
	}

	public int findBycid(String cid) throws Exception {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDatasource());
		
		Long nubers = (Long) qr.query("select count(*) from product where cid=?", new ScalarHandler(),cid);
		return nubers.intValue();
	}
	
	public void reg(Product p) throws Exception {
		
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDatasource());
		qr.update("insert into product values(?,?,?,?,?,?,?,?,?,?)",
				p.getPid(),p.getPname(),p.getMarket_price(),p.getShop_price(),p.getPimage(),p.getPdate(),p.getIs_hot(),p.getPdesc(),p.getPflag(),p.getCid());
	}
	
	public void delete(String pid) throws SQLException {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDatasource());
		qr.update("delete from product where pid=?",pid);
	}
	
	public Product selectProductById(String pid) throws SQLException {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDatasource());
		
		return qr.query("select * from product where pid=?", new BeanHandler<>(Product.class),pid);
	}
	
	public void updateProduct(Product p,String pid) throws SQLException {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDatasource());
		qr.update("update product set pname=?,market_price=?,shop_price=?,pimage=?,pdate=?,is_hot=?,pdesc=?,pflag=?,cid=? where pid=?",p.getPname(),p.getMarket_price(),p.getShop_price(),p.getPimage(),p.getPdate(),p.getIs_hot(),p.getPdesc(),p.getPflag(),p.getCid(),pid);
	}

}
