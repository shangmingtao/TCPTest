package cn.milo.udptest;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class TCPClientDemo {
	  public static void main(String[] args) throws UnknownHostException, IOException, InterruptedException {
		  // TODO Auto-generated method stub
		  //1.建立TCP连接
//		  String ip = "127.0.0.1";
		  String ip = "118.212.149.51";   //服务器端ip地址
		  int port = 8888;        //端口号
		  Socket sck = new Socket(ip, port);
		  sck.setKeepAlive(true);
		  //2.传输内容sck
		  String content = "ping";
		  byte[] bstream = content.getBytes("UTF8");  //转化为字节流1
		  OutputStream os = sck.getOutputStream();   //输出流

		  Scanner sc = new Scanner(System.in);

		  new Thread(new TCPClientRecv(sck)).start();

		  while(true){
			  String input = sc.nextLine();
			  if(!input.equals("end")){
				  while(true){
					  SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 输出北京时间
					  String data = sdf.format(new Date());
					  os.write(("PING\r\n").getBytes());
					  Thread.currentThread().sleep(3000);
				  }
			  }else{
				  break;
			  }
		  }
//		  3.关闭连接
		  sck.close();
	  }
}
