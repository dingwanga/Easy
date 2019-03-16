package cn.bdqn.dao;

import java.util.List;

import cn.bdqn.entity.News;

public interface NewsDao {
	//查询所有新闻信息
	List<News> findAllNews();
	//根据id查询新闻
	News findById(int enId);
	//分页查询新闻信息
	List<News> findByPage(int pageNo,int pageSize);
	//查询新闻总记录数
	int findTotalCount();
	//增加新闻信息
	int addNews(News news);
	//根据id删除新闻
	int deleteNews(int enId);
	//修改新闻信息
	int modifyNews(News news);
}
