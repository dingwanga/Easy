package cn.bdqn.service.impl;

import java.util.List;

import cn.bdqn.dao.UserDao;
import cn.bdqn.dao.impl.UserDaoImpl;
import cn.bdqn.entity.User;
import cn.bdqn.service.UserService;
import cn.bdqn.util.PageBean;

public class UserServiceImpl implements UserService {

	private UserDao uDao=new UserDaoImpl();
	@Override
	public PageBean<User> findByPage(int pageNo, int pageSize) {
		PageBean<User> pageBean=new PageBean<User>();
		pageBean.setPageSize(pageSize);
		int totalCount=uDao.findTotalCount();
		pageBean.setTotalCount(totalCount);
		pageBean.setCurrPageNo(pageNo);
		List<User> list=uDao.findUsers(pageNo, pageSize);
		pageBean.setPageList(list);
		return pageBean;
	}
	@Override
	public int modifyUser(User user) {	
		return uDao.modifyUser(user);
	}
	@Override
	public User findById(String euId) {
		return uDao.findById(euId);
	}
	@Override
	public int delUser(String euId) {
		return uDao.delUser(euId);
	}
	@Override
	public int addUser(User user) {
		// TODO Auto-generated method stub
		return uDao.addUser(user);
	}

}
