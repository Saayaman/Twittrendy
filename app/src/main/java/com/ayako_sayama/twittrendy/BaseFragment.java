package com.ayako_sayama.twittrendy;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.twitter.sdk.android.tweetui.SearchTimeline;
import com.twitter.sdk.android.tweetui.TweetTimelineListAdapter;


public class BaseFragment extends Fragment{

    private ListView mTimeLineTweetsList = null;

    private View view;
    private String title;//String for tab title


    public static BaseFragment getInstance(String title) {
        BaseFragment fragment = new BaseFragment();
        Bundle bundle = new Bundle();
        bundle.putString("title", title);
        fragment.setArguments(bundle);

        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        this.title = getArguments().getString("title");

        view = inflater.inflate(R.layout.fragment_trends,container,false);
        mTimeLineTweetsList = (ListView)  view.findViewById(R.id.twitterListView);

        setListView();
        return view;
    }

    private void setListView() {
        SearchTimeline searchTimeline = new SearchTimeline.Builder()
                .query("#" + title)
                .build();
        final TweetTimelineListAdapter adapter = new TweetTimelineListAdapter.Builder(getContext())
                .setTimeline(searchTimeline)
                .build();

        mTimeLineTweetsList.setAdapter(adapter);

    }


}
