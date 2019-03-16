package cn.bdqn.servlet;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.bdqn.entity.News;
import cn.bdqn.entity.Product;
import cn.bdqn.entity.ProductCategory;
import cn.bdqn.service.NewsService;
import cn.bdqn.service.ProductCategoryService;
import cn.bdqn.service.ProductService;
import cn.bdqn.service.impl.NewsServiceImpl;
import cn.bdqn.service.impl.ProductCategoryServiceImpl;
import cn.bdqn.service.impl.ProductServiceImpl;
import cn.bdqn.util.PageBean;


public class HomeServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private NewsService nService=new NewsServiceImpl();
	private ProductService pService=new ProductServiceImpl();
	private ProductCategoryService pcService=new ProductCategoryServiceImpl();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			doPost(request, response);				
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		HttpSession session=request.getSession();
		String pNo=request.getParameter("pageNo");
		List<News> newsList=nService.findAllNews();
		request.setAttribute("newsList", newsList);
		int pageSize=8;
		int pageNo=1;
		if(pNo!=null){
			pageNo=Integer.parseInt(pNo);
		}
		String str="";
		Cookie [] cookies=request.getCookies();
		if(cookies!=null){
			for (Cookie cookie : cookies) {
				if(cookie.getName().equals("productId")){
					str=cookie.getValue();
					break;
				}
			}
		}
		List<Product> list=pService.findByIds(str);
		request.setAttribute("list", list);
		PageBean<Product> pbProduct=pService.findByPage(pageNo, pageSize);
		Map<ProductCategory, List<ProductCategory>> mapPc=pcService.findAllCategory();
		session.setAttribute("mapPc", mapPc);
		session.setAttribute("pbProduct", pbProduct);
		request.getRequestDispatcher("index.jsp").forward(request, response);
		
	}
}
