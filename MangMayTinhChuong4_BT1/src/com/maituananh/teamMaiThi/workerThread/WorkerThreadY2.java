package com.maituananh.teamMaiThi.workerThread;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class WorkerThreadY2 extends Thread{
	private Socket socket;
	 
    public WorkerThreadY2(Socket socket) {
        this.socket = socket;
    }
 
    public void run() {
        System.out.println("Processing: " + socket);
        try {
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
            String readNumber = dataInputStream.readUTF();
            dataOutputStream.writeUTF(readNumber);
        } catch (IOException e) {
            System.err.println("Request Processing Error: " + e);
        }
        System.out.println("Complete processing: " + socket);
    }
}
