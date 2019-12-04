package RMI;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class client2 {
    public static void main(String[] args) {
        try {
            //ket noi rmi registry
            Registry registry = LocateRegistry.getRegistry("localhost",5000);
            function rmi = (function) registry.lookup("function2");
            int n;
            while(true) {
                n = message();
                if (n == 4) break;
                if(n == 1){
                    callUppercase(n, rmi);
                } else {
                    getSwitch(n, rmi);
                }
            }
        } catch (RemoteException | NotBoundException ex) {
            Logger.getLogger(client2.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }
    
    public static int message() {
        System.out.println("Xin chọn chức năng mong muốn :");
        System.out.println("1 : Xử lý chuỗi");
        System.out.println("2 : Tính tổng");
        System.out.println("3 : Tính chu vi");
        System.out.println("4 : Thoat");
        return new Scanner(System.in).nextInt();
    }
    
    public static void callUppercase(int n, function rmi){
        try {
            System.out.println("Nhập chuỗi :");
            String str = new Scanner(System.in).nextLine();
            System.out.println(rmi.uppercase(str));
        } catch (RemoteException ex) {
            Logger.getLogger(client2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void getSwitch(int n, function rmi) {
        System.out.println("Nhập số thứ nhất : ");
        int a = new Scanner(System.in).nextInt();
        System.out.println("Nhập số thứ hai : ");
        int b = new Scanner(System.in).nextInt();
        
        switch(n) {
            case 2:{
                try {
                    System.out.println("Tổng là  : " + rmi.sum(a, b));
                    break;
                } catch (RemoteException ex) {
                    Logger.getLogger(client2.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            case 3:{
                try {
                    System.out.println("Chu vi : " + rmi.perimeter(a ,b));
                    break;
                } catch (RemoteException ex) {
                    Logger.getLogger(client2.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
}

