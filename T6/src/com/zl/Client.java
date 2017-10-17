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
		//1:�����ͻ���socket
		Socket socket = new Socket("localhost",8888);
		/*
		 * 2:��ȡI/O�� ������������ȡserver����Ϣ �����������server������Ϣ
		 */
		InputStream is = socket.getInputStream();
		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		OutputStream os = socket.getOutputStream();
		PrintWriter pw = new PrintWriter(os);// ��ӡ��
	/*	pw.write("�û���:admin2 ����:123456\r\n");
		pw.flush();//ˢ�»�����
		pw.write("88\r\n");
		pw.flush();//ˢ�»�����
	 */		
		while(true){
			System.out.println("������:");
			String inputNext = input.nextLine();
			pw.write(inputNext+"\r\n");
			pw.flush();
			if(inputNext.equals("88")){
				break;
			}
		}
		//socket.shutdownOutput();//�ر������
		//3:���շ�����ͨ���������ӡ����Ϣ
		String content = null;
		while((content=br.readLine())!=null){
			System.out.println("���յ��������˷��͵�����"+content);
		}
		pw.close();
		os.close();
		br.close();
		is.close();
		socket.close();
	}
}
