package com.maituananh.teamMaiThi.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerTCP {

	public final static int SERVER_PORT = 6666;
	
	public static void main(String[] args) throws IOException {
		ServerSocket serverSocket = null;
		try {
			System.out.println("KHỞI ĐỘNG SERVER");
			serverSocket = new ServerSocket(SERVER_PORT);
			while (true) {
				try {
					Socket socket = serverSocket.accept();
					System.out.println("Client accepted: " + socket);
					DataInputStream is = new DataInputStream(socket.getInputStream());
					DataOutputStream os = new DataOutputStream(socket.getOutputStream());
					String op = is.readUTF().trim();
					String check = op.substring(0, 1);// kiểm tra người dùng muốn đăng nhập hay tạo tài khoảng
					String ac = op.substring(0, op.lastIndexOf("/"));// cắt tên người dùng ra
					String pass = op.substring(op.lastIndexOf("/") + 1);// cắt pass người dùng ra
					switch (check) {
					case "+": // thêm mới
						ac = ac.substring(1);
						os.writeUTF("tài khoảng: " + ac + "\n" + "mật khẩu: " + pass); // đẩy dữ liệu ra client
						break;

					default: // đăng nhập
						if(ac.trim().equals("abc") && pass.trim().equals("123")) {
							os.writeUTF("ĐÚNG");
						} else {
							os.writeUTF("SAI");
						}
						break;
					}
					socket.close();
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
