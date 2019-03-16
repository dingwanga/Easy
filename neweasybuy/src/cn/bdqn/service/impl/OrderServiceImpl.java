package cn.bdqn.service.impl;

import java.util.ArrayList;
import java.util.List;
import cn.bdqn.dao.OrderDao;
import cn.bdqn.dao.OrderDetailDao;
import cn.bdqn.dao.impl.OrderDaoImpl;
import cn.bdqn.dao.impl.OrderDetailDaoImpl;
import cn.bdqn.entity.Order;
import cn.bdqn.entity.OrderDTO;
import cn.bdqn.entity.OrderDetail;
import cn.bdqn.entity.OrderParams;
import cn.bdqn.service.OrderService;
import cn.bdqn.util.PageBean;

public class OrderServiceImpl implements OrderService {

	private OrderDao oDao = new OrderDaoImpl();
	private OrderDetailDao odDao = new OrderDetailDaoImpl();

	@Override
	public List<OrderDTO> findBypage(int pageNo, int pageSize, OrderParams op) {
		List<OrderDTO> oList = new ArrayList<OrderDTO>();
		// 设置Order的分页设置
		List<Order> list = oDao.findByParams(pageNo, pageSize, op);
		for (Order order : list) {
			OrderDTO orderDTO = new OrderDTO();			
			List<OrderDetail> orderDetails = odDao.findByEoId(order.getEoId());
			double cost=0;
			for (OrderDetail oD : orderDetails) {
				cost+=oD.getTotal();
			}
			order.setEoCost(cost);
			orderDTO.setOrder(order);
			orderDTO.setDetails(orderDetails);
			oList.add(orderDTO);
		}
		return oList;
	}

	public PageBean<Order> findparams(int pageNo, int pageSize, OrderParams op) {
		// 设置Order的分页设置
		PageBean<Order> pageOrder = new PageBean<Order>();
		pageOrder.setPageSize(pageSize);
		int totalCount = oDao.findCount(op);
		pageOrder.setTotalCount(totalCount);
		pageOrder.setCurrPageNo(pageNo);
		List<Order> list = oDao.findByParams(pageNo, pageSize, op);
		pageOrder.setPageList(list);
		return pageOrder;
	}

	@Override
	public int updateOrder(Order order) {
		
		return oDao.updateOrder(order);
	}

	@Override
	public Order findOrderById(String eoId) {
		// TODO Auto-generated method stub
		return oDao.findOrderById(eoId);
	}

	@Override
	public int modifyOrder(Order order) {
		// TODO Auto-generated method stub
		return oDao.modifyOrder(order);
	}

}
