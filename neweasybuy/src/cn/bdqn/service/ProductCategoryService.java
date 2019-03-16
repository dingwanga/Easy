package cn.bdqn.service;

import java.util.List;
import java.util.Map;
import cn.bdqn.entity.ProductCategory;
import cn.bdqn.util.PageBean;

public interface ProductCategoryService {

	Map<ProductCategory, List<ProductCategory>> findAllCategory(int pageNo,
			int pageSize);

	PageBean<ProductCategory> findByPage(int pageNo, int pageSize);

	Map<ProductCategory, List<ProductCategory>> findAllCategory();

	ProductCategory findCategory(int epcId);
	
	List<ProductCategory> findProductCategorys();
	
	int addCategory(ProductCategory pCategory);
	
	int updateCategory(ProductCategory pCategory);
	
	int delCategory(int epcId);
}
