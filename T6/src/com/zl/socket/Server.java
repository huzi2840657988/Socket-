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
		// 1:������������socket
		ServerSocket server = new ServerSocket(8888);
		System.out.println("***�����������,׼������������...***");
		// 2:�����ͻ���socket
		Socket socket = server.accept();
		/*
		 * 3:��ȡI/O�� ������������ȡsocket����Ϣ �����������socket������Ϣ
		 */
		InputStream is = socket.getInputStream();
		BufferedReader br = new BufferedReader(new InputStreamReader(is));

		OutputStream os = socket.getOutputStream();
		PrintWriter pw = new PrintWriter(os);// ��ӡ��
		// 4:��ȡ�ͻ��˵���Ϣ
		String content = null;
		while ((content = br.readLine()) != null) {
			System.out.println("���տͻ���:" + content);
			System.out.println("������IP:"
					+ socket.getInetAddress().getHostAddress());
		}
		// 5:�ر���Դ
		pw.close();
		os.close();
		br.close();
		is.close();
		socket.close();
		server.close();
	}
}
