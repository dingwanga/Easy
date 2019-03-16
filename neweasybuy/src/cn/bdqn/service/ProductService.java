package cn.bdqn.service;

import java.util.List;

import cn.bdqn.entity.Product;
import cn.bdqn.util.PageBean;

public interface ProductService {
	
	PageBean<Product> findByPage(int pageNo,int pageSize);
	
	int addProduct(Product product);
	
	Product findById(int epId);
	
	int updateProduct(Product product);
	
	int deleProduct(int epId);
	//查询最近浏览记录
	List<Product> findByIds(String ids);
	
	PageBean<Product> findByPage(int pageNo,int pageSize,int epcId);
}
