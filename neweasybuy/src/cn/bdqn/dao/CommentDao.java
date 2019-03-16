package cn.bdqn.dao;

import java.util.List;

import cn.bdqn.entity.Comment;

public interface CommentDao {

	//分页查询留言信息
	List<Comment> findByPage(int pageNo,int pageSize);
	//查询总得留言数目
	int totalCount();
	//更新留言信息
	int updateComment(Comment comment);
	//根据id查询留言信息
	Comment findCommentById(int ecId);
	//根据id删除留言信息
	int delComment(int ecId);
	//增加留言内容
	int addComment(Comment comment);
	
}
