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
		 * 3:��ȡI/O�� ������������ȡsocket����Ϣ �����������socket������Ϣ
		 */
		InputStream is =null;
		BufferedReader br=null;
		OutputStream os=null;
		PrintWriter pw = null;
		try {
			is= socket.getInputStream();
			br = new BufferedReader(new InputStreamReader(is));
			os= socket.getOutputStream();
			pw= new PrintWriter(os);// ��ӡ��
			// 4:��ȡ�ͻ��˵���Ϣ
			String content = null;
			while ((content = br.readLine()) != null) {
				System.out.println("���տͻ���:" + content);
				System.out.println("������IP:"
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
