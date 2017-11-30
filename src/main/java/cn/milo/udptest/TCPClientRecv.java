package cn.milo.udptest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/******************************************************
 ****** @ClassName   : TCPClientRecv.java                                            
 ****** @author      : milo ^ ^                     
 ****** @date        : 2017 11 30 20:12     
 ****** @version     : v1.0.x                      
 *******************************************************/
public class TCPClientRecv implements Runnable {

    private Socket socket;

    public TCPClientRecv(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String s;
            while ((s = in.readLine()) != null) {
                System.out.println(s);
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
