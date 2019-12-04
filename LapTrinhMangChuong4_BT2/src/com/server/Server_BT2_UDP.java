package com.server;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;

public class Server_BT2_UDP {
	public final static int SERVER_PORT = 7; // Cổng mặc định của Echo Server
	public final static byte[] BUFFER = new byte[1024]; // Vùng đệm chứa dữ liệu cho gói tin nhận

	public static void main(String[] args) {
		DatagramSocket ds = null;
		try {
			System.out.println("Binding to port " + SERVER_PORT + ", please wait  ...");
			ds = new DatagramSocket(SERVER_PORT); // Tạo Socket với cổng là 7
			System.out.println("Server started ");
			System.out.println("Waiting for messages from Client ... ");

			while (true) { // Tạo gói tin nhận
				DatagramPacket incoming = new DatagramPacket(BUFFER, BUFFER.length);
				ds.receive(incoming); // Chờ nhận gói tin gởi đến

				// Lấy dữ liệu khỏi gói tin nhận
				String message = new String(incoming.getData(), 0, incoming.getLength());
				System.out.println("Received: " + message);

				// cắt chuỗi từ gói tin
				String subString = message.substring(0, message.indexOf("\\")).trim(); // cắt bỏ \n từ chuổi
				System.out.println(subString);
				String[] words = subString.split("\\s"); // cắt chuỗi theo khoảng trắng

				List<String> save = new ArrayList<String>(); // tạo mảng để lưu từng ký tự vào
				
				for (String w : words) { // for để đưa từ ký tự vàng mảng
					System.out.println(w);
					save.add(w.trim());
				}
				float resl = 0; // biến để lưu kết quả sau khi tính toán	
				switch (save.get(0)) {
				case "+":
					resl = Float.parseFloat(save.get(1)) + Float.parseFloat(save.get(2));
					break;
				case "-":
					resl = Float.parseFloat(save.get(1)) - Float.parseFloat(save.get(2));
					break;
				case "*":
					resl = Float.parseFloat(save.get(1)) * Float.parseFloat(save.get(2));
					break;
				case "/":
					resl = Float.parseFloat(save.get(1)) / Float.parseFloat(save.get(2));
					break;
//				default:
//					String a = String.valueOf(resl) + "";
//					break;
				}

				// tìm IP và port của client để gửi về
				InetAddress IPAddress = incoming.getAddress();
				int clientPort = incoming.getPort();

				// Tạo gói tin gởi chứa dữ liệu vừa nhận được
				byte[] sendData = new byte[1024];
				sendData = String.valueOf(resl).getBytes(); // chuyển double -> string -> byes
				DatagramPacket outsending = new DatagramPacket(sendData, sendData.length, IPAddress, clientPort);
				ds.send(outsending);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (ds != null) {
				ds.close();
			}
		}
	}
}
