package cn.bdqn.entity;

import java.io.Serializable;
import java.util.List;

public class OrderDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private Order order;
	private List<OrderDetail> details;

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public List<OrderDetail> getDetails() {
		return details;
	}

	public void setDetails(List<OrderDetail> details) {
		this.details = details;
	}

	public OrderDTO() {
		super();
	}

	public OrderDTO(Order order, List<OrderDetail> details) {
		super();
		this.order = order;
		this.details = details;
	}

}
