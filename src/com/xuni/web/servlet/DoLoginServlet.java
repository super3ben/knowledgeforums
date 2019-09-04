package com.xuni.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xuni.pojo.User;
import com.xuni.service.UserService;
import com.xuni.service.impl.UserServiceImpl;
import com.xuni.util.MD5Utils;

@WebServlet("/doLoginServlet")
public class DoLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("Name");
		String password = request.getParameter("Password");
		password = MD5Utils.md5(password);
		UserService us = new UserServiceImpl();
		try {
			User user = us.login(name,password);
			if(user!=null) {
				String autoLogin = request.getParameter("autoLogin");
				Cookie cookie = new Cookie("user",name+"&"+password);
				Cookie cookiename = new Cookie("user",name);
				cookiename.setPath("/");
				cookiename.setMaxAge(60*60*24*7);
				cookie.setPath("/");
				if(autoLogin!=null) {
					cookie.setMaxAge(60*60*24*7);
				}else {
					cookie.setMaxAge(0);
				}
				response.addCookie(cookiename);
				response.addCookie(cookie);
				request.getSession().setAttribute("user", user);
				request.getRequestDispatcher("/SpecificBlogServlet").forward(request, response);
			}else {
				request.setAttribute("msg", "用户名或密码错误!");
				request.getRequestDispatcher("/login.jsp").forward(request, response);
			}
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
