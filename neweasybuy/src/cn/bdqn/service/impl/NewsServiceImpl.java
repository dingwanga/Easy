package cn.bdqn.service.impl;

import java.util.List;

import cn.bdqn.dao.NewsDao;
import cn.bdqn.dao.impl.NewsDaoImpl;
import cn.bdqn.entity.News;
import cn.bdqn.service.NewsService;
import cn.bdqn.util.PageBean;

public class NewsServiceImpl implements NewsService{

	private NewsDao nDao=new NewsDaoImpl();

	@Override
	public List<News> findAllNews() {
		
		return nDao.findAllNews();
	}

	@Override
	public News findById(int enId) {
		return nDao.findById(enId);
	}

	@Override
	public PageBean<News> findByPage(int pageNo, int pageSize) {
		PageBean<News> pageBean=new PageBean<News>();
		pageBean.setPageSize(pageSize);
		pageBean.setTotalCount(nDao.findTotalCount());
		pageBean.setCurrPageNo(pageNo);
		List<News> list=nDao.findByPage(pageNo, pageSize);
		pageBean.setPageList(list);
		return pageBean;
	}

	@Override
	public int addNews(News news) {
		// TODO Auto-generated method stub
		return nDao.addNews(news);
	}

	@Override
	public int deleteNews(int enId) {
		// TODO Auto-generated method stub
		return nDao.deleteNews(enId);
	}

	@Override
	public int modifyNews(News news) {
		// TODO Auto-generated method stub
		return nDao.modifyNews(news);
	}
	
	
}
