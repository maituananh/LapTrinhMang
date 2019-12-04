package RMI;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Server {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.createRegistry(5000);
            System.out.println("Khỏi động server");
            InterfaceImpl rmi = new InterfaceImpl();
            registry.rebind("interface", rmi);
            System.out.println("Đăng kí interface");
            System.out.println("Server start");
        } catch (RemoteException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
