package pakiecik;

import data.CustomerData;
import data.NewsData;
import interfejsy.IConfiguration;
import interfejsy.INotification;
import interfejsy.IRegistration;

import java.net.InetAddress;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Broadcaster extends UnicastRemoteObject implements IConfiguration, IRegistration {

    List<CustomerData> customerList = new ArrayList<>();
    List<NewsData> dataList = new ArrayList<>();
    int temp=0;

    public Broadcaster() throws RemoteException {
        super();

    }


    public void start (){

        try {

            Broadcaster lServer = new Broadcaster();
            Registry reg = LocateRegistry.createRegistry(52369);
            String url = "rmi://" + InetAddress.getLocalHost().getHostAddress() + ":52369/Hello";
            Naming.rebind(url, lServer);
            System.out.println("Server is ready");
        } catch (Exception aInE)
        {
            System.out.println("Remote error- " + aInE);
        }

    }


    public int addNews(String news) throws RemoteException {
        if(news.equals(".clean")){
            for(int i=0;i<customerList.size();i++){
                customerList.get(i).broadcast.notify(".clean",new Date());
                for(int j=0;j<customerList.get(i).wiadomosci.size();j++){
                    customerList.get(i).broadcast.notify(customerList.get(i).wiadomosci.get(j).news,customerList.get(i).wiadomosci.get(j).date);
                }
            }
            return 0;
        }
        temp++;
        Date data = new Date();
        dataList.add(new NewsData(news,data,temp));

        for(int i=0;i<customerList.size();i++){
                customerList.get(i).wiadomosci.add(new NewsData(news,data,temp));
                customerList.get(i).broadcast.notify(news,data);
        }
        return temp;
    }


    public boolean removeNews(int id) throws RemoteException {
        for(int i=0;i<dataList.size();i++){
            if(dataList.get(i).id==id){
                dataList.remove(i);
            }
        }
        for (int i =0;i<customerList.size();i++){
            for(int j=0;j<customerList.get(i).wiadomosci.size();j++){
                if(customerList.get(i).wiadomosci.get(j).id==id){
                    customerList.get(i).wiadomosci.remove(j);
                    addNews(".clean");
                }
            }
        }
        return false;
    }


    public String[] getCustomers() throws RemoteException {
        String[] nowa = new String[customerList.size()];
        for(int i=0;i<customerList.size();i++){
            nowa[i] = customerList.get(i).name;
        }
        return nowa;
    }



    public boolean register(String name, INotification broadcast) throws RemoteException {

        List<NewsData> wiadomosci = new ArrayList<>();
        customerList.add(new CustomerData(name,broadcast,wiadomosci));

        return false;
    }


    public boolean unregister(String name) throws RemoteException {

        for(int i=0;i<customerList.size();i++){
            if(customerList.get(i).name.equals(name)){
                customerList.get(i).broadcast.notify(".clean",new Date());
                customerList.remove(i);
                break;
            }
        }
        return false;
    }

}
