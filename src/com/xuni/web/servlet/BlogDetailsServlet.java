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
import com.xuni.pojo.Comment;
import com.xuni.service.BlogService;
import com.xuni.service.UserService;
import com.xuni.service.impl.BlogServiceImpl;
import com.xuni.service.impl.CommentServiceImpl;
import com.xuni.service.impl.UserServiceImpl;

/**
 * Servlet implementation class BlogDetailsServlet
 */
@WebServlet("/BlogDetailsServlet")
public class BlogDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BlogDetailsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int blog_id = Integer.parseInt(request.getParameter("blog_id"));
		Blog blog = new Blog();
		BlogService bs = new BlogServiceImpl();
		CommentServiceImpl cs = new CommentServiceImpl();
		UserService userService = new UserServiceImpl();
		try {
			blog = bs.showBlogDetails(blog_id);
			System.out.println("befor service");
			List<Comment> listcom = cs.showBlogComment(blog_id);
			
			
			System.out.println("after service");
			request.setAttribute("blog", blog);
			request.setAttribute("listcom", listcom);
			
			
			///
			List<String> list = new ArrayList<String>();
			for (Comment comm : listcom) {
				String name = userService.findUserNameById(comm.getUser_id());
				list.add(name);
			}
			request.setAttribute("list", list);
			///
			
			
			request.getRequestDispatcher("/jsp/single.jsp").forward(request, response);
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
