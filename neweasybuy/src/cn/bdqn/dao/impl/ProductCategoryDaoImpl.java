package cn.bdqn.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.bdqn.dao.BaseDao;
import cn.bdqn.dao.ProductCategoryDao;
import cn.bdqn.entity.ProductCategory;

public class ProductCategoryDaoImpl extends BaseDao implements
		ProductCategoryDao {

	@Override
	public List<ProductCategory> findProductCategorys(int pageNo, int pageSize) {
		List<ProductCategory> pList = new ArrayList<ProductCategory>();
		conn = this.getConnection();
		String sql = "SELECT * FROM `easybuy_product_category` WHERE `EPC_ID`=`EPC_PARENT_ID` LIMIT ?,?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, (pageNo - 1) * pageSize);
			pstmt.setInt(2, pageSize);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				pList.add(new ProductCategory(rs.getInt("epc_id"), rs
						.getString("EPC_NAME"), rs.getInt("EPC_PARENT_ID")));
			}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			closeAll(conn, pstmt, rs);
		}
		return pList;
	}

	@Override
	public int categoryCounts() {
		int result = 0;
		conn = this.getConnection();
		String sql = "SELECT COUNT(`EPC_ID`) AS E FROM `easybuy_product_category` "
				+ "WHERE `EPC_ID`=`EPC_PARENT_ID`";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				result = rs.getInt("E");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeAll(conn, pstmt, rs);
		}
		return result;
	}

	@Override
	public List<ProductCategory> findChildCategorys(int epcParentId) {
		List<ProductCategory> pList = new ArrayList<ProductCategory>();
		conn = this.getConnection();
		String sql = "SELECT * FROM `easybuy_product_category` WHERE `EPC_ID`!=`EPC_PARENT_ID` "
				+ "AND `EPC_PARENT_ID`=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, epcParentId);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				pList.add(new ProductCategory(rs.getInt("epc_id"), rs
						.getString("EPC_NAME"), rs.getInt("EPC_PARENT_ID")));
			}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			closeAll(conn, pstmt, rs);
		}

		return pList;
	}

	@Override
	public List<ProductCategory> findProductCategorys() {
		List<ProductCategory> pList = new ArrayList<ProductCategory>();
		conn = this.getConnection();
		String sql = "SELECT * FROM `easybuy_product_category` WHERE `EPC_ID`=`EPC_PARENT_ID`";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				pList.add(new ProductCategory(rs.getInt("epc_id"), rs
						.getString("EPC_NAME"), rs.getInt("EPC_PARENT_ID")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pList;
	}

	@Override
	public ProductCategory findCategory(int epcId) {
		ProductCategory pCategory = null;
		conn = this.getConnection();
		String sql = "SELECT * FROM `easybuy_product_category` WHERE `EPC_ID`=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, epcId);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				pCategory = new ProductCategory(rs.getInt("epc_id"),
						rs.getString("EPC_NAME"), rs.getInt("EPC_PARENT_ID"));
			}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			closeAll(conn, pstmt, rs);
		}

		return pCategory;
	}

	@Override
	public int addCategory(ProductCategory pCategory) {
		String sql = "INSERT INTO easybuy_product_category(EPC_NAME,EPC_PARENT_ID) "
				+ "VALUES(?,?)";
		int result = this.executeUpdate(sql, pCategory.getEpcName(),
				pCategory.getEpcParentId());
		return result;
	}

	@Override
	public int updateCategory(ProductCategory pCategory) {
		String sql = "UPDATE easybuy_product_category SET EPC_NAME=?,"
				+ "EPC_PARENT_ID=? WHERE EPC_ID=?";
		int result = this.executeUpdate(sql, pCategory.getEpcName(),
				pCategory.getEpcParentId(), pCategory.getEpcId());
		return result;
	}

	@Override
	public int deleteBypId(int epcId) {
		String sql="DELETE FROM easybuy_product_category WHERE EPC_PARENT_ID=?";
		int result=this.executeUpdate(sql, epcId);
		return result;
	}

	@Override
	public int deleteCategory(int epcId) {
		String sql="DELETE FROM easybuy_product_category WHERE EPC_ID=?";
		int result=this.executeUpdate(sql, epcId);
		return result;
	}

}
