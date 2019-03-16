package cn.bdqn.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.bdqn.entity.Order;
import cn.bdqn.entity.OrderDTO;
import cn.bdqn.entity.OrderParams;
import cn.bdqn.service.OrderService;
import cn.bdqn.service.impl.OrderServiceImpl;
import cn.bdqn.util.PageBean;

public class OrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private OrderService oService = new OrderServiceImpl();

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		String pNo=request.getParameter("pageNo");
		String eoId=request.getParameter("entityId");
		String eoUserId=request.getParameter("userName");
		OrderParams op = new OrderParams();
		op.setEoId(eoId);
		op.setEoUserId(eoUserId);
		int pageSize = 2;
		int pageNo = 1;
		if(pNo!=null){
			pageNo=Integer.parseInt(pNo);
		}
		PageBean<Order> pageOrder = oService.findparams(pageNo, pageSize, op);
		List<OrderDTO> orderDTOList = oService.findBypage(pageNo, pageSize, op);
		request.setAttribute("pageOrder", pageOrder);
		request.setAttribute("orderDTOList", orderDTOList);
		request.getRequestDispatcher("order.jsp").forward(request, response);
	}

}
