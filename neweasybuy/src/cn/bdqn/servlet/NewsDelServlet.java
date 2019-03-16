package cn.bdqn.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.bdqn.service.NewsService;
import cn.bdqn.service.impl.NewsServiceImpl;

public class NewsDelServlet extends HttpServlet {
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
		PrintWriter out = response.getWriter();
		int enId=Integer.parseInt(request.getParameter("enId"));
		int result=nService.deleteNews(enId);
		if (result > 0) {
			out.print("true");
			out.flush();
			out.close();
		} else {
			out.print("false");
			out.flush();
			out.close();
		}
	}

}
