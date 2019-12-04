package RMI;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class functionimpl extends UnicastRemoteObject implements function{
    public functionimpl() throws RemoteException {
        super();
    }
    
    @Override
    public String uppercase(String str) throws RemoteException {
        return "Kết quả xử lý chuỗi là : " + str.toUpperCase();
    }
    
    @Override
    public int sum(int a, int b) throws RemoteException {
        return a + b;
    }

    @Override
    public int perimeter(int a, int b) throws RemoteException {
        return (a+b)*2;
    }
    
 

    
    
}
