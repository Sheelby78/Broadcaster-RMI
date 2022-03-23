package data;

import interfejsy.INotification;

import java.util.ArrayList;
import java.util.List;

public class CustomerData {
    public CustomerData(String name, INotification broadcast, List<NewsData> wiadomosci){
        this.name = name;
        this.broadcast = broadcast;
    }
    public String name;
    public INotification broadcast;
    public List<NewsData> wiadomosci = new ArrayList<>();
}
