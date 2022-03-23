package pakiecik;

import interfejsy.IConfiguration;

import javax.swing.*;
import java.net.InetAddress;
import java.rmi.Naming;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Editor extends UnicastRemoteObject {

    JTextArea listaUczestnikow;

    public Editor(JTextArea listaUczestnikow) throws RemoteException {
        this.listaUczestnikow=listaUczestnikow;
    }

    public int dodaj(String message) {
        int temp = 0;
        try {
            String url = "rmi://" + InetAddress.getLocalHost().getHostAddress() + ":52369/Hello";
            Remote lRemote = Naming.lookup(url);
            IConfiguration c = (IConfiguration) lRemote;
            temp = c.addNews(message);

        } catch (Exception aInE) {
            System.out.println(aInE);
        }
        return temp;
    }

    public void usun(int id){
        try {
            String url = "rmi://" + InetAddress.getLocalHost().getHostAddress() + ":52369/Hello";
            Remote lRemote = Naming.lookup(url);
            IConfiguration c = (IConfiguration) lRemote;
            c.removeNews(id);

        } catch (Exception aInE) {
            System.out.println(aInE);
        }
    }

    public void uczestnicy(){
        try {
            String url = "rmi://" + InetAddress.getLocalHost().getHostAddress() + ":52369/Hello";
            Remote lRemote = Naming.lookup(url);
            IConfiguration c = (IConfiguration) lRemote;
            String[] d = c.getCustomers();
            listaUczestnikow.setText("");
            for(int i=0;i<d.length;i++){
                listaUczestnikow.append((i+1) +" " + d[i]);
                listaUczestnikow.append("\n");
            }

        } catch (Exception aInE) {
            System.out.println(aInE);
        }
    }

}
