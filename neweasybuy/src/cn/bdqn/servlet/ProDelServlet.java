package cn.bdqn.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.bdqn.service.ProductService;
import cn.bdqn.service.impl.ProductServiceImpl;

public class ProDelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductService pService = new ProductServiceImpl();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		int epId=Integer.parseInt(request.getParameter("epId"));
		int result=pService.deleProduct(epId);
		if (result > 0) {
			out.print("true");
		} else {
			out.print("false");
		}
		out.flush();
		out.close();
		out.flush();
		out.close();
	}

}
