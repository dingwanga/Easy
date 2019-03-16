package cn.bdqn.servlet;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.bdqn.entity.ProductCategory;
import cn.bdqn.service.ProductCategoryService;
import cn.bdqn.service.impl.ProductCategoryServiceImpl;

public class ProductAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductCategoryService pService=new ProductCategoryServiceImpl();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		Map<ProductCategory, List<ProductCategory>> pMap=pService.findAllCategory();
		request.setAttribute("pMap",pMap);
		request.getRequestDispatcher("product-add.jsp").forward(request, response);
	}

}
