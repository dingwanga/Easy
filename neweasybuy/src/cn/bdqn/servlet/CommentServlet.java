package cn.bdqn.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.bdqn.entity.Comment;
import cn.bdqn.service.CommentService;
import cn.bdqn.service.impl.CommentServiceImpl;
import cn.bdqn.util.PageBean;

public class CommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CommentService cService = new CommentServiceImpl();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		String pNo = request.getParameter("pageNo");
		int pageNo = 1;
		int pageSize = 2;
		if (pNo != null) {
			pageNo = Integer.parseInt(pNo);
		}
		PageBean<Comment> pageComment = cService.findByPage(pageNo, pageSize);
		request.setAttribute("pageComment", pageComment);
		request.getRequestDispatcher("guestbook.jsp")
				.forward(request, response);
	}

}
