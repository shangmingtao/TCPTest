package cn.milo.udptest;

import org.apache.log4j.Logger;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServerDemo {

	Logger log = Logger.getLogger(TCPServerDemo.class);
	  	private ServerSocket serverSocket;
		private DataInputStream dataInputStream;
		private OutputStream os;
		Socket socket =null;

	    public void startServer(){
	        try {
	            serverSocket = new ServerSocket(4444);
	            socket = serverSocket.accept();    
	            GetMessageFromClient();
	        } catch (IOException e) {    
	            // TODO Auto-generated catch block    
	            e.printStackTrace();    
	        }finally{  
	            if(socket!=null){  
	                try{  
	                    socket.close();  
	                }catch(IOException e) {   
	                    e.printStackTrace();   
	                }  
	            }  
	        }  
	          
	    }

	    public void send(String message) throws IOException {
			os=socket.getOutputStream();   //输出流
			os.write(("recv your "+message+"\r\n").getBytes());
		}
	        
	    private void GetMessageFromClient(){    
	        try {
				BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				String s;
				while ((s = in.readLine()) != null) {
					log.info("[recv client message] = " + s);
					this.send(s);
				}
	        } catch (IOException e) {
	            // TODO Auto-generated catch block    
	            e.printStackTrace();    
	        }    
	    }    
	    public static void main(String[] args) {  
	        // TODO Auto-generated method stub  
	        TCPServerDemo server = new TCPServerDemo();    
	        server.startServer();    
	    }  
}
