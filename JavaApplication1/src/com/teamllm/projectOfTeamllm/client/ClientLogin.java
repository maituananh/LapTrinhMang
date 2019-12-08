/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamllm.projectOfTeamllm.client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 *
 * @author MaiTuanAnhLapTop
 */
public class ClientLogin {

    public final static String SERVER_IP = "127.0.0.1";
    public final static int SERVER_PORT = 7;

    public static int client_Login(int code, String pass) throws IOException, InterruptedException {
        Socket socket = null;
        try {
            System.out.println("----- CLIENT STARTED -----");
            socket = new Socket(SERVER_IP, SERVER_PORT); // Connect to server
            System.out.println("Connected: " + socket);
            DataInputStream ip = new DataInputStream(socket.getInputStream());
            DataOutputStream op = new DataOutputStream(socket.getOutputStream());
            String mess = code + "/" + pass;
            op.writeByte(1);
            op.writeUTF(mess); // Send to the server
            return Integer.parseInt(ip.readUTF().trim());
        } catch (IOException ie) {
            System.out.println("Can't connect to server");
        }
        return 0;
    }
}
