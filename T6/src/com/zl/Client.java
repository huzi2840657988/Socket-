package com.zl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
	public static void main(String[] args) throws UnknownHostException, IOException{
		Scanner input = new Scanner(System.in);
		//1:创建客户端socket
		Socket socket = new Socket("localhost",8888);
		/*
		 * 2:获取I/O流 输入流用来读取server的信息 输出流用来给server发送信息
		 */
		InputStream is = socket.getInputStream();
		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		OutputStream os = socket.getOutputStream();
		PrintWriter pw = new PrintWriter(os);// 打印流
	/*	pw.write("用户名:admin2 密码:123456\r\n");
		pw.flush();//刷新缓冲区
		pw.write("88\r\n");
		pw.flush();//刷新缓冲区
	 */		
		while(true){
			System.out.println("请输入:");
			String inputNext = input.nextLine();
			pw.write(inputNext+"\r\n");
			pw.flush();
			if(inputNext.equals("88")){
				break;
			}
		}
		//socket.shutdownOutput();//关闭输出流
		//3:接收服务器通过输出流打印的信息
		String content = null;
		while((content=br.readLine())!=null){
			System.out.println("接收到服务器端发送的数据"+content);
		}
		pw.close();
		os.close();
		br.close();
		is.close();
		socket.close();
	}
}
