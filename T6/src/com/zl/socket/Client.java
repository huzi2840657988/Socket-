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
		//1:�����ͻ���socket
		Socket socket = new Socket("localhost",8888);
		/*
		 * 2:��ȡI/O�� ������������ȡserver����Ϣ �����������server������Ϣ
		 */
		InputStream is = socket.getInputStream();
		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		OutputStream os = socket.getOutputStream();
		PrintWriter pw = new PrintWriter(os);// ��ӡ��
		pw.write("�û���:admin2 ����:123456");
		pw.flush();//ˢ�»�����
		pw.close();
		os.close();
		br.close();
		is.close();
		socket.close();
	}
}
