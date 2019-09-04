package com.xuni.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xuni.service.BlogService;
import com.xuni.service.impl.BlogServiceImpl;

@WebServlet("/AddLikes")
public class AddLikes extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String bid =request.getParameter("bid");
		BlogService blogService = new BlogServiceImpl();
		try {
			blogService.addLikes(bid);
		} catch (Exception e) {
			request.setAttribute("msg", "网路忙，请和管理员联系");
			request.getRequestDispatcher("/error/error.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
