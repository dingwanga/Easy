package cn.bdqn.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.bdqn.entity.Product;
import cn.bdqn.service.ProductService;
import cn.bdqn.service.impl.ProductServiceImpl;
import cn.bdqn.util.PageBean;

public class ProductServlet extends HttpServlet {
	
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
		String pNo=request.getParameter("pageNo");
		int pageSize=3;
		int pageNo=1;
		if(pNo!=null){
			pageNo=Integer.parseInt(pNo);
		}
		PageBean<Product> pbProduct=pService.findByPage(pageNo, pageSize);
		request.setAttribute("pbProduct", pbProduct);
		request.getRequestDispatcher("product.jsp").forward(request, response);
	}

}
