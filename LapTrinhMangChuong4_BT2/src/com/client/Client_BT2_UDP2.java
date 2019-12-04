package com.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Client_BT2_UDP2 {
	public final static String SERVER_IP = "127.0.0.1";
	public final static int SERVER_PORT = 7;

	public static void main(String[] args) {
		DatagramSocket ds = null;
        try {
            ds = new DatagramSocket(); // Tạo DatagramSocket
            System.out.println("Client started ");
 
            InetAddress server = InetAddress.getByName(SERVER_IP);
            while (true) {
                System.out.println("Enter your message: ");
                InputStreamReader isr = new InputStreamReader(System.in); // Nhập
                BufferedReader br = new BufferedReader(isr); // một chuỗi
                String theString = br.readLine(); // từ bàn phím
                
                String op = theString.trim();
				if (op.contains("+")) {
					op = "+";
				} else if (op.contains("-")) {
					op = "-";
				} else if (op.contains("*")) {
					op = "*";
				} else {
					op = "/";
				}
				System.out.println("dấu là -> " + op);

				String numberOne = theString.substring(0, theString.indexOf(op.trim()));
				System.out.println("số thứ nhất " + numberOne);
				String numberTwo = theString.substring(theString.indexOf(op.trim()) + 1, theString.length()).trim();
				System.out.println("số thứ hai " + numberTwo);
				
				String send = op.trim() + " " + numberOne.trim() + " " + numberTwo.trim() + "\\n";
                byte[] data = send.getBytes(); // Đổi chuỗi ra mảng bytes
                // Tạo gói tin gởi
                DatagramPacket dp = new DatagramPacket(data, data.length, server, SERVER_PORT);
                ds.send(dp); // Send gói tin sang Echo Server
 
                // Đổi dữ liệu nhận được dạng mảng bytes ra chuỗi và in ra màn hình
                byte[] bs = new byte[1024];
        		DatagramPacket datagramPacket = new DatagramPacket(bs, bs.length);
        		ds.receive(datagramPacket);
        		String string = new String(datagramPacket.getData(), 0, bs.length);
        		System.out.println("Client nhận kết quả từ Server: " + string);
            }
        } catch (IOException e) {
            System.err.println(e);
        } finally {
            if (ds != null) {
                ds.close();
            }
        }
	}
}
