package com.xuni.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xuni.pojo.Blog;
import com.xuni.service.BlogService;
import com.xuni.service.impl.BlogServiceImpl;

@WebServlet("/ArticlesListServlet")
public class ArticlesListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//
		
		//
		BlogService blogService = new BlogServiceImpl();
		try {
			List<Blog> blogs=  blogService.showAllBlog();
			
			request.setAttribute("blogs", blogs);
			request.getRequestDispatcher("/jsp/articles-list.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("msg", "网路忙，请和管理员联系");
			request.getRequestDispatcher("/error/error.jsp");
		}
		
		//
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
