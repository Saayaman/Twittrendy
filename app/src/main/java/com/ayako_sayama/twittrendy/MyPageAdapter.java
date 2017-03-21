package com.ayako_sayama.twittrendy;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.ayako_sayama.twittrendy.utils.Debug;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ayako_sayama on 2017-03-14.
 */

public class MyPageAdapter extends FragmentPagerAdapter {

    private final List<Fragment> mFragmentList = new ArrayList<>();//fragment arraylist
    private final List<String> mFragmentTitleList = new ArrayList<>();//title arraylist

    public MyPageAdapter(FragmentManager manager) {
        super(manager);
    }

    @Override
    public Fragment getItem(int position) {
        return mFragmentList.get(position);
    }

    @Override
    public int getCount() {
        return mFragmentList.size();
    }


    //adding fragments and title method
    public void addFrag(Fragment fragment, String title) {
        Debug.Log("This is inside AddFrag method: "+title);
        mFragmentList.add(fragment);
        mFragmentTitleList.add(title);
        notifyDataSetChanged();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mFragmentTitleList.get(position);
    }
}

