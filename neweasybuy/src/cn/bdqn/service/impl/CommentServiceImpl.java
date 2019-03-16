package cn.bdqn.service.impl;

import java.util.List;

import cn.bdqn.dao.CommentDao;
import cn.bdqn.dao.impl.CommentDaoImpl;
import cn.bdqn.entity.Comment;
import cn.bdqn.service.CommentService;
import cn.bdqn.util.PageBean;

public class CommentServiceImpl implements CommentService {
	private CommentDao cDao = new CommentDaoImpl();

	@Override
	public PageBean<Comment> findByPage(int pageNo, int pageSize) {
		PageBean<Comment> pageBean = new PageBean<Comment>();
		pageBean.setPageSize(pageSize);
		int totalCount = cDao.totalCount();
		pageBean.setTotalCount(totalCount);
		pageBean.setCurrPageNo(pageNo);
		List<Comment> list = cDao.findByPage(pageNo, pageSize);
		pageBean.setPageList(list);
		return pageBean;
	}

	@Override
	public int updateComment(Comment comment) {
		return cDao.updateComment(comment);
	}

	@Override
	public Comment findCommentById(int ecId) {

		return cDao.findCommentById(ecId);
	}

	@Override
	public int delComment(int ecId) {

		return cDao.delComment(ecId);
	}

	@Override
	public int addComment(Comment comment) {

		return cDao.addComment(comment);
	}

}
