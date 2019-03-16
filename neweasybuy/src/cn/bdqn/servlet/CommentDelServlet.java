package cn.bdqn.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.bdqn.service.CommentService;
import cn.bdqn.service.impl.CommentServiceImpl;

public class CommentDelServlet extends HttpServlet {
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
		int ecId = Integer.parseInt(request.getParameter("ecId"));
		int result = cService.delComment(ecId);
		PrintWriter out = response.getWriter();
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
