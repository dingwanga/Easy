package cn.bdqn.dao;

import java.util.List;

import cn.bdqn.entity.ProductCategory;

public interface ProductCategoryDao {

	//分页查询商品父分类
	List<ProductCategory> findProductCategorys(int pageNo,int pageSize);
	//查询所有父分类的记录数
	int categoryCounts();
	//根据父分类查询所有子分类的信息
	List<ProductCategory> findChildCategorys(int epcParentId);
	//查询所有父分类
	List<ProductCategory> findProductCategorys();
	//根据id查询分类信息
	ProductCategory findCategory(int epcId);
	//添加子分类
	int addCategory(ProductCategory pCategory); 
	//修改商品分类
	int updateCategory(ProductCategory pCategory);
	//根据分类别编号删除商品分类
	int deleteBypId(int epcId); 
	//根据主键id删除分类
	int deleteCategory(int epcId);
}
