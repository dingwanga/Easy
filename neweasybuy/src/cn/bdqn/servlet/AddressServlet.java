package cn.bdqn.servlet;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.bdqn.entity.CartLine;
import cn.bdqn.entity.Order;
import cn.bdqn.entity.OrderDetail;
import cn.bdqn.entity.Product;
import cn.bdqn.entity.ShopCart;
import cn.bdqn.entity.User;
import cn.bdqn.service.OrderDetailService;
import cn.bdqn.service.OrderService;
import cn.bdqn.service.ProductService;
import cn.bdqn.service.impl.OrderDetailServiceImpl;
import cn.bdqn.service.impl.OrderServiceImpl;
import cn.bdqn.service.impl.ProductServiceImpl;

public class AddressServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductService pService = new ProductServiceImpl();
	private OrderService oService = new OrderServiceImpl();
	private OrderDetailService odService = new OrderDetailServiceImpl();

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		ShopCart sc = (ShopCart) session.getAttribute("cart");
		User user = (User) session.getAttribute("user");
		String eoId = UUID.randomUUID().toString().replace("-", "");
		String address = request.getParameter("address");
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		boolean flag = true;
		List<CartLine> lines = sc.getLines();
		for (CartLine line : lines) {
			int epId = line.getProduct().getEpId();
			Product p = pService.findById(epId);
			if (p.getEpStock() < line.getCount()) {
				flag = false;
				break;
			}
		}

		if (flag) {
			Order order = new Order();
			// 设置订单号
			order.setEoId(eoId);
			// 设置用户名
			order.setEoUserId(user.getEuId());
			// 设置地址
			order.setEoUserAddress(address);
			// 设置创建时间
			order.setEoCreateTTime(timestamp);
			int result = oService.updateOrder(order);
			// 减少商品的库存
			for (CartLine line : lines) {
				int epId = line.getProduct().getEpId();
				Product p = pService.findById(epId);
				p.setEpStock(p.getEpStock() - line.getCount());
				pService.updateProduct(p);
				OrderDetail detail = new OrderDetail();
				detail.setEoId(eoId);
				detail.setEpId(epId);
				detail.setEodQuantity(line.getCount());
				odService.updateDetail(detail);
			}
			if (result > 0) {
				sc.clearCart();
				request.setAttribute("msg", "true");
				request.getRequestDispatcher("shopping-result.jsp").forward(
						request, response);
			} else {
				request.setAttribute("msg", "false");
				request.getRequestDispatcher("shopping-result.jsp").forward(
						request, response);
			}
		} else {
			request.setAttribute("msg", "false");
			request.setAttribute("ms", "商品库存不足,购买失败！");
			request.getRequestDispatcher("shopping-result.jsp").forward(
					request, response);
		}
	}
}
