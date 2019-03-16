package cn.bdqn.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.bdqn.entity.Product;
import cn.bdqn.service.ProductService;
import cn.bdqn.service.impl.ProductServiceImpl;
import cn.bdqn.util.CookieUtil;

public class ProductviewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductService pService = new ProductServiceImpl();

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		int epId = Integer.parseInt(request.getParameter("id"));
		Product product = pService.findById(epId);
		Cookie [] cookies=request.getCookies();
		String str="";
		if(cookies!=null){
			for (Cookie cookie : cookies) {
				if(cookie.getName().equals("productId")){
					str=cookie.getValue();
					break;
				}
			}
		}
		String newStr=CookieUtil.addValue(str, epId+"");
		Cookie c=new Cookie("productId",newStr);
		c.setMaxAge(60*60*24*7);
		//一定要将cookie加进去
		response.addCookie(c);
		request.setAttribute("product", product);
		
		request.getRequestDispatcher("product-view.jsp").forward(request,
				response);
	}
}
