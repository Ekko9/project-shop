package com.user.servlet;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.servlet4preview.ServletContext;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.user.bean.Product;
import com.user.service.ProductService;
import com.user.utils.UUIDUtils;

/**
 * Servlet implementation class UploadServlet
 */
public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UploadServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		// Check that we have a file upload request 检查是否有文件上传请求
		String name = null;
		String value = null;
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		if (isMultipart) {
			// Create a factory for disk-based file items
			// 创建DiskFileItemFactory对象，设置缓冲区大小和临时文件目录
			DiskFileItemFactory factory = new DiskFileItemFactory();
			// 默认临时文件夹

			// Create a new file upload handler创建ServletFileUpload对象，并设置上传文件的大小限制
			ServletFileUpload upload = new ServletFileUpload(factory);
			upload.setSizeMax(10 * 1024 * 1024);// 以byte为单位 不能超过10M 1024byte

			// Parse the request
			// 调用ServletFileUpload.parseRequest方法解析request对象，得到一个保存了所有上传内容的List对象
			try {
				List<FileItem> items = upload.parseRequest(request);
				// Process the uploaded items
				Iterator<FileItem> iter = items.iterator();
				while (iter.hasNext()) {
					FileItem item = iter.next();
					// 遍历list，每迭代一个FileItem对象，调用其isFormField方法判断是否是上传文件
					if (item.isFormField() == true) {// 普通表单元素
						name = item.getFieldName();// name属性值
						value = item.getString();// name对应的value值

						System.out.println("form field：" + name + "--" + value);
					} else {
						String fieldName = item.getFieldName();
						String fileName = item.getName();// 文件名称
						String contentType = item.getContentType();
						boolean isInMemory = item.isInMemory();
						long sizeInBytes = item.getSize();
						System.out.println("file upload：" + fieldName + "--" + fileName + "--" + contentType + "--"
								+ isInMemory + "--" + sizeInBytes);
					}

					// Process a file upload
					if (!item.isFormField()) {
						// 1.获取真实地址,这里保存在Tomcat运行的项目upload目录中,这要在src/main/webapp下新建upload文件夹
						// 2.保存到指定盘符
						String fileName = item.getName();
						File uploadedFile = new File("D:/WorkSpace/project-shop/WebContent/products/2/" + fileName);
						item.write(uploadedFile);
						response.sendRedirect(request.getContextPath()+"/jsp/saveProduct.jsp");
					}

				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

	}

}
