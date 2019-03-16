package cn.bdqn.servlet;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import cn.bdqn.entity.Product;
import cn.bdqn.entity.ProductCategory;
import cn.bdqn.service.ProductCategoryService;
import cn.bdqn.service.ProductService;
import cn.bdqn.service.impl.ProductCategoryServiceImpl;
import cn.bdqn.service.impl.ProductServiceImpl;

public class ProductUpdateServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private ProductService pService = new ProductServiceImpl();
	private ProductCategoryService pcService = new ProductCategoryServiceImpl();

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		// 将字符串数组装换为List集合
		List<String> fileType = Arrays.asList("gif", "bmp", "jpg", "jpeg");
		int result = 0;
		boolean flag = true;
		Product product = new Product();
		// 上传文件的存储路径（服务器文件系统上的绝对文件路径）
		try {
			String path = request.getSession().getServletContext()
					.getRealPath("/files");
			File file = new File(path);
			if (!file.exists()) {
				file.mkdir();
			}
			// 创建流工厂
			FileItemFactory factory = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(factory);
			// 设置上传文件的大小为5M
			upload.setSizeMax(1024 * 1024 * 5);
			int childId = 0;
			@SuppressWarnings("unchecked")
			List<FileItem> list = upload.parseRequest(request);
			for (FileItem item : list) {
				// 如果是普通字段，不是文件类型的
				if (item.isFormField()) {
					// 商品名称
					if (item.getFieldName().equals("productName")) {
						// 乱码的问题
						product.setEpName(item.getString("UTF-8"));
						// 商品描述
					} else if (item.getFieldName().equals("productDetail")) {
						product.setEpDescription(item.getString("UTF-8"));
						// 商品编号
					} else if (item.getFieldName().equals("parentId")) {
						childId = Integer.parseInt(item.getString("UTF-8"));
						ProductCategory pCategory = pcService
								.findCategory(childId);
						// 设置父类id
						product.setEpcId(pCategory.getEpcParentId());
						// 设置子类Id
						product.setEpcChildId(childId);
						// 商品价格
					} else if (item.getFieldName().equals("productPrice")) {
						product.setEpPrice(Double.parseDouble(item
								.getString("UTF-8")));
						// 商品库存
					} else if (item.getFieldName().equals("productNumber")) {
						product.setEpStock(Integer.parseInt(item
								.getString("UTF-8")));
					} else if (item.getFieldName().equals("epId")) {
						product.setEpId(Integer.parseInt(item
								.getString("UTF-8")));
					}

				} else {// 文件类型的字段
					// 获取文件名
					String fileName = item.getName();
					if (!(fileName == null || fileName.equals(""))) {
						// 解决兼容问题
						String pic = new File(fileName).getName();
						String type = pic.substring(pic.lastIndexOf(".") + 1);
						// 解决大小写的问题
						if (fileType.contains(type.toLowerCase())) {
							product.setEpFileName(pic);
							String uploadPath = path + "/" + pic;
							// 写入文件
							item.write(new File(uploadPath));
						} else {
							flag = false;
						}

					}

				}
			}
			if (flag) {
				result = pService.updateProduct(product);
				if (result > 0) {
					request.setAttribute("msg", "true");
					request.getRequestDispatcher("manage-result.jsp").forward(
							request, response);
				} else {
					request.setAttribute("msg", "false");
					request.getRequestDispatcher("manage-result.jsp").forward(
							request, response);
				}
			} else {
				request.setAttribute("msg", "上传文件的格式不正确！");
				request.getRequestDispatcher("product-modify.jsp").forward(
						request, response);
			}
		} catch (FileUploadException e) {
			String msg = "上传失败，上传文件过大！";
			request.setAttribute("msg", msg);
			request.getRequestDispatcher("product-modify.jsp").forward(request,
					response);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
