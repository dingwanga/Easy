package cn.bdqn.dao;

import java.util.List;

import cn.bdqn.entity.Product;

public interface ProductDao {
	//分页查询商品信息
	List<Product> findProducts(int pageNo,int pageSize);
	//查询商品的总记录数
	int findTotalCount();
	//增加商品信息
	int addProduct(Product product);
	//根据id查找商品信息
	Product findById(int epId);
	//根据id修改商品信息
	int updateProduct(Product product);
	//根据id删除商品信息
	int deleProduct(int epId);
	//删除大类 的时候将所有商品的信息改为未分类,只改的id
	int updateEpcId(int epcId);
	
	List<Product> findProducts(int pageNo,int pageSize,int epcId);
	
	int findTotalCount(int epcId);
	
}
