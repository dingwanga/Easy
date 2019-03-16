package cn.bdqn.service.impl;

import java.util.ArrayList;
import java.util.List;
import cn.bdqn.dao.ProductDao;
import cn.bdqn.dao.impl.ProductDaoImpl;
import cn.bdqn.entity.Product;
import cn.bdqn.service.ProductService;
import cn.bdqn.util.PageBean;

public class ProductServiceImpl implements ProductService {
	private ProductDao pDao = new ProductDaoImpl();

	@Override
	public PageBean<Product> findByPage(int pageNo, int pageSize) {
		PageBean<Product> pageBean = new PageBean<Product>();
		int totalCount = pDao.findTotalCount();
		pageBean.setPageSize(pageSize);
		pageBean.setTotalCount(totalCount);
		pageBean.setCurrPageNo(pageNo);
		List<Product> list = pDao.findProducts(pageNo, pageSize);
		pageBean.setPageList(list);
		return pageBean;
	}

	@Override
	public int addProduct(Product product) {
		return pDao.addProduct(product);
	}

	@Override
	public Product findById(int epId) {
		return pDao.findById(epId);
	}

	@Override
	public int updateProduct(Product product) {
		return pDao.updateProduct(product);
	}

	@Override
	public int deleProduct(int epId) {
		return pDao.deleProduct(epId);
	}

	@Override
	public List<Product> findByIds(String ids) {
		List<Product> list = new ArrayList<Product>();
		if (!(ids == null || ids.equals(""))) {
			String[] arr = ids.split(",");
			for (String id : arr) {
				Product p = pDao.findById(Integer.parseInt(id));
				list.add(p);
			}
		}
		return list;
	}

	@Override
	public PageBean<Product> findByPage(int pageNo, int pageSize, int epcId) {
		PageBean<Product> pageBean = new PageBean<Product>();
		int totalCount = pDao.findTotalCount(epcId);
		pageBean.setPageSize(pageSize);
		pageBean.setTotalCount(totalCount);
		pageBean.setCurrPageNo(pageNo);
		List<Product> list = pDao.findProducts(pageNo, pageSize,epcId);
		pageBean.setPageList(list);
		return pageBean;
	}

}
