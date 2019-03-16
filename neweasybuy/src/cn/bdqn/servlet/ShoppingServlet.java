package cn.bdqn.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.bdqn.entity.CartLine;
import cn.bdqn.entity.Product;
import cn.bdqn.entity.ShopCart;
import cn.bdqn.service.ProductService;
import cn.bdqn.service.impl.ProductServiceImpl;

public class ShoppingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductService pService=new ProductServiceImpl();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		int epId=Integer.parseInt(request.getParameter("id"));
		Product product=pService.findById(epId);
		//创建商品条目标
		CartLine cl=new CartLine();
		cl.setProduct(product);
		HttpSession session=request.getSession();
		ShopCart sc=(ShopCart) session.getAttribute("cart");
		if(sc==null){
			sc=new ShopCart();
		}
		//将商品条目放入购物车
		sc.addCart(cl);
		session.setAttribute("cart", sc);
		response.sendRedirect("shopping.jsp");
	}

}
