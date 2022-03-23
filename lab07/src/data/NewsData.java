package data;

import java.util.Date;

public class NewsData {
    public NewsData(String news, Date date, int id){
        this.news =news;
        this.date= date;
        this.id= id;
    }
    public String news;
    public Date date;
    public int id;
}
