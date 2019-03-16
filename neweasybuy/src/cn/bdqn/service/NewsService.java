package cn.bdqn.service;

import java.util.List;

import cn.bdqn.entity.News;
import cn.bdqn.util.PageBean;

public interface NewsService {

	List<News> findAllNews();

	News findById(int enId);

	PageBean<News> findByPage(int pageNo, int pageSize);

	int addNews(News news);

	int deleteNews(int enId);

	int modifyNews(News news);
}
