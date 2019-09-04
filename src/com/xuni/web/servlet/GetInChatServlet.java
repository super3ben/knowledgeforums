package com.xuni.web.servlet;

import java.io.IOException;
import java.net.Socket;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xuni.chat.client.ClientCommThread;
import com.xuni.chat.client.QQClientUI;
import com.xuni.chat.common.Util;
import com.xuni.pojo.User;

/**
 * Servlet implementation class GetInChatServlet
 */
@WebServlet("/getInChat")
public class GetInChatServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetInChatServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = (User) request.getSession().getAttribute("user");
		if(user!=null) {
			QQClientUI ui = new QQClientUI();
			Socket sock = new Socket("192.168.20.1",8888) ;
			String localip = sock.getLocalAddress().getHostAddress();
			int port = sock.getLocalPort();
			ui.setTitle(localip + ":" + port+"("+user.getName()+")");
			
			byte[] userId = Util.int2Bytes(user.getUser_id());
			sock.getOutputStream().write(userId);
			sock.getOutputStream().flush();
			
			ClientCommThread thread = new ClientCommThread(sock,ui);
			thread.start();
			ui.setCommThread(thread);
			response.sendRedirect(request.getContextPath()+"/jsp/index.jsp");
		}else {
			response.sendRedirect(request.getContextPath()+ "/login.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
