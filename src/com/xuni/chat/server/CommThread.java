package com.xuni.chat.server;

import java.net.Socket;

import com.xuni.chat.common.MessageFactory;
import com.xuni.chat.common.Util;


/**
 * ͨ���߳� 
 */
public class CommThread extends Thread {
	
	//socket
	private Socket sock;
	
	public CommThread(Socket sock){
		this.sock = sock ;
	}
	
	public void run() {
		while(true){
			//����client��������Ϣ
			try {
				MessageFactory.parseClientMessageAndSend(sock);
			} catch (Exception e) {
				String userInfo = Util.getUserInfoStr(sock);
				QQServer.getInstance().removeUser(userInfo);
				QQServer.getInstance().broadcastFriends();
			}
		}
	}
}
