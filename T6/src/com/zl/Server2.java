package com.zl;

import java.io.IOException;

import java.net.ServerSocket;
import java.net.Socket;

public class Server2 {
	public static void main(String[] args) throws IOException {
		// 1:������������socket
		ServerSocket server = new ServerSocket(8888);
		System.out.println("***�����������,׼������������...***");
		// 2:�����ͻ���socket
		Socket socket =null;
		while(true){
			socket =  server.accept();
			ServerThread st = new ServerThread(socket);
			st.start();
		}
	}
}
