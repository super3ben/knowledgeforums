package com.xuni.chat.server;

import java.net.Socket;

import com.xuni.chat.common.MessageFactory;
import com.xuni.chat.common.Util;


/**
 * 通信线程 
 */
public class CommThread extends Thread {
	
	//socket
	private Socket sock;
	
	public CommThread(Socket sock){
		this.sock = sock ;
	}
	
	public void run() {
		while(true){
			//解析client发来的消息
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
