package cn.bdqn.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.bdqn.service.UserService;
import cn.bdqn.service.impl.UserServiceImpl;

public class UserDelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService uService = new UserServiceImpl();

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String euId = request.getParameter("euId");
		int result = uService.delUser(euId);
		if (result > 0) {
			out.print("true");
		} else {
			out.print("false");

		}
		out.flush();
		out.close();
	}

}
