package main;

import thread1.MuThread1;
import thread2.MuThread2;
import thread3.MuThread3;
import thread4.MuThread4;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("1. In ra so chan nho hon n ");
        System.out.println("2. In ra so le nho hon n ");
        System.out.println("3. In ra so nho hon n ");
        System.out.println("4. In ra bang ma ");
        System.out.print("su lua chon cua ban :");
        int select = scanner.nextInt();
        switch (select) {
            case 1: // in số chẵn
                Thread thread = new Thread(new MuThread1());
                Thread thread2 = new Thread(new MuThread1());
                Thread thread3 = new Thread(new MuThread1());
                Thread thread4 = new Thread(new MuThread1());
                thread.start();
                thread2.start();
                thread3.start();
                thread4.start();
                break;

            case 2:// in số lẻ
                Thread threadLe = new Thread(new MuThread2());
                Thread thread2Le = new Thread(new MuThread2());
                Thread thread3Le = new Thread(new MuThread2());
                Thread thread4Le = new Thread(new MuThread2());
                threadLe.start();
                thread2Le.start();
                thread3Le.start();
                thread4Le.start();
                break;

            case 3:// in từ 1 đến n
                Thread threadN = new Thread(new MuThread3());
                Thread thread2N = new Thread(new MuThread3());
                Thread thread3N = new Thread(new MuThread3());
                Thread thread4N = new Thread(new MuThread3());
                threadN.start();
                thread2N.start();
                thread3N.start();
                thread4N.start();
                break;

            case 4:// in bảng mã
                Thread threadM = new Thread(new MuThread4());
                Thread thread2M = new Thread(new MuThread4());
                Thread thread3M = new Thread(new MuThread4());
                Thread thread4M = new Thread(new MuThread4());
                threadM.start();
                thread2M.start();
                thread3M.start();
                thread4M.start();
                break;
        }
    }
}
