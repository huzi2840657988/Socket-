package com.zl;

import java.io.IOException;

import java.net.ServerSocket;
import java.net.Socket;

public class Server2 {
	public static void main(String[] args) throws IOException {
		// 1:创建服务器端socket
		ServerSocket server = new ServerSocket(8888);
		System.out.println("***服务端已启动,准备接受数据中...***");
		// 2:侦听客户端socket
		Socket socket =null;
		while(true){
			socket =  server.accept();
			ServerThread st = new ServerThread(socket);
			st.start();
		}
	}
}
