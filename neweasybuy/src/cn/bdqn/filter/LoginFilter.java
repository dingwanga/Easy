package cn.bdqn.filter;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.bdqn.entity.User;
//处理登陆的过滤
public class LoginFilter implements Filter{
	
	private List<String> list=Arrays.asList("/address.jsp","/showAdrressServlet");
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request=(HttpServletRequest) arg0;
		HttpServletResponse response=(HttpServletResponse) arg1;
		String path=request.getServletPath();
		HttpSession session=request.getSession();
		User user=(User) session.getAttribute("user");
		if(path.startsWith("/manage")){
			if(user==null){
				response.sendRedirect("../login.jsp");
			}else if(user.getEuStatus()==1){
				response.sendRedirect("../error.jsp");
			}else{
				chain.doFilter(arg0, arg1);
			}
		}else if(list.contains(path)){
			if(user==null){
				response.sendRedirect("/neweasybuy/error1.jsp");
			}else{
				chain.doFilter(arg0, arg1);
			}
		}else{
			chain.doFilter(arg0, arg1);
		}
	}

	@Override
	public void destroy() {
		
	}

}
