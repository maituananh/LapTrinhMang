package RMI;

import com.sun.xml.internal.ws.util.StringUtils;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class InterfaceImpl extends UnicastRemoteObject implements Interface{
    public InterfaceImpl() throws RemoteException {
        super();
    }
    
    @Override
    public String firstLetter(String str) throws RemoteException {
        return "Kết quả xử lý chuỗi là : " + StringUtils.capitalize(str.trim());
    }
    
    @Override
    public float mul(float a, float b) throws RemoteException {
        return a*b;
    }

    @Override
    public float area(float a, float b) throws RemoteException {
        return a*b;
    }

   

    
    
}
