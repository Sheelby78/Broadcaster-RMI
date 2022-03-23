package interfejsy;


import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IConfiguration extends Remote {
    int addNews(String news) throws RemoteException;
    boolean removeNews(int id) throws RemoteException;
    String[] getCustomers() throws RemoteException;
}