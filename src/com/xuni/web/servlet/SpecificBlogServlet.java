package com.xuni.web.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xuni.pojo.Blog;
import com.xuni.service.BlogService;
import com.xuni.service.impl.BlogServiceImpl;

/**
 * Servlet implementation class SpecificBlogServlet
 */
@WebServlet("/SpecificBlogServlet")
public class SpecificBlogServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SpecificBlogServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Blog> newlist = new ArrayList<>();
		List<Blog> likeslist = new ArrayList<>();
		BlogService bs = new BlogServiceImpl();
		
		try {
			newlist = bs.showNewBlog();
			likeslist = bs.showLikesBlogs();
			request.setAttribute("likeslist", likeslist);
			request.setAttribute("newlist", newlist);
			request.getRequestDispatcher("/jsp/index.jsp").forward(request, response);
		} catch (Exception e) {
			request.setAttribute("msg", "网路忙，请和管理员联系");
			request.getRequestDispatcher("/error/error.jsp");
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
