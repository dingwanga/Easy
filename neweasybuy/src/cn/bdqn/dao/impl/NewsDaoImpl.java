package cn.bdqn.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.bdqn.dao.BaseDao;
import cn.bdqn.dao.NewsDao;
import cn.bdqn.entity.News;

public class NewsDaoImpl extends BaseDao implements NewsDao {

	@Override
	public List<News> findAllNews() {
		List<News> li = new ArrayList<News>();
		News news = null;
		conn = this.getConnection();
		String sql = "SELECT * FROM easybuy_news";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				news = new News(rs.getInt("en_id"), rs.getString("en_title"),
						rs.getString("en_content"),
						rs.getTimestamp("en_create_time"));
				li.add(news);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeAll(conn, pstmt, rs);
		}
		return li;
	}

	@Override
	public News findById(int enId) {
		News news = null;
		conn = this.getConnection();
		String sql = "SELECT * FROM easybuy_news WHERE `en_id`=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, enId);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				news = new News(rs.getInt("en_id"), rs.getString("en_title"),
						rs.getString("en_content"),
						rs.getTimestamp("en_create_time"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeAll(conn, pstmt, rs);
		}
		return news;
	}

	@Override
	public List<News> findByPage(int pageNo, int pageSize) {
		List<News> li = new ArrayList<News>();
		News news = null;
		conn = this.getConnection();
		String sql = "SELECT * FROM `easybuy_news` LIMIT ?,?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, (pageNo - 1) * pageSize);
			pstmt.setInt(2, pageSize);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				news = new News(rs.getInt("en_id"), rs.getString("en_title"),
						rs.getString("en_content"),
						rs.getTimestamp("en_create_time"));
				li.add(news);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeAll(conn, pstmt, rs);
		}
		return li;
	}

	@Override
	public int findTotalCount() {
		int result = 0;
		conn = this.getConnection();
		String sql = "SELECT COUNT(`en_id`) AS N FROM `easybuy_news`";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				result = rs.getInt("N");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int addNews(News news) {
		String sql = "INSERT INTO `easybuy_news` "
				+ "(`en_title`,`en_content`,`en_create_time`) VALUES(?,?,?)";
		int result = this.executeUpdate(sql, news.getEnTitle(),
				news.getEnContent(), news.getEnCreateTime());
		return result;
	}

	@Override
	public int deleteNews(int enId) {
		String sql = "DELETE FROM easybuy_news WHERE en_id = ?";
		int result = this.executeUpdate(sql, enId);
		return result;
	}

	@Override
	public int modifyNews(News news) {
		String sql = "UPDATE easybuy_news SET en_title=?,en_content=?,en_create_time=? WHERE en_id=?";
		int result = this.executeUpdate(sql, news.getEnTitle(),
				news.getEnContent(), news.getEnCreateTime(), news.getEnId());
		return result;
	}

}
