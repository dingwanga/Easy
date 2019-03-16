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
import cn.bdqn.util.PageBean;

public class ProductClassServlet extends HttpServlet {
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
		String pNo=request.getParameter("pageNo");
		int pageSize=2;
		int pageNo=1;
		if(pNo!=null){
			pageNo=Integer.parseInt(pNo);
		}
		PageBean<ProductCategory> pCategory=pService.findByPage(pageNo, pageSize);
		Map<ProductCategory, List<ProductCategory>> mapPc=pService.findAllCategory(pageNo, pageSize);		
		request.setAttribute("pCategory", pCategory);
		request.setAttribute("mapPc", mapPc);
		request.getRequestDispatcher("productClass.jsp").forward(request, response);
	}

}
