package com.maituananh.teamMaiThi.client;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class ClientNotInputY1 {
	public final static String SERVER_IP = "127.0.0.1";
	public final static int SERVER_PORT = 7;

	public static void main(String[] args) {
		Socket socket = null;
		Scanner scanner = new Scanner(System.in);
		try {
			socket = new Socket(SERVER_IP, SERVER_PORT); // Connect to server
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
