package cn.bdqn.service.impl;

import cn.bdqn.dao.OrderDetailDao;
import cn.bdqn.dao.impl.OrderDetailDaoImpl;
import cn.bdqn.entity.OrderDetail;
import cn.bdqn.service.OrderDetailService;

public class OrderDetailServiceImpl implements OrderDetailService {
	private OrderDetailDao odDao=new OrderDetailDaoImpl();
	@Override
	public int updateDetail(OrderDetail detail) {
		return odDao.updateDetail(detail);
	}

}
