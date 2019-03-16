package cn.bdqn.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.bdqn.dao.BaseDao;
import cn.bdqn.dao.ProductDao;
import cn.bdqn.entity.Product;

public class ProductDaoImpl extends BaseDao implements ProductDao {
	@Override
	public List<Product> findProducts(int pageNo, int pageSize) {
		List<Product> list = new ArrayList<Product>();
		Product product = null;
		conn = this.getConnection();
		String sql = "SELECT * FROM `easybuy_product` ORDER BY `EP_NAME` LIMIT ?,?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, (pageNo - 1) * pageSize);
			pstmt.setInt(2, pageSize);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				int epId = rs.getInt("EP_ID");
				String epName = rs.getString("EP_NAME");
				String epDescription = rs.getString("EP_DESCRIPTION");
				double epPrice = rs.getDouble("EP_PRICE");
				int epStock = rs.getInt("EP_STOCK");
				int epcId = rs.getInt("EPC_ID");
				int epcChildId = rs.getInt("EPC_CHILD_ID");
				String epFileName = rs.getString("EP_FILE_NAME");
				product = new Product(epId, epName, epDescription, epPrice,
						epStock, epcId, epcChildId, epFileName);
				list.add(product);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			closeAll(conn, pstmt, rs);
		}
		return list;
	}

	@Override
	public int findTotalCount() {
		int count = 0;
		conn = this.getConnection();
		String sql = "SELECT COUNT(`EP_ID`) AS E FROM `easybuy_product`";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				count = rs.getInt("E");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeAll(conn, pstmt, rs);
		}
		return count;
	}

	@Override
	public int addProduct(Product product) {
		String sql = "INSERT INTO easybuy_product(`EP_ID`,`EP_NAME`,`EP_DESCRIPTION`"
				+ ",`EP_PRICE`,`EP_STOCK`,`EPC_ID`,`EPC_CHILD_ID`,`EP_FILE_NAME`) VALUES (?,?,?,?,?,?,?,?)";
		Object[] param = { product.getEpId(), product.getEpName(),
				product.getEpDescription(), product.getEpPrice(),
				product.getEpStock(), product.getEpcId(),
				product.getEpcChildId(), product.getEpFileName() };
		int result = this.executeUpdate(sql, param);
		return result;
	}

	@Override
	public Product findById(int epId) {
		Product product = null;
		conn = this.getConnection();
		String sql = "SELECT * FROM `easybuy_product` WHERE `EP_ID`=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, epId);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				epId = rs.getInt("EP_ID");
				String epName = rs.getString("EP_NAME");
				String epDescription = rs.getString("EP_DESCRIPTION");
				double epPrice = rs.getDouble("EP_PRICE");
				int epStock = rs.getInt("EP_STOCK");
				int epcId = rs.getInt("EPC_ID");
				int epcChildId = rs.getInt("EPC_CHILD_ID");
				String epFileName = rs.getString("EP_FILE_NAME");
				product = new Product(epId, epName, epDescription, epPrice,
						epStock, epcId, epcChildId, epFileName);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeAll(conn, pstmt, rs);
		}
		return product;
	}

	@Override
	public int updateProduct(Product product) {
		String sql = "UPDATE easybuy_product SET `EP_NAME`=?,EP_DESCRIPTION=?,"
				+ "EP_PRICE=?,EP_STOCK=?,EPC_ID=?,EPC_CHILD_ID=?,EP_FILE_NAME=? WHERE EP_ID=?";
		Object[] param = { product.getEpName(), product.getEpDescription(),
				product.getEpPrice(), product.getEpStock(), product.getEpcId(),
				product.getEpcChildId(), product.getEpFileName(),
				product.getEpId() };
		int result = this.executeUpdate(sql, param);
		return result;
	}

	@Override
	public int deleProduct(int epId) {
		String sql="DELETE FROM easybuy_product WHERE EP_ID = ?";
		int result=this.executeUpdate(sql, epId);
		return result;
	}

	@Override
	public int updateEpcId(int epcId) {
		String sql="UPDATE easybuy_product SET EPC_ID =1 WHERE EPC_ID=?";
		int result=this.executeUpdate(sql, epcId);
		return result;
	}

	@Override
	public List<Product> findProducts(int pageNo, int pageSize, int id) {
		List<Product> list = new ArrayList<Product>();
		Product product = null;
		conn = this.getConnection();
		String sql = "SELECT * FROM easybuy_product WHERE EPC_ID=? ORDER BY EP_NAME  LIMIT ?,?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			pstmt.setInt(2, (pageNo - 1) * pageSize);
			pstmt.setInt(3, pageSize);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				int epId = rs.getInt("EP_ID");
				String epName = rs.getString("EP_NAME");
				String epDescription = rs.getString("EP_DESCRIPTION");
				double epPrice = rs.getDouble("EP_PRICE");
				int epStock = rs.getInt("EP_STOCK");
				int epcId = rs.getInt("EPC_ID");
				int epcChildId = rs.getInt("EPC_CHILD_ID");
				String epFileName = rs.getString("EP_FILE_NAME");
				product = new Product(epId, epName, epDescription, epPrice,
						epStock, epcId, epcChildId, epFileName);
				list.add(product);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			closeAll(conn, pstmt, rs);
		}
		return list;

	}

	@Override
	public int findTotalCount(int epcId) {
		int count = 0;
		conn = this.getConnection();
		String sql = "SELECT COUNT(EP_ID) AS E FROM easybuy_product WHERE EPC_ID=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, epcId);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				count = rs.getInt("E");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeAll(conn, pstmt, rs);
		}
		return count;
	}

}
