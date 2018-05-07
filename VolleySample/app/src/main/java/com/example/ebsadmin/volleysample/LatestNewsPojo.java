package com.example.ebsadmin.volleysample;



import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LatestNewsPojo implements Serializable {

    @SerializedName("News")
    @Expose
    private List<News> news = null;
    @SerializedName("Message")
    @Expose
    private String message;
    @SerializedName("Status")
    @Expose
    private String status;
    @SerializedName("nid")
    @Expose
    private String nid;

    public ArrayList<News> getNews() {
        return (ArrayList<News>) news;
    }

    public void setNews(ArrayList<News> news) {
        this.news = news;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getNid() {
        return nid;
    }

    public void setNid(String nid) {
        this.nid = nid;
    }

}

