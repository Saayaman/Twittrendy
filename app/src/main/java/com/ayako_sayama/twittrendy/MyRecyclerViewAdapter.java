package com.ayako_sayama.twittrendy;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by ayako_sayama on 2017-03-14.
 */

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyViewHolder> {

    private ArrayList<String> arrayList;
    private Context context;

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater mInflater = LayoutInflater.from(parent.getContext());

        ViewGroup mainGroup = (ViewGroup) mInflater.inflate(
                R.layout.list_view, parent, false);
        MyViewHolder mainHolder = new MyViewHolder(mainGroup) {
            @Override
            public String toString() {
                return super.toString();
            }
        };

        return mainHolder;
    }

    public MyRecyclerViewAdapter(Context context,
                                ArrayList<String> arrayList) {
        this.context = context;
        this.arrayList = arrayList;

    }


    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        final MyViewHolder mainHolder = (MyViewHolder) holder;
        //Setting text over textview
        mainHolder.user.setText(arrayList.get(position));
        mainHolder.date.setText(arrayList.get(position));
        mainHolder.paragraph.setText(arrayList.get(position));

        //      mainHolder.image.setImageAlpha(arrayList.get(position));
        //      mainHolder.icon.setIm(arrayList.get(position));

    }

    @Override
    public int getItemCount() {
        return (null != arrayList ? arrayList.size() :0 );
    }
}
