package com.xuni.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xuni.pojo.User;
import com.xuni.service.UserService;
import com.xuni.service.impl.UserServiceImpl;

public class AutoLoginFilter implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		
		String uri = req.getRequestURI();
		String path = req.getContextPath();
		path = uri.substring(path.length());
		
		if(!("/login.jsp".equals(path)&&"/doLoginServlet".equals(path))) {
			User user = (User) req.getSession().getAttribute("user");
			if(user==null) {
				Cookie[] cookies = req.getCookies();
				String name = "";
				String password ="";
				for (int i = 0; cookies!=null && i < cookies.length; i++) {
					Cookie cookie = cookies[i];
					if("user".equals(cookie.getName())) {
						String value = cookie.getValue();
						String[] split = value.split("&");
						name = split[0];
						password = split[1];
					}
				}
				UserService userService = new UserServiceImpl();
				User u;
				try {
					u = userService.login(name, password);
					if(u!=null) {
						req.getSession().setAttribute("user", u);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		//·ÅÐÐ
		chain.doFilter(request,response);
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
