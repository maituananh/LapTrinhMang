package RMI;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface function extends Remote{
    public String uppercase(String str) throws RemoteException;
    public int sum(int a, int b) throws RemoteException;
    public int perimeter(int a, int b) throws RemoteException;
}
