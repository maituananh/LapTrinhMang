package RMI;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Interface extends Remote{
    public String firstLetter(String str) throws RemoteException;
    public float mul(float a, float b) throws RemoteException;
    public float area(float a, float b) throws RemoteException;
}
