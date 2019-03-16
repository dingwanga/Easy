package cn.bdqn.dao;

import java.util.List;

import cn.bdqn.entity.Order;
import cn.bdqn.entity.OrderParams;

public interface OrderDao {
	//模糊分页查询
	List<Order> findByParams(int pageNo,int pageSize,OrderParams op);
	//模糊查询总记录数
	int findCount(OrderParams op);
	//更新订单信息
	int updateOrder(Order order);
	//根据id找订单
	Order findOrderById(String eoId);
	//修改订单信息
	int modifyOrder(Order order);
}
