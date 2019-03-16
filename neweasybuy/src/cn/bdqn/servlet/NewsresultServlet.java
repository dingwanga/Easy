package cn.bdqn.servlet;

import java.io.IOException;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.bdqn.entity.News;
import cn.bdqn.service.NewsService;
import cn.bdqn.service.impl.NewsServiceImpl;

public class NewsresultServlet extends HttpServlet {
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
		News news=new News();
		int enId=Integer.parseInt(request.getParameter("id"));
		String title=request.getParameter("title");
		String content=request.getParameter("content");
		Timestamp date=new Timestamp(System.currentTimeMillis());
		news.setEnId(enId);
		news.setEnTitle(title);
		news.setEnContent(content);
		news.setEnCreateTime(date);
		int result=nService.modifyNews(news);
		if(result>0){
			request.setAttribute("msg", "true");
			request.getRequestDispatcher("manage-result.jsp").forward(request, response);
		}else{
			request.setAttribute("msg", "false");
			request.getRequestDispatcher("manage-result.jsp").forward(request, response);
		}
	}

}
