package cn.bdqn.service;

import java.util.List;

import cn.bdqn.entity.Order;
import cn.bdqn.entity.OrderDTO;
import cn.bdqn.entity.OrderParams;
import cn.bdqn.util.PageBean;

public interface OrderService {
	
	//多表联合查询订单详细信息
	List<OrderDTO> findBypage(int pageNo,int pageSize,OrderParams op);
	PageBean<Order> findparams(int pageNo, int pageSize, OrderParams op);
	int updateOrder(Order order);
	Order findOrderById(String eoId);
	int modifyOrder(Order order);
}
