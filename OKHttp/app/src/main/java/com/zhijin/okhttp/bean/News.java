package com.zhijin.okhttp.bean;

/**
 * Created by hpc on 2017/3/2.
 */

public class News {
    public String title;
    public String date;
    public String icon;
    public String author;
    public String url;

    public News() {
    }

    public News(String author, String title, String icon, String date, String url) {
        this.author = author;
        this.title = title;
        this.icon = icon;
        this.date = date;
        this.url = url;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public String getIcon() {
        return icon;
    }

    public String getDate() {
        return date;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}
