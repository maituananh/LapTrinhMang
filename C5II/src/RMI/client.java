package RMI;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Client {

    public static void main(String[] args) {
        try {
            //ket noi rmi registry
            Registry registry = LocateRegistry.getRegistry("localhost", 5000);
            Interface rmi = (Interface) registry.lookup("interface");
            int n;
            while (true) {
                n = message();
                if (n >= 6) {
                    System.out.println("Thoát chương trình");
                    break;
                }
                if (n == 1) {
                    callUppercase(n, rmi);
                } else {
                    getSwitch(n, rmi);
                }
            }
        } catch (RemoteException | NotBoundException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static int message() {
        System.out.println("Xin chọn chức năng mong muốn :");
        System.out.println("1 : Xử lý chuỗi");
        System.out.println("2 : Tính tích");
        System.out.println("3 : Tính diện tích");
        System.out.println("6 : Thoat");
        return new Scanner(System.in).nextInt();
    }

    public static void callUppercase(int n, Interface rmi) {
        try {
            System.out.println("Nhập chuỗi :");
            String str = new Scanner(System.in).nextLine();
            System.out.println(rmi.firstLetter(str));
        } catch (RemoteException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void getSwitch(int n, Interface rmi) {
        System.out.println("Nhập số thứ nhất : ");
        float a = new Scanner(System.in).nextFloat();
        System.out.println("Nhập số thứ hai : ");
        float b = new Scanner(System.in).nextFloat();

        switch (n) {
            case 2: {
                try {
                    System.out.println("Tích là  : " + rmi.mul(a, b));
                    break;
                } catch (RemoteException ex) {
                    Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            case 3: {
                try {
                    if (a == 0 || b == 0) {
                        System.out.println("Các cạnh không được bằng 0");
                        break;
                    }
                    System.out.println("Diện tích : " + rmi.area(a, b));
                    break;
                } catch (RemoteException ex) {
                    Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
}
