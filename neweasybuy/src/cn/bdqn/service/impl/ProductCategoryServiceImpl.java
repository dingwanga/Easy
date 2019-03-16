package cn.bdqn.service.impl;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import cn.bdqn.dao.ProductCategoryDao;
import cn.bdqn.dao.ProductDao;
import cn.bdqn.dao.impl.ProductCategoryDaoImpl;
import cn.bdqn.dao.impl.ProductDaoImpl;
import cn.bdqn.entity.ProductCategory;
import cn.bdqn.service.ProductCategoryService;
import cn.bdqn.util.PageBean;

public class ProductCategoryServiceImpl implements ProductCategoryService {

	private ProductCategoryDao pcDao = new ProductCategoryDaoImpl();
	private ProductDao pDao = new ProductDaoImpl();
	@Override
	public Map<ProductCategory, List<ProductCategory>> findAllCategory(
			int pageNo, int pageSize) {
		Map<ProductCategory, List<ProductCategory>> mapCategory = new LinkedHashMap<ProductCategory, List<ProductCategory>>();
		PageBean<ProductCategory> pagePc = new PageBean<ProductCategory>();
		pagePc.setPageSize(pageSize);
		pagePc.setTotalCount(pcDao.categoryCounts());
		pagePc.setCurrPageNo(pageNo);
		pagePc.setPageList(pcDao.findProductCategorys(pageNo, pageSize));
		for (ProductCategory pc : pagePc.getPageList()) {
			List<ProductCategory> list = pcDao.findChildCategorys(pc
					.getEpcParentId());
			mapCategory.put(pc, list);
		}
		return mapCategory;
	}

	@Override
	public PageBean<ProductCategory> findByPage(int pageNo, int pageSize) {
		PageBean<ProductCategory> pCategory = new PageBean<ProductCategory>();
		pCategory.setPageSize(pageSize);
		pCategory.setTotalCount(pcDao.categoryCounts());
		pCategory.setCurrPageNo(pageNo);
		pCategory.setPageList(pcDao.findProductCategorys(pageNo, pageSize));
		return pCategory;
	}

	public Map<ProductCategory, List<ProductCategory>> findAllCategory() {
		Map<ProductCategory, List<ProductCategory>> mapCategory = new LinkedHashMap<ProductCategory, List<ProductCategory>>();
		List<ProductCategory> paCategory = pcDao.findProductCategorys();
		for (ProductCategory pc : paCategory) {
			List<ProductCategory> list = pcDao.findChildCategorys(pc
					.getEpcParentId());
			mapCategory.put(pc, list);
		}
		return mapCategory;
	}

	@Override
	public ProductCategory findCategory(int epcId) {
		return pcDao.findCategory(epcId);
	}

	@Override
	public List<ProductCategory> findProductCategorys() {
		return pcDao.findProductCategorys();
	}

	@Override
	public int addCategory(ProductCategory pCategory) {
		
		return pcDao.addCategory(pCategory);
	}

	@Override
	public int updateCategory(ProductCategory pCategory) {
		
		return pcDao.updateCategory(pCategory);
	}

	@Override
	public int delCategory(int epcId) {
		//第一步如果是父分类就查找所有的子分类
		List<ProductCategory> plist=pcDao.findChildCategorys(epcId);
		//如果不为空，就更新商品id的信息
		int result=0;
		if(plist.size()!=0){
			for (ProductCategory pCategory : plist) {
				int childId=pCategory.getEpcId();
				result=pDao.updateEpcId(childId);
			}
		}else{
			//如果没有子分类就更新对应的商品分类
			result=pDao.updateEpcId(epcId);
		}
		//根据父类id删除分类信息
		pcDao.deleteBypId(epcId);
		pcDao.deleteCategory(epcId);
		return result;
	}
	
}
