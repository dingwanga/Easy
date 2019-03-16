package cn.bdqn.dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class BaseDao {
	
	private static String CLASSNAME;
	private static String URL;
	private static String USERNAME;
	private static String PASSWORD;
	protected Connection conn;
	protected PreparedStatement pstmt;
	protected ResultSet rs;
	static{
		Properties params=new Properties();
		try {
			//使用的是反射机制获得项目的路径
			InputStream is=BaseDao.class.getClassLoader().getResourceAsStream("database.properties");
			params.load(is);
			CLASSNAME=params.getProperty("driver");
			URL=params.getProperty("url");
			USERNAME=params.getProperty("user");
			PASSWORD=params.getProperty("password");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 获取数据库连接对象
	 * @return
	 */
	public Connection getConnection(){
		try {
			Class.forName(CLASSNAME);
			conn=DriverManager.getConnection(URL,USERNAME,PASSWORD);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	/**
	 * 关闭数据库连接
	 * @param con
	 * @param ps
	 * @param rs
	 */
	public void closeAll(Connection con,Statement ps,ResultSet rs){
		if(rs!=null){
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(ps!=null){
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(con!=null){
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	/**
	 * 增，删，改的操作
	 * @param sql
	 * @param param
	 * @return
	 */
	public int executeUpdate(String sql,Object...param){
		PreparedStatement ps=null;
		int result=0;
		conn=this.getConnection();
		try {
			ps=conn.prepareStatement(sql);
			if(param!=null){
				for(int i=0;i<param.length;i++){
					ps.setObject(i+1, param[i]);
				}
			}
			result=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			this.closeAll(conn, ps, null);
		}
		return result;
	}
	// 通用的查询方法
		public ResultSet executeQuery(String sql, Object... prams) {
			conn = this.getConnection();
			try {
				pstmt = conn.prepareStatement(sql);
				if (prams != null) {
					for (int i = 0; i < prams.length; i++) {
						pstmt.setObject(i + 1, prams[i]);
					}
				}
				rs = pstmt.executeQuery();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return rs;
		}
}
