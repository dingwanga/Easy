package cn.bdqn.service;

import cn.bdqn.entity.Comment;
import cn.bdqn.util.PageBean;

public interface CommentService {

	PageBean<Comment> findByPage(int pageNo, int pageSize);

	int updateComment(Comment comment);

	Comment findCommentById(int ecId);

	int delComment(int ecId);
	
	int addComment(Comment comment);
}
