package cn.bdqn.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.bdqn.entity.Product;
import cn.bdqn.entity.ProductCategory;
import cn.bdqn.service.ProductCategoryService;
import cn.bdqn.service.ProductService;
import cn.bdqn.service.impl.ProductCategoryServiceImpl;
import cn.bdqn.service.impl.ProductServiceImpl;
import cn.bdqn.util.PageBean;

public class ProductlistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductCategoryService pcService = new ProductCategoryServiceImpl();
	private ProductService pService = new ProductServiceImpl();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int epcId=Integer.parseInt(request.getParameter("id"));
		ProductCategory pc=pcService.findCategory(epcId);
		String pNo=request.getParameter("pageNo");
		int pageSize=4;
		int pageNo=1;
		if(pNo!=null){
			pageNo=Integer.parseInt(pNo);
		}
		PageBean<Product> pageBean=pService.findByPage(pageNo, pageSize,pc.getEpcParentId());
		request.setAttribute("pageBean",pageBean);
		request.getRequestDispatcher("product-list.jsp").forward(request, response);
	}
}
