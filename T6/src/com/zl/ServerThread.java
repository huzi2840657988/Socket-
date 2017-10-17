package com.zl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class ServerThread extends Thread {
	private Socket socket = null;
	public ServerThread(Socket socket){
		this.socket = socket;
	}
	
	@Override
	public void run() {
		/*
		 * 3:获取I/O流 输入流用来读取socket的信息 输出流用来给socket发送信息
		 */
		InputStream is =null;
		BufferedReader br=null;
		OutputStream os=null;
		PrintWriter pw = null;
		try {
			is= socket.getInputStream();
			br = new BufferedReader(new InputStreamReader(is));
			os= socket.getOutputStream();
			pw= new PrintWriter(os);// 打印流
			// 4:获取客户端的信息
			String content = null;
			while ((content = br.readLine()) != null) {
				System.out.println("接收客户端:" + content);
				System.out.println("来自于IP:"
						+ socket.getInetAddress().getHostAddress());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				if(pw!=null)
					pw.close();
				if(os!=null)
					os.close();
				if(br!=null)
					br.close();
				if(is!=null)
				is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} 
		
	}
}
