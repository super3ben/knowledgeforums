package com.xuni.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xuni.pojo.Blog;
import com.xuni.pojo.User;
import com.xuni.service.BlogService;
import com.xuni.service.impl.BlogServiceImpl;
import com.xuni.util.MyDate;

@WebServlet("/publishBlogServlet")
public class PublishBlogServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//获取表单数据数据
		String title = request.getParameter("title");
		String category = request.getParameter("category");
		String summary = request.getParameter("summary");
		String content = request.getParameter("content");
		
		//处理业务逻辑
		//封转blog
		User user = (User) request.getSession().getAttribute("user");
		
		Blog blog = new Blog();
		BlogService  blogService = new BlogServiceImpl(); 
		try {
			blog.setBlog_name(title);
			blog.setCategories(category);
			blog.setSummary(summary);
			blog.setBlog_content(content);
			blog.setUser_id(user.getUser_id());
			blog.setDate(MyDate.getCurrentDate());
			
			blogService.publishBlog(blog);
//			response.sendRedirect(request.getContextPath()+"/jsp/index.jsp");
//			request.getRequestDispatcher("/jsp/index.jsp").forward(request, response);
			
		} catch (Exception e) {
			request.setAttribute("msg", "网路忙，请和管理员联系");
			request.getRequestDispatcher("/error/error.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
