package cn.bdqn.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.bdqn.entity.Order;
import cn.bdqn.service.OrderService;
import cn.bdqn.service.impl.OrderServiceImpl;

public class ChangStatuServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private OrderService oService=new OrderServiceImpl();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		String eoId=request.getParameter("eoId");
		int statu=Integer.parseInt(request.getParameter("statu"));
		Order order=oService.findOrderById(eoId);
		Timestamp timestamp=new Timestamp(System.currentTimeMillis());
		order.setEoCreateTTime(timestamp);
		order.setEoStatus(statu);
		int result=oService.modifyOrder(order);
		if(result>0){
			out.write("true");
		}else{
			out.write("false");
		}
		out.close();
		out.flush();
	}

}
