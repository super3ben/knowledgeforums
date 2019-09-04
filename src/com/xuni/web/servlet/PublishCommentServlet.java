package com.xuni.web.servlet;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xuni.pojo.Comment;
import com.xuni.pojo.User;
import com.xuni.service.CommentService;
import com.xuni.service.impl.CommentServiceImpl;
import com.xuni.util.MyDate;

/**
 * Servlet implementation class PublishComment
 */
@WebServlet("/PublishComment")
public class PublishCommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PublishCommentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = (User) request.getSession().getAttribute("user");
		int user_id = user.getUser_id();
		int blog_id = Integer.parseInt(request.getParameter("blog_id"));
		String comment = (String) request.getParameter("comment");
		//Date c_date = new Date();
		//SimpleDateFormat sdf = new SimpleDateFormat();	
		//String   date   =   sDateFormat.format(new   java.util.Date());  
		Comment comm = new Comment();
		comm.setUser_id(user_id);
		comm.setBlog_id(blog_id);
		comm.setComment(comment);
		comm.setC_date(MyDate.getCurrentDate());
		
		CommentService cs = new CommentServiceImpl();
		try {
			cs.addComment(comm);
			request.getRequestDispatcher("/BlogDetailsServlet?blog_id="+blog_id).forward(request, response);
		} catch (Exception e) {
			request.setAttribute("msg", "网路忙，请和管理员联系");
			request.getRequestDispatcher("/error/error.jsp").forward(request, response);
			e.printStackTrace();
		}
		
	}


}
