package com.user.service;

import java.sql.SQLException;
import java.util.List;

import com.user.bean.PageBean;
import com.user.bean.Product;
import com.user.bean.User;
import com.user.dao.ProductDao;
import com.user.dao.UserDao;

public class ProductService {

	public List<Product> fnews() throws Exception {
		ProductDao pd = new ProductDao();
		return pd.fnews();
	}

	public List<Product> fhots() throws Exception {
		ProductDao pd = new ProductDao();
		return pd.fhots();
	}


	public Product findByPid(String pid) throws Exception {
		ProductDao pd = new ProductDao();
		return pd.findByPid(pid);
	}
	
	public List<Product> findAll() throws Exception {
		ProductDao pd = new ProductDao();
		return pd.findAll();
		
	}
	
	public void delete(String pid) throws SQLException {
		ProductDao pd = new ProductDao();
		pd.delete(pid);
	}

	public PageBean findBycid(String cid,int pageNumber) throws Exception {
		ProductDao pd = new ProductDao();
		PageBean pb = new PageBean();
		pb.setPageNumber(pageNumber);
		int pageSize = 12;
		pb.setPageSize(pageSize);
		int totalCount = pd.findBycid(cid);
		pb.setTotalCount(totalCount);
		int totalPage = 0;
		if(totalCount % pageSize == 0) {
			totalPage = totalCount / pageSize;
		}else {
			totalPage = totalCount / pageSize + 1;
		}
		pb.setTotalPage(totalPage);
		int startIndex = (pageNumber - 1) * pageSize;
		List<Product> list = pd.findBycid(cid,startIndex,pageSize);
		pb.setList(list);
		return pb;
	}

	public  void reg(Product p) throws Exception {
		ProductDao pd = new ProductDao();
		pd.reg(p);

	}
	
	public Product selectProductById(String pid) throws SQLException {
		ProductDao pd = new ProductDao();
		return pd.selectProductById(pid);
	}
	
	public void updateProduct(Product p,String pid) throws Exception {
		ProductDao pd = new ProductDao();
		pd.updateProduct(p,pid);
	}
}
