package cn.bdqn.servlet;

import java.io.IOException;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.bdqn.entity.User;
import cn.bdqn.service.UserService;
import cn.bdqn.service.impl.UserServiceImpl;

public class RegResultServlet extends HttpServlet {

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
		String userId = request.getParameter("userId");
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		String sex = request.getParameter("sex");
		String bir = request.getParameter("birthday");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		try {
			date = sdf.parse(bir);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		java.sql.Date birthday = new java.sql.Date(date.getTime());
		String identityCode = request.getParameter("identityCode");
		String eamil = request.getParameter("email");
		String mobile = request.getParameter("mobile");
		String address = request.getParameter("address");
		User user = new User(userId, userName, password, sex, birthday,
				identityCode, eamil, mobile, address, 1);
		int result = uService.addUser(user);
		if (result > 0) {
			request.setAttribute("msg", "true");
			request.getRequestDispatcher("reg-result.jsp").forward(request,
					response);
		} else {
			request.setAttribute("msg", "false");
			request.getRequestDispatcher("reg-result.jsp").forward(request,
					response);
		}
	}

}
