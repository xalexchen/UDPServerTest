package com.liftcore.udptest;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketException;

public class UDPServerTest {
	private static final String VERSION = "TCISManage v0.1 2012/09/07";
	
    public static void main(String[] args) throws Exception {
        String serverHost = "192.168.1.195";
        int serverPort = 3344;
        System.out.println(VERSION);
        
        DatagramSocket ds2=new DatagramSocket(serverPort);
        String strInfo="who is online??";
        ds2.send(new DatagramPacket(strInfo.getBytes(),strInfo.length(),
                                 InetAddress.getByName("255.255.255.255"),9999));
        ds2.close();
        
        DatagramSocket ds3=new DatagramSocket(3344);
        byte [] buf=new byte[1024];
        DatagramPacket dp3=new DatagramPacket(buf,1024);
        ds3.receive(dp3);
       String strInfo2= new String(dp3.getData(),0,dp3.getLength())+
         " from "+dp3.getAddress().getHostAddress()+":"+dp3.getPort();
        System.out.println(strInfo2);
        ds3.close(); 
    }
}
