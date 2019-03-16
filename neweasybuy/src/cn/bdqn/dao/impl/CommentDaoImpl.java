package cn.bdqn.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.bdqn.dao.BaseDao;
import cn.bdqn.dao.CommentDao;
import cn.bdqn.entity.Comment;

public class CommentDaoImpl extends BaseDao implements CommentDao {

	@Override
	public List<Comment> findByPage(int pageNo, int pageSize) {
		List<Comment> list = new ArrayList<Comment>();
		Comment comment = null;
		conn = this.getConnection();
		String sql = "SELECT * FROM `easybuy_comment` LIMIT ?,?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, (pageNo - 1) * pageSize);
			pstmt.setInt(2, pageSize);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				comment = new Comment(rs.getInt("EC_ID"),
						rs.getString("EC_CONTENT"),
						rs.getTimestamp("EC_CREATE_TIME"),
						rs.getString("EC_REPLY"),
						rs.getTimestamp("EC_REPLY_TIME"),
						rs.getString("EC_NICK_NAME"));
				list.add(comment);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeAll(conn, pstmt, rs);
		}
		return list;
	}

	@Override
	public int totalCount() {
		int result = 0;
		conn = this.getConnection();
		String sql = "SELECT COUNT(EC_ID) AS C FROM easybuy_comment ";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				result = rs.getInt("C");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeAll(conn, pstmt, rs);
		}
		return result;
	}

	@Override
	public int updateComment(Comment comment) {
		int result = 0;
		String sql = "UPDATE easybuy_comment SET EC_CONTENT=?,EC_CREATE_TIME=?"
				+ ",EC_REPLY=?,EC_REPLY_TIME=?,EC_NICK_NAME=? WHERE EC_ID=?";
		result = this.executeUpdate(sql, comment.getEcContent(),
				comment.getEcCreateTime(), comment.getEcReply(),
				comment.getEcReplyTime(), comment.getEcNickName(),
				comment.getEcId());
		return result;
	}

	@Override
	public Comment findCommentById(int ecId) {
		Comment comment = null;
		conn = this.getConnection();
		String sql = "SELECT * FROM easybuy_comment WHERE EC_ID=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, ecId);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				comment = new Comment(rs.getInt("EC_ID"),
						rs.getString("EC_CONTENT"),
						rs.getTimestamp("EC_CREATE_TIME"),
						rs.getString("EC_REPLY"),
						rs.getTimestamp("EC_REPLY_TIME"),
						rs.getString("EC_NICK_NAME"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeAll(conn, pstmt, rs);
		}

		return comment;
	}

	@Override
	public int delComment(int ecId) {
		String sql = "DELETE FROM easybuy_comment WHERE EC_ID = ?";
		int result = super.executeUpdate(sql, ecId);
		return result;
	}

	@Override
	public int addComment(Comment comment) {
		String sql = "INSERT INTO easybuy_comment(EC_CONTENT,"
				+ "EC_CREATE_TIME,EC_REPLY,EC_REPLY_TIME,EC_NICK_NAME) "
				+ "VALUES(?,?,?,?,?)";
		int result = this.executeUpdate(sql, comment.getEcContent(),
				comment.getEcCreateTime(), comment.getEcReply(),
				comment.getEcReplyTime(), comment.getEcNickName());
		return result;
	}

}
