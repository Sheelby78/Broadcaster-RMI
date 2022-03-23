package interfejsy;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IRegistration extends Remote {
    boolean register(String name, INotification broadcast) throws RemoteException;
    boolean unregister(String name) throws RemoteException;
}
