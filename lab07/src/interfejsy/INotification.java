package interfejsy;


import javax.xml.crypto.Data;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Date;

public interface INotification extends Remote {
    void notify(String message, Date data) throws RemoteException;
}
