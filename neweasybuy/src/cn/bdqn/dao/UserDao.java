package cn.bdqn.dao;

import java.util.List;

import cn.bdqn.entity.User;

public interface UserDao {
	//分页查询用户信息
	List<User> findUsers(int pageNo,int pageSize);	
	//查询总得用户记录
	int findTotalCount();
	//修改用户信息
	int modifyUser(User user);
	//根据id查询用户信息
	User findById(String euId);
	//根据id删除用户信息
	int delUser	(String euId);
	//增加用户信息
	int addUser(User user);
}
