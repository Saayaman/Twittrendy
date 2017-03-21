package com.ayako_sayama.twittrendy;

import com.github.gfx.android.orma.annotation.Column;
import com.github.gfx.android.orma.annotation.PrimaryKey;
import com.github.gfx.android.orma.annotation.Table;

/**
 * Created by ayako_sayama on 2017-03-14.
 */

@Table
public class Tab {


//    public Tab(String tabName, String hashTags) {
//        super();
//        this.tabName = tabName;
//        this.hashTags = hashTags;
//    }

    @PrimaryKey(autoincrement = true)
    public long id;

    @Column(indexed = true)
    public String tabName;


//    public void setId(int id) {
//        this.id = id;
//    }
}


