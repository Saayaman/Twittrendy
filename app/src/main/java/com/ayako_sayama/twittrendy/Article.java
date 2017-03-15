package com.ayako_sayama.twittrendy;

/**
 * Created by ayako_sayama on 2017-03-14.
 */

public class Article {

    String icon;
    String user;
    String date;
    String paragraph;
    String image;

    public Article(String icon, String user, String date, String paragraph, String image) {
        this.icon = icon;
        this.user = user;
        this.date = date;
        this.paragraph = paragraph;
        this.image = image;
    }


    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getParagraph() {
        return paragraph;
    }

    public void setParagraph(String paragraph) {
        this.paragraph = paragraph;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
