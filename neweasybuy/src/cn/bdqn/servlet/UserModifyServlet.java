package cn.bdqn.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import cn.bdqn.entity.User;
import cn.bdqn.service.UserService;
import cn.bdqn.service.impl.UserServiceImpl;

public class UserModifyServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private UserService uService=new UserServiceImpl(); 
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			doPost(request, response);	
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		String euId=request.getParameter("id");
		User user=uService.findById(euId);
		request.setAttribute("user", user);
		request.getRequestDispatcher("user-modify.jsp").forward(request, response);
	}
}
