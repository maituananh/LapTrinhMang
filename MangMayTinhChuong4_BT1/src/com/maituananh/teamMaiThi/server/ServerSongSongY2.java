package com.maituananh.teamMaiThi.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.maituananh.teamMaiThi.workerThread.WorkerThreadY2;

public class ServerSongSongY2 {
	public static final int NUM_OF_THREAD = 4;
	public final static int SERVER_PORT = 7;

	public static void main(String[] args) {
		ExecutorService executor = Executors.newFixedThreadPool(NUM_OF_THREAD);
		ServerSocket serverSocket = null;
		try {
			System.out.println("Binding to port " + SERVER_PORT + ", please wait  ...");
			serverSocket = new ServerSocket(SERVER_PORT);
			while (true) {
				try {
					Socket socket = serverSocket.accept();
					System.out.println("Client accepted: " + socket);

					WorkerThreadY2 handler = new WorkerThreadY2(socket);
					executor.execute(handler);
				} catch (IOException e) {
					System.err.println(" Connection Error: " + e);
				}
			}
		} catch (IOException e1) {
			e1.printStackTrace();
		} finally {
			if (serverSocket != null) {
				try {
					serverSocket.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

}
