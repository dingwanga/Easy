package cn.bdqn.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.bdqn.dao.BaseDao;
import cn.bdqn.dao.OrderDao;
import cn.bdqn.entity.Order;
import cn.bdqn.entity.OrderParams;

public class OrderDaoImpl extends BaseDao implements OrderDao {

	@Override
	public List<Order> findByParams(int pageNo, int pageSize, OrderParams op) {
		List<Order> list = new ArrayList<Order>();
		StringBuffer sql = new StringBuffer(
				"SELECT * FROM `easybuy_order` WHERE 1=1");
		// 模糊查询，当用户填写了订单id
		if (!(op.getEoId() == null || op.getEoId().equals(""))) {
			// sql语句的拼接，注意前面一定要加空格号不然sql语句会报错
			sql.append(" AND EO_ID LIKE '%" + op.getEoId() + "%'");
		}
		// 用户填了订货人信息，不用问好是因为不清楚展位符的个数，影响后面使用
		if (!(op.getEoUserId() == null || op.getEoUserId().equals(""))) {
			// sql语句的拼接，注意前面一定要加空格号
			sql.append(" AND EO_USER_ID LIKE '%" + op.getEoUserId() + "%'");
		}
		sql.append(" ORDER BY `EO_CREATE_TIME` LIMIT ?,?");
		conn = this.getConnection();
		try {
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, (pageNo - 1) * pageSize);
			pstmt.setInt(2, pageSize);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Order order = new Order();
				order.setEoId(rs.getString(1));
				order.setEoUserId(rs.getString(2));
				order.setEoUserAddress(rs.getString(3));
				order.setEoCreateTTime(rs.getTimestamp(4));
				order.setEoStatus(rs.getInt(5));
				order.setEoIsdelete(rs.getInt(6));
				list.add(order);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeAll(conn, pstmt, rs);
		}
		return list;
	}

	@Override
	public int findCount(OrderParams op) {
		StringBuffer sql = new StringBuffer(
				"SELECT COUNT(1) FROM easybuy_order WHERE 1=1");
		// 模糊查询，当用户填写了订单id
		if (!(op.getEoId() == null || op.getEoId().equals(""))) {
			// sql语句的拼接，注意前面一定要加空格号不然sql语句会报错
			sql.append(" AND EO_ID LIKE '%" + op.getEoId() + "%'");
		}
		// 用户填了订货人信息，不用问好是因为不清楚展位符的个数，影响后面使用
		if (!(op.getEoUserId() == null || op.getEoUserId().equals(""))) {
			// sql语句的拼接，注意前面一定要加空格号
			sql.append(" AND EO_ID LIKE '%" + op.getEoUserId() + "%'");
		}
		int result = 0;
		conn = this.getConnection();
		try {
			pstmt = conn.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
			if (rs.next()) {
				result = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeAll(conn, pstmt, rs);
		}
		return result;
	}

	@Override
	public int updateOrder(Order order) {
		String sql = "INSERT INTO easybuy_order " +
				"(EO_ID,EO_USER_ID,EO_USER_ADDRESS," +
				"EO_CREATE_TIME,EO_STATUS,EO_ISDELETE)VALUES (?,?,?,?,1,0)";
		int result = this.executeUpdate(sql, order.getEoId(),
				order.getEoUserId(), order.getEoUserAddress(),
				order.getEoCreateTTime());
		return result;
	}

	@Override
	public Order findOrderById(String eoId) {
		String sql="SELECT * FROM easybuy_order WHERE EO_ID=?";
		conn=this.getConnection();
		Order order=new Order();
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, eoId);
			rs=pstmt.executeQuery();
			if(rs.next()){
				order.setEoId(rs.getString(1));
				order.setEoUserId(rs.getString(2));
				order.setEoUserAddress(rs.getString(3));
				order.setEoCreateTTime(rs.getTimestamp(4));
				order.setEoStatus(rs.getInt(5));
				order.setEoIsdelete(rs.getInt(6));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			closeAll(conn, pstmt, rs);
		}
		return order;
	}

	@Override
	public int modifyOrder(Order order) {
		String sql="UPDATE easybuy_order SET EO_USER_ID=?," +
				"EO_USER_ADDRESS=?,EO_CREATE_TIME=?,EO_STATUS=?," +
				"EO_ISDELETE=? WHERE EO_ID=?";
		int result=this.executeUpdate(sql, order.getEoUserId(),order.getEoUserAddress(),
				order.getEoCreateTTime(),order.getEoStatus(),
				order.getEoIsdelete(),order.getEoId());
		return result;
	}

}
