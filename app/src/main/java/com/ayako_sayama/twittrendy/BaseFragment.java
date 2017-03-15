package com.ayako_sayama.twittrendy;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


public class BaseFragment extends Fragment {

    RecyclerView recyclerView;
    private View view;

    private String title;//String for tab title

//    private int mPage;
    public static final String ARG_PAGE = "ARG_PAGE";

    public BaseFragment() {
    }

    public BaseFragment(String title) {
        this.title = title;//Setting tab title
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_trends,container,false);

        setRecyclerView();
        return view;
    }

    private void setRecyclerView() {

        recyclerView = (RecyclerView) view
                .findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView
                .setLayoutManager(new LinearLayoutManager(getActivity()));//Linear Items


        ArrayList<String> arrayList = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            arrayList.add(title+" Items " + i);//Adding items to recycler view
        }
        MyRecyclerViewAdapter adapter = new MyRecyclerViewAdapter(getActivity(), arrayList);
        recyclerView.setAdapter(adapter);// set adapter on recyclerview

    }

}
