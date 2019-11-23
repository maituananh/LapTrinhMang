package com.maituananh.teamMaiThi.workerThread;

import java.net.Socket;

public class WorkerThreadY1 extends Thread {
	private Socket socket;
	static int readnumber;

	public WorkerThreadY1(Socket socket) {
		this.socket = socket;
	}

	public void run() {
		System.out.println("Processing: " + socket);
		int input = 8;
		switch (input) {
		case 1:
			System.out.println("Một");
			break;
		case 2:
			System.out.println("hai");
			break;
		case 3:
			System.out.println("ba");
			break;
		case 4:
			System.out.println("bốn");
			break;
		case 5:
			System.out.println("năm");
			break;
		case 6:
			System.out.println("sáu");
			break;
		case 7:
			System.out.println("bảy");
			break;
		case 8:
			System.out.println("tám");
			break;
		case 9:
			System.out.println("chín");
			break;
		case 10:
			System.out.println("mười");
			break;
		case 11:
			System.out.println("mười một");
			break;
		case 20:
			System.out.println("hai mươi");
			break;
		case 12:
			System.out.println("mười hai");
			break;
		case 13:
			System.out.println("mười ba");
			break;
		case 14:
			System.out.println("mười bốn");
			break;
		case 15:
			System.out.println("mười năm");
			break;
		case 16:
			System.out.println("mười sáu");
			break;
		case 17:
			System.out.println("mười bảy");
			break;
		case 18:
			System.out.println("mười tám");
			break;
		case 19:
			System.out.println("mười chín");
			break;
		default:
			System.out.println("Không phải số nguyên");
		}
	}
}
