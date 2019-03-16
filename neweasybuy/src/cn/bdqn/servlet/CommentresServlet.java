package cn.bdqn.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import cn.bdqn.entity.Comment;
import cn.bdqn.service.CommentService;
import cn.bdqn.service.impl.CommentServiceImpl;

public class CommentresServlet extends HttpServlet {

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
		int ecId = Integer.parseInt(request.getParameter("id"));
		Comment comment = cService.findCommentById(ecId);
		String ecReply = request.getParameter("replyContent");
		java.sql.Timestamp rDate = new java.sql.Timestamp(
				System.currentTimeMillis());
		comment.setEcReply(ecReply);
		comment.setEcReplyTime(rDate);
		int result = cService.updateComment(comment);
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
