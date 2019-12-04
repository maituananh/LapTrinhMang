package com.maituananh.teamMaiThi.server;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class ServerUDP {
	public final static int SERVER_PORT = 3000;
	public static void main(String[] args) throws IOException {
		// server start
		System.out.println("Server started ");
		System.out.println("Waiting for messages from Client ... ");
		DatagramSocket serverSocket = new DatagramSocket(SERVER_PORT);
		
		byte[] receiveData = new byte[1024];
		// nhận gói tin từ Client
		DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
		serverSocket.receive(receivePacket);
		
		// sử lý gói tin
		String sentence = new String(receivePacket.getData());
		String op = sentence.trim();
		System.out.println(op);
		String check = op.substring(0, 1);
		String ac = op.substring(1, op.lastIndexOf("/"));
		String pass = op.substring(op.lastIndexOf("/") + 1);
		switch (check) {
		case "+": // thêm mới
			sentence = "tài khoản: " + ac + "\n" + "mật khẩu: " + pass;
			break;

		default: // đăng nhập
			if (ac.trim().equals("abc") && pass.trim().equals("123")) {
				sentence = "ĐÚNG";
			} else {
				sentence = "SAI";
			}
			break;
		}
		System.out.println("From client: " + sentence);

		// tìm IP và port của client để gửi về
		InetAddress IPAddress = receivePacket.getAddress();
		int clientPort = receivePacket.getPort();

		// gửi gói qua client
		byte[] sendData = new byte[1024];
		sendData = sentence.getBytes();
		DatagramPacket datagramPacket = new DatagramPacket(sendData, sendData.length, IPAddress, clientPort);
		serverSocket.send(datagramPacket);
		System.out.println("SYSTEM EXIT");
		
		serverSocket.close();
	}
}
