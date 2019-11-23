package com.maituananh.teamMaiThi.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ServerRequest1 {

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
					String op = is.readUTF();
					String subString = op.substring(0, op.lastIndexOf("\n")).toString();
					String[] words = subString.split("\\s");
					List<String> save = new ArrayList<String>();
					float resl = 0;
					for (String w : words) {
						save.add(w.toString());
					}
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
					}
					System.out.println(resl);
					os.writeUTF(String.valueOf(resl));
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
