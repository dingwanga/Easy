package cn.bdqn.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.bdqn.entity.Comment;
import cn.bdqn.service.CommentService;
import cn.bdqn.service.impl.CommentServiceImpl;

public class CommentModifyServlet extends HttpServlet {

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
		int ecId=Integer.parseInt(request.getParameter("id"));
		Comment comment=cService.findCommentById(ecId);
		request.setAttribute("comment", comment);
		request.getRequestDispatcher("guestbook-modify.jsp")
		.forward(request, response);
	
	}

}
