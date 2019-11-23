package com.maituananh.teamMaiThi.client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class ClientInputTCP {
	public final static String SERVER_IP = "127.0.0.1";
	public final static int SERVER_PORT = 6666;

	public static void main(String[] args) {
		Socket socket = null;
		Scanner scanner = new Scanner(System.in);
		try {
			socket = new Socket(SERVER_IP, SERVER_PORT); // Connect to server
			DataOutputStream is = new DataOutputStream(socket.getOutputStream());
			DataInputStream os = new DataInputStream(socket.getInputStream());
			System.out.println("1. tạo tài khoảng mới");
			System.out.println("2. Đăng nhập");
			System.out.print("sự lựa chọn của bạn: ");
			int input = scanner.nextInt();
			switch (input) {
			case 1:
				scanner.nextLine();
				System.out.print("Nhập Tài Khoảng mới: ");
				String t = scanner.nextLine();
				System.out.print("Nhập Mật Khẩu mới: ");
				String p = scanner.nextLine();
				is.writeUTF("+" + t + "/" + p);
				break;

			case 2:
				scanner.nextLine();
				System.out.print("Nhập Tài Khoảng: ");
				String to = scanner.nextLine();
				System.out.print("Nhập Mật Khẩu: ");
				String po = scanner.nextLine();
				is.writeUTF(to + "/" + po);
				break;
			}
			System.out.println("kết quả = " + os.readUTF());
		} catch (IOException ie) {
			System.out.println("Can't connect to server");
		} finally {
			if (socket != null) {
				try {
					socket.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		scanner.close();
	}

}
