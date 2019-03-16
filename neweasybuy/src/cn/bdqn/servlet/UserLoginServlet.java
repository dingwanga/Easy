package cn.bdqn.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.bdqn.entity.User;
import cn.bdqn.service.UserService;
import cn.bdqn.service.impl.UserServiceImpl;

public class UserLoginServlet extends HttpServlet {
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
		HttpSession session = request.getSession();
		String userId = request.getParameter("userId");
		String password = request.getParameter("password");
		String code = request.getParameter("code");
		String numrand = (String) session.getAttribute("numrand");
		User user = uService.findById(userId);
		if (user != null) {
			if (!(user.getEuPassword().equals(password))) {
				request.setAttribute("msg", "密码错误");
				request.getRequestDispatcher("login.jsp").forward(request,
						response);
			} else if (!(code.equals(numrand))) {
				request.setAttribute("msg", "验证码输入错误");
				request.getRequestDispatcher("login.jsp").forward(request,
						response);
			} else {
				session.setAttribute("user", user);
				//获得当前时间
				Date date = new Date();
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				String today = sdf.format(date);
				session = request.getSession();
				session.setAttribute("today", today);
				request.getRequestDispatcher("index.jsp").forward(request,
						response);
			}
		} else {
			request.setAttribute("msg", "用户名错误");
			request.getRequestDispatcher("login.jsp")
					.forward(request, response);
		}
	}
}
