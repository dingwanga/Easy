package cn.bdqn.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import cn.bdqn.dao.BaseDao;
import cn.bdqn.dao.OrderDetailDao;
import cn.bdqn.entity.OrderDetail;

public class OrderDetailDaoImpl extends BaseDao implements OrderDetailDao {

	@Override
	public List<OrderDetail> findByEoId(String eoId) {
		List<OrderDetail> list = new ArrayList<OrderDetail>();
		String sql = "SELECT d.EOD_ID,d.EOD_QUANTITY,p.EP_NAME,"
				+ "p.EP_PRICE,p.EP_FILE_NAME FROM easybuy_order_detail d "
				+ "INNER JOIN easybuy_product p ON (d.EP_ID=p.EP_ID) WHERE EO_ID=?";
		conn = this.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, eoId);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				OrderDetail oDetail = new OrderDetail();
				oDetail.setEodId(rs.getInt(1));
				oDetail.setEodQuantity(rs.getInt(2));
				oDetail.setName(rs.getString(3));
				oDetail.setPrice(rs.getDouble(4));
				oDetail.setPic(rs.getString(5));
				list.add(oDetail);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeAll(conn, pstmt, rs);
		}
		return list;
	}

	@Override
	public int updateDetail(OrderDetail detail) {
			String sql="INSERT INTO easybuy_order_detail " +
					"(EO_ID,EP_ID,EOD_QUANTITY,EOD_ISDELETE) " +
					"VALUES(?,?,?,0)";
			int result=this.executeUpdate(sql, detail.getEoId(),detail.getEpId(),detail.getEodQuantity());
		return result;
	}

}
