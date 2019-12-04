package com.server;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class ServerUDP {

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
				
				
				
				String changeString = parseStringToNumber(message);
				System.out.println("-------------> " + changeString);
				
				// tìm IP và port của client để gửi về
				InetAddress IPAddress = incoming.getAddress();
				int clientPort = incoming.getPort();
				
				// Tạo gói tin gởi chứa dữ liệu vừa nhận được
				byte[] sendData = new byte[1024];
				sendData = changeString.getBytes();
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
	
	// tạo hàm sử dụng thuật toán để đọc số thành chữ
	public static String parseStringToNumber(String n) {

		char a[];
		int b = 0;
		int c = 0;
		String tmp = "";
		String strNumber = "";
		String result = "";
		String n1 = "";
		String nStr[] = { "không", "một", "hai", "ba", "bốn", "năm", "sáu", "bẩy", "tám", "chín" };
		String mStr[] = { "", "mươi", "trăm" };
		String vStr[] = { "", "nghìn", "triệu", "tỉ", "nghìn", "triệu" };

		for (int j = n.length(), x = 0; j >= 0; j -= 3, x += 3) {

			n1 = n.substring((j - 3 < 0) ? 0 : j - 3, j);

			a = n1.toCharArray();
			strNumber = "";

			for (int i = 0; i < a.length; i++) {

				try {
					b = Integer.parseInt("" + a[a.length - i - 1]);
					c = Integer.parseInt("" + a[Math.max(0, a.length - i - 2)]);
				} catch (NumberFormatException e) {
					return "Khong phai so nguyen";
				}

				tmp = (b == 1) ? ((i == 1) ? "mười" : ((i == 0 && c > 1) ? "mốt " : nStr[1] + " " + mStr[i]))
						: ((b == 5) ? ((i == 0 && c != 0 && i + 1 < a.length) ? "năm " : nStr[5] + " " + mStr[i])
								: ((b == 0)
										? ((i == 0) ? ""
												: ((i == 1 && c != 0) ? "linh"
														: ((i == 2) ? "không" + " " + mStr[i] : " ")))
										: nStr[b] + " " + mStr[i]));

				strNumber = !strNumber.equals("") ? tmp + " " + strNumber : tmp;
			}
			if (strNumber.equals("")) {
				break;
			}
			result = !result.equals("") ? strNumber + vStr[x / 3] + " " + result : strNumber;
		}

		return result;
	}

}
