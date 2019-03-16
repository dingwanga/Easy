package cn.bdqn.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;
import cn.bdqn.dao.BaseDao;
import cn.bdqn.dao.UserDao;
import cn.bdqn.entity.User;

public class UserDaoImpl extends BaseDao implements UserDao {

	@Override
	public List<User> findUsers(int pageNo, int pageSize) {
		List<User> list = new ArrayList<User>();
		User user = null;
		conn = this.getConnection();
		String sql = "SELECT * FROM `easybuy_user` LIMIT ?,?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, (pageNo - 1) * pageSize);
			pstmt.setInt(2, pageSize);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				String euId = rs.getString("eu_user_id");
				String name = rs.getString("EU_USER_NAME");
				String euPassword = rs.getString("EU_PASSWORD");
				String euSex = rs.getString("EU_SEX");
				Date euBirthday = rs.getDate("EU_BIRTHDAY");
				String euIdentity = rs.getString("EU_IDENTITY_CODE");
				String euEmail = rs.getString("EU_EMAIL");
				String euMobile = rs.getString("EU_MOBILE");
				String euAddress = rs.getString("EU_ADDRESS");
				int euStatus = rs.getInt("EU_STATUS");
				user = new User(euId, name, euPassword, euSex, euBirthday,
						euIdentity, euEmail, euMobile, euAddress, euStatus);
				list.add(user);
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
		int result = 0;
		conn = this.getConnection();
		String sql = "SELECT COUNT(`eu_user_id`) AS E FROM `easybuy_user`";
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
	public int modifyUser(User user) {
		int result = 0;
		String sql = "UPDATE  easybuy_user SET EU_USER_NAME = ?, EU_PASSWORD = ? , "
				+ "EU_SEX = ?, EU_BIRTHDAY = ? ,EU_MOBILE = ?,EU_ADDRESS= ?"
				+ "WHERE eu_user_id= ?";
		result = super.executeUpdate(sql, user.getEuName(),
				user.getEuPassword(), user.getEuSex(), user.getEuBirthday(),
				user.getEuMobile(), user.getEuAddress(), user.getEuId());
		return result;
	}

	@Override
	public User findById(String euId) {
		User user = null;
		conn = this.getConnection();
		String sql = "SELECT `eu_user_id`, `EU_USER_NAME`,EU_PASSWORD, EU_SEX, EU_BIRTHDAY ,EU_IDENTITY_CODE,"
				+ "EU_EMAIL , EU_MOBILE, EU_ADDRESS, EU_STATUS  FROM `easybuy_user` WHERE `eu_user_id`=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, euId);
			rs=pstmt.executeQuery();
			if (rs.next()) {
				String name = rs.getString("EU_USER_NAME");
				String euPassword = rs.getString("EU_PASSWORD");
				String euSex = rs.getString("EU_SEX");
				Date euBirthday = rs.getDate("EU_BIRTHDAY");
				String euIdentity = rs.getString("EU_IDENTITY_CODE");
				String euEmail = rs.getString("EU_EMAIL");
				String euMobile = rs.getString("EU_MOBILE");
				String euAddress = rs.getString("EU_ADDRESS");
				int euStatus = rs.getInt("EU_STATUS");
				user = new User(euId, name, euPassword, euSex, euBirthday,
						euIdentity, euEmail, euMobile, euAddress, euStatus);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public int delUser(String euId) {
		String sql="DELETE FROM easybuy_user WHERE eu_user_id = ?";
		int result=super.executeUpdate(sql, euId);
		return result;
	}

	@Override
	public int addUser(User user) {
		String sql = " INSERT into `easybuy_user`(`eu_user_id`, `EU_USER_NAME`,EU_PASSWORD, EU_SEX, EU_BIRTHDAY ,EU_IDENTITY_CODE,"
				+ "EU_EMAIL , EU_MOBILE, EU_ADDRESS,EU_STATUS) values(?,?,?,?,?,?,?,?,?,1) ";
		Object param[] = new Object[] { user.getEuId(),
				user.getEuName(), user.getEuPassword(),
				user.getEuSex(), user.getEuBirthday(),
				user.getEuIdentity(), user.getEuEmail(),
				user.getEuMobile(), user.getEuAddress() };
		int result=this.executeUpdate(sql, param);
		return result;
	}

}
