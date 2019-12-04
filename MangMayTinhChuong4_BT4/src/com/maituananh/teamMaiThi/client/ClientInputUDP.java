package com.maituananh.teamMaiThi.client;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class ClientInputUDP {
	public final static int SERVER_PORT = 3000;
	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(System.in);
		InetAddress address = InetAddress.getByName("localhost");
		DatagramSocket datagramSocket = new DatagramSocket();
		
		System.out.println("1. tạo tài khoảnh mới");
		System.out.println("2. Đăng nhập");
		System.out.print("sự lựa chọn của bạn: ");
		int input = scanner.nextInt();
		switch (input) {
		case 1:
			scanner.nextLine();
			System.out.print("Nhập Tài Khoản mới: ");
			String t = scanner.nextLine();
			System.out.print("Nhập Mật Khẩu mới: ");
			String p = scanner.nextLine();
			String chuoi = "+" + t + "/" + p;
			// send gói tin
			DatagramPacket sendPacket = new DatagramPacket(chuoi.getBytes(), chuoi.length(), address, SERVER_PORT);
			datagramSocket.send(sendPacket);
			break;

		case 2:
			scanner.nextLine();
			System.out.print("Nhập Tài Khoản: ");
			String to = scanner.nextLine();
			System.out.print("Nhập Mật Khẩu: ");
			String po = scanner.nextLine();
			String chuois = "-" + to + "/" + po;
			// send gói tin
			DatagramPacket sendPackets = new DatagramPacket(chuois.getBytes(), chuois.length(), address, SERVER_PORT);
			datagramSocket.send(sendPackets);
			break;
		}
		
		// NHẬN DỮ LIỆU TỪ SERVER
		byte[] bs = new byte[1024];
		DatagramPacket datagramPacket = new DatagramPacket(bs, bs.length);
		datagramSocket.receive(datagramPacket);
		String string = new String(datagramPacket.getData(), 0, bs.length);
		System.out.println(string);
		System.out.println("SYSTEM EXIT");
		
		datagramSocket.close();
		scanner.close();
	}

}
