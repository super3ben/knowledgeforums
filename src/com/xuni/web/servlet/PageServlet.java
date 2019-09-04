package com.xuni.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xuni.dto.PageBean;
import com.xuni.pojo.Blog;
import com.xuni.service.BlogService;
import com.xuni.service.impl.BlogServiceImpl;

@WebServlet("/PageServlet")
public class PageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String current= request.getParameter("currentPage");
		int pageSize = 7;
		int currentPage = 1;
		if(current!=null) {
			currentPage = Integer.parseInt(current);
		}
		BlogService blogService = new BlogServiceImpl();
		PageBean pageBean = null;
		try {
			pageBean = blogService.findBlogsPage(currentPage,pageSize);
			request.setAttribute("pageBean", pageBean);
			request.getRequestDispatcher("/jsp/articles-list.jsp").forward(request, response);
		} catch (Exception e) {
			request.setAttribute("msg", "网路忙，请和管理员联系");
			request.getRequestDispatcher("/error/error.jsp").forward(request, response);;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
