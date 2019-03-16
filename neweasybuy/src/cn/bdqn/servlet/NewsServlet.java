package cn.bdqn.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.bdqn.entity.News;
import cn.bdqn.service.NewsService;
import cn.bdqn.service.impl.NewsServiceImpl;
import cn.bdqn.util.PageBean;

public class NewsServlet extends HttpServlet {
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
		String pNo=request.getParameter("pageNo");
		int pageNo=1;
		int pageSize=3;
		if(pNo!=null){
			pageNo=Integer.parseInt(pNo);
		}
		PageBean<News> pageNews=nService.findByPage(pageNo, pageSize);
		request.setAttribute("pageNews", pageNews);
		request.getRequestDispatcher("news.jsp").forward(request, response);
		
	}

}
