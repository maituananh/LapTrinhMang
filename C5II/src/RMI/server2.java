package RMI;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;

public class server2 {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry(5000);
            System.out.println("Khỏi động server 2");
            functionimpl rmi = new functionimpl();
            registry.rebind("function2", rmi);
            System.out.println("Đăng kí function");
            System.out.println("Server started");
        } catch (RemoteException ex) {
            Logger.getLogger(server2.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
