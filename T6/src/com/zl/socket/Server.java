package com.zl.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static void main(String[] args) throws IOException {
		// 1:创建服务器端socket
		ServerSocket server = new ServerSocket(8888);
		System.out.println("***服务端已启动,准备接受数据中...***");
		// 2:侦听客户端socket
		Socket socket = server.accept();
		/*
		 * 3:获取I/O流 输入流用来读取socket的信息 输出流用来给socket发送信息
		 */
		InputStream is = socket.getInputStream();
		BufferedReader br = new BufferedReader(new InputStreamReader(is));

		OutputStream os = socket.getOutputStream();
		PrintWriter pw = new PrintWriter(os);// 打印流
		// 4:获取客户端的信息
		String content = null;
		while ((content = br.readLine()) != null) {
			System.out.println("接收客户端:" + content);
			System.out.println("来自于IP:"
					+ socket.getInetAddress().getHostAddress());
		}
		// 5:关闭资源
		pw.close();
		os.close();
		br.close();
		is.close();
		socket.close();
		server.close();
	}
}
