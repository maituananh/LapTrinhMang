package com.maituananh.teamMaiThi.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerTuanTuY1 {

	public final static int SERVER_PORT = 7;

	public static void main(String[] args) throws IOException {
		ServerSocket serverSocket = null;
		try {
			System.out.println("KHỞI ĐỘNG SERVER");
			serverSocket = new ServerSocket(SERVER_PORT);
			while (true) {
				try {
					Socket socket = serverSocket.accept();
					System.out.println("Client accepted: " + socket);
					Scanner scanner = new Scanner(System.in);
					int input = scanner.nextInt();
					String readNumber = "";
					switch (input) {
					case 1:
						readNumber = "số 1";
						break;
					case 2:
						readNumber = "hai";
						break;
					case 3:
						readNumber = "ba";
						break;
					case 4:
						readNumber = "bốn";
						break;
					case 5:
						readNumber = "năm";
						break;
					case 6:
						readNumber = "sáu";
						break;
					case 7:
						readNumber = "bảy";
						break;
					case 8:
						readNumber = "tám";
						break;
					case 9:
						readNumber = "chín";
						break;
					case 10:
						readNumber = "mười";
						break;
					case 11:
						readNumber = "mười một";
						break;
					case 20:
						readNumber = "hai mươi";
						break;
					case 12:
						readNumber = "mười hai";
						break;
					case 13:
						readNumber = "mười ba";
						break;
					case 14:
						readNumber = "mười bốn";
						break;
					case 15:
						readNumber = "mười năm";
						break;
					case 16:
						readNumber = "mười sáu";
						break;
					case 17:
						readNumber = "mười bảy";
						break;
					case 18:
						readNumber = "mười tám";
						break;
					case 19:
						readNumber = "mười chín";
						break;
					default:
						System.out.println("Không phải số nguyên");
					}
					System.out.println(readNumber);
					socket.close();
					scanner.close();
					System.exit(0);
				} catch (IOException e) {
					System.err.println(" Connection Error: " + e);
				}
			}
		} catch (IOException e1) {
			e1.printStackTrace();
		} finally {
			if (serverSocket != null) {
				serverSocket.close();
			}
		}
	}

}
