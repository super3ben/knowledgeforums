package com.xuni.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;





import com.xuni.dao.UserDao;
import com.xuni.dao.impl.UserDaoImpl;
import com.xuni.pojo.User;
import com.xuni.service.UserService;
import com.xuni.service.impl.UserServiceImpl;
import com.xuni.util.MD5Utils;

/**
 * Servlet implementation class DoResistServlet
 */
@WebServlet("/DoResistServlet")
public class DoResistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoResistServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/jsp/register.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("Name");
		String password = request.getParameter("Password");
		password=MD5Utils.md5(password);
		UserService us = new UserServiceImpl();
		UserDao dao = new UserDaoImpl();
		User newuser = new User();
		newuser.setName(name);
		newuser.setPassword(password);
		
		
		try {
			if(!dao.isValidUname(name)){
				request.setAttribute("msg", "用户名已存在！");
				request.getRequestDispatcher("/jsp/register.jsp").forward(request, response);
			}else{				
				us.register(newuser);
				request.setAttribute("msg", "注册成功，请登录");
				request.getRequestDispatcher("/login.jsp").forward(request, response);
			}
		} catch (Exception e) {
			request.setAttribute("msg", "网络连接异常,请和管理员联系");
			request.getRequestDispatcher("/jsp/error/error.jsp").forward(request, response);
			e.printStackTrace();
		}
	}

}
