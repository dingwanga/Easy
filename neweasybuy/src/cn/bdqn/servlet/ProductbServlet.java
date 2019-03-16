package cn.bdqn.servlet;

import java.io.IOException;
import java.util.List;
import java.util.Map;

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

public class ProductbServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private ProductCategoryService pcService=new ProductCategoryServiceImpl();
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
		Map<ProductCategory, List<ProductCategory>> pMap=pcService.findAllCategory();
		request.setAttribute("pMap",pMap);
		request.setAttribute("product", product);
		request.getRequestDispatcher("product-modify.jsp").forward(request, response);
	}

}
