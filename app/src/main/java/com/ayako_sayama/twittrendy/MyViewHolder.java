package com.ayako_sayama.twittrendy;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by ayako_sayama on 2017-03-14.
 */

public class MyViewHolder extends RecyclerView.ViewHolder {

//    public ImageView icon;
    public TextView user;
    public TextView date;
    public TextView paragraph;
//    public ImageView image;

    public MyViewHolder(View view) {

        super(view);

        this.user = (TextView) view.findViewById(R.id.userName);
//        this.icon = (ImageView) view.findViewById(R.id.userIcon);
//        this.image = (ImageView) view.findViewById(R.id.userImage);
        this.date = (TextView) view.findViewById(R.id.postDate);
        this.paragraph = (TextView) view.findViewById(R.id.userText);

    }
}
