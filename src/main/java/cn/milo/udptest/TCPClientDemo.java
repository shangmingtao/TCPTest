package cn.milo.udptest;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class TCPClientDemo {
	  public static void main(String[] args) throws UnknownHostException, IOException {
		  // TODO Auto-generated method stub
		  //1.建立TCP连接
//		  String ip = "127.0.0.1";
		  String ip = "118.212.149.51";   //服务器端ip地址
		  int port = 4444;        //端口号
		  Socket sck = new Socket(ip, port);
		  //2.传输内容
		  String content = "ping";
		  byte[] bstream = content.getBytes("UTF8");  //转化为字节流
		  OutputStream os = sck.getOutputStream();   //输出流

		  Scanner sc = new Scanner(System.in);

		  new Thread(new TCPClientRecv(sck)).start();

		  while(true){
			  String input = sc.nextLine();
			  if(!input.equals("end")){
				 os.write((input+"\r\n").getBytes());
//				  os.flush();
//				  System.out.println(input);
			  }else{
				  break;
			  }
		  }
		  //3.关闭连接
		  sck.close();
	  }
}
