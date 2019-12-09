/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamllm.projectOfTeamllm.server;

import com.teamllm.projectOfTeamllm.controller.center;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 *
 * @author MaiTuanAnhLapTop
 */
public class WorkerThread extends Thread {

    private Socket socket;
    private center center = new center();

    public WorkerThread(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        System.out.println("Processing: " + socket);
        try {
            DataInputStream ip = new DataInputStream(socket.getInputStream());
            DataOutputStream op = new DataOutputStream(socket.getOutputStream());
            Byte receiveByte = ip.readByte();
            String receive = ip.readUTF(); // Receive data from client
            System.out.println("nhận từ client: " + receive);
            switch (receiveByte) {

                case 1:
                    String code = receive.substring(0, receive.indexOf("/"));
                    String pass = receive.substring(receive.indexOf("/") + 1, receive.length());
                    System.out.println("code = " + code + " and pass = " + pass);
                    int res = center.login(Integer.parseInt(code.trim()), pass.trim());
                    op.writeUTF("" + res); // Send the results to client
                    break;
            }
            
        } catch (IOException e) {
            System.err.println("Request Processing Error: " + e);
        }
        System.out.println("Complete processing: " + socket);
    }
}
