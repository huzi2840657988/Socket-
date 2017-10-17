package com.zl.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
	public static void main(String[] args) throws UnknownHostException, IOException{
		//1:创建客户端socket
		Socket socket = new Socket("localhost",8888);
		/*
		 * 2:获取I/O流 输入流用来读取server的信息 输出流用来给server发送信息
		 */
		InputStream is = socket.getInputStream();
		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		OutputStream os = socket.getOutputStream();
		PrintWriter pw = new PrintWriter(os);// 打印流
		pw.write("用户名:admin2 密码:123456");
		pw.flush();//刷新缓冲区
		pw.close();
		os.close();
		br.close();
		is.close();
		socket.close();
	}
}
