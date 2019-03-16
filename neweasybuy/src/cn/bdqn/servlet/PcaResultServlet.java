package cn.bdqn.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.bdqn.entity.ProductCategory;
import cn.bdqn.service.ProductCategoryService;
import cn.bdqn.service.impl.ProductCategoryServiceImpl;

public class PcaResultServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private ProductCategoryService pService = new ProductCategoryServiceImpl();

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		int epcId = Integer.parseInt(request.getParameter("id"));
		ProductCategory pc = pService.findCategory(epcId);
		String epcName = request.getParameter("className");
		pc.setEpcName(epcName);
		int result = pService.updateCategory(pc);
		if (result > 0) {
			request.setAttribute("msg", "true");
			request.getRequestDispatcher("manage-result.jsp").forward(request,
					response);
		} else {
			request.setAttribute("msg", "false");
			request.getRequestDispatcher("manage-result.jsp").forward(request,
					response);
		}
	}

}
