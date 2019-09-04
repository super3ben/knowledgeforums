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

/**
 * Servlet implementation class SearchBlogsServlet
 */
@WebServlet("/searchBlogsServlet")
public class SearchBlogsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchBlogsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String searchContext = request.getParameter("s");
		BlogService blogService = new BlogServiceImpl();
		List<Blog> searchBlogs = blogService.searchBlog(searchContext);
		request.setAttribute("blogs", searchBlogs);
		request.getRequestDispatcher("/jsp/articles-list2.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
