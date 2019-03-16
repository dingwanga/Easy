package cn.bdqn.dao;

import java.util.List;

import cn.bdqn.entity.OrderDetail;

public interface OrderDetailDao {

	//根据订单号查询订单详细信息
	List<OrderDetail> findByEoId(String eoId);
	//更新订单详细表
	int updateDetail(OrderDetail detail);
}
