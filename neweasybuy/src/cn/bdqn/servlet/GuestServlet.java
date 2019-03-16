package cn.bdqn.servlet;

import java.io.IOException;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.bdqn.entity.Comment;
import cn.bdqn.service.CommentService;
import cn.bdqn.service.impl.CommentServiceImpl;

public class GuestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CommentService cService = new CommentServiceImpl();

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Comment comment = new Comment();
		String guestName = request.getParameter("guestName");
		System.out.println("<<<<<<<<"+guestName);
		String guestContent = request.getParameter("guestContent");
		comment.setEcContent("鞋子还有多长时间送到?");
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		comment.setEcCreateTime(timestamp);
		comment.setEcReply(guestContent);
		comment.setEcReplyTime(timestamp);
		comment.setEcNickName(guestName);
		int result = cService.addComment(comment);
		if (result > 0) {
			request.setAttribute("msg", "true");
			request.getRequestDispatcher("shopping-result.jsp").forward(
					request, response);
		} else {
			request.setAttribute("msg", "false");
			request.getRequestDispatcher("shopping-result.jsp").forward(
					request, response);
		}
	}

}
