package pakiecik;

import interfejsy.INotification;
import interfejsy.IRegistration;

import java.net.InetAddress;
import java.rmi.Naming;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import javax.swing.*;
import java.util.Date;

public class Customer extends UnicastRemoteObject implements INotification {
JTextArea text1;
    public Customer(JTextArea text1) throws RemoteException {
        this.text1=text1;


    }


    public void notify(String message,Date data) throws RemoteException {
        if(message.equals(".clean")){
            text1.setText("");
            return;
        }
        text1.append("\n");
        text1.append(message);
        text1.append("\n");
        text1.append(String.valueOf(data));
        text1.append("\n");
        text1.append("\n");

    }


    public void register(String pole) {
        try {

                String url = "rmi://" + InetAddress.getLocalHost().getHostAddress() + ":52369/Hello";
                Remote lRemote = Naming.lookup(url);
                IRegistration r = (IRegistration) lRemote;

                Customer c = new Customer(text1);

                r.register(pole, c);
            } catch (Exception aInE)
        {
            System.out.println(aInE);
        }
    }

    public void unregister(String pole){
        try {

            String url = "rmi://" + InetAddress.getLocalHost().getHostAddress() + ":52369/Hello";
            Remote lRemote = Naming.lookup(url);
            IRegistration r = (IRegistration) lRemote;

            r.unregister(pole);
        } catch (Exception aInE)
        {
            System.out.println(aInE);
        }
    }


}
