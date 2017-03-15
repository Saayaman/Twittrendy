package com.ayako_sayama.twittrendy;

/**
 * Created by ayako_sayama on 2017-03-14.
 */

public class Tab {

    private int id;
    private String tabName;
    private String hashTags;

    public Tab(String tabName, String hashTags) {
        super();
        this.tabName = tabName;
        this.hashTags = hashTags;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTabName() {
        return tabName;
    }

    public void setTabName(String tabName) {
        this.tabName = tabName;
    }

    public String getHashTags() {
        return hashTags;
    }

    public void setHashTags(String hashTags) {
        this.hashTags = hashTags;
    }
}
