package cn.bdqn.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.bdqn.entity.News;
import cn.bdqn.service.NewsService;
import cn.bdqn.service.impl.NewsServiceImpl;

public class NewsmodifyServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private NewsService nService=new NewsServiceImpl();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);	
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		int enId=Integer.parseInt(request.getParameter("id"));
		News news=nService.findById(enId);
		request.setAttribute("news", news);
		request.getRequestDispatcher("news-modify.jsp").forward(request, response);
	}

}
