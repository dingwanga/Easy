package cn.bdqn.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.bdqn.entity.User;
import cn.bdqn.service.UserService;
import cn.bdqn.service.impl.UserServiceImpl;

public class AddAdrServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService uService=new UserServiceImpl();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session=request.getSession();
		String address=request.getParameter("address");
		User user=(User) session.getAttribute("user");
		User temp=uService.findById(user.getEuId());
		temp.setEuAddress(temp.getEuAddress()+","+address);
		uService.modifyUser(temp);
	}
}
