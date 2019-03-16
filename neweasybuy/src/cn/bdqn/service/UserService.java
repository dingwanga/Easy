package cn.bdqn.service;

import cn.bdqn.entity.User;
import cn.bdqn.util.PageBean;

public interface UserService {

	PageBean<User> findByPage(int pageNo, int pageSize);

	int modifyUser(User user);

	User findById(String euId);
	
	int delUser	(String euId);
	
	int addUser(User user);
}
