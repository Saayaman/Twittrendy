package com.ayako_sayama.twittrendy;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;

import com.ayako_sayama.twittrendy.utils.Debug;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static ViewPager viewPager;
    private static TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Debug.Log("MainActivity: This is Read!!!");

        ArrayList<Article> articles = null;


        viewPager = (ViewPager)findViewById(R.id.myViewPager);
        viewPagerSetup();

        tabLayout = (TabLayout)findViewById(R.id.tablayout);
        tabLayout.setupWithViewPager(viewPager);

    }

    private void viewPagerSetup() {

        MyPageAdapter myPageAdapter = new MyPageAdapter(getSupportFragmentManager());
        myPageAdapter.addFrag(new BaseFragment("ANDROID"), "ANDROID");
        myPageAdapter.addFrag(new BaseFragment("iOS"), "iOS");
        myPageAdapter.addFrag(new BaseFragment("WINDOWS"), "WINDOWS");

        viewPager.setAdapter(myPageAdapter);


    }

    private List<Article> myArticles() {
        List<Article> lists = new ArrayList<>();
        lists.add(new Article("Icon1","@Saayaman","Dec 25,2000","This is the twitter comment","image.png"));
        lists.add(new Article("Icon2","@Hondaman","Dec 25,2000","This is the twitter comment","image2.png"));
        lists.add(new Article("Icon3","@Masaman","Dec 25,2000","This is the twitter comment","image3.png"));
        lists.add(new Article("Icon4","@Koman","Dec 25,2000","This is the twitter comment","image3.png"));
        lists.add(new Article("Icon5","@Mitchman","Dec 25,2000","This is the twitter comment","image3.png"));
        return lists;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }
}
