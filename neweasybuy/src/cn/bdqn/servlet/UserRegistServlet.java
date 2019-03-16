package cn.bdqn.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import cn.bdqn.entity.User;
import cn.bdqn.service.UserService;
import cn.bdqn.service.impl.UserServiceImpl;

public class UserRegistServlet extends HttpServlet {

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
		User user=new User();
		String euId=request.getParameter("id");
		String euName=request.getParameter("name");
		String euPassword=request.getParameter("passWord");
		String euSex=request.getParameter("sex");
		String birthday=request.getParameter("birthday");
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		Date date=null;
		try {
			date=sdf.parse(birthday);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		java.sql.Date euBirthday=new java.sql.Date(date.getTime());
		String euMobile=request.getParameter("mobile");
		String euAddress=request.getParameter("address");
		user.setEuId(euId);
		user.setEuName(euName);
		user.setEuPassword(euPassword);
		user.setEuSex(euSex);
		user.setEuBirthday(euBirthday);
		user.setEuMobile(euMobile);
		user.setEuAddress(euAddress);
		int result=uService.modifyUser(user);
		if(result>0){
			request.setAttribute("msg", "true");
			request.getRequestDispatcher("manage-result.jsp").forward(request, response);
		}else{
			request.setAttribute("msg", "false");
			request.getRequestDispatcher("manage-result.jsp").forward(request, response);
		}
	}

}
