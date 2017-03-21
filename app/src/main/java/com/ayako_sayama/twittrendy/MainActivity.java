package com.ayako_sayama.twittrendy;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

import com.ayako_sayama.twittrendy.utils.Debug;

public class MainActivity extends AppCompatActivity {

    private static ViewPager viewPager;
    private static TabLayout tabLayout;
    private String hashWords;
    private MyPageAdapter myPageAdapter;
    OrmaDao dao;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dao = new OrmaDao(getApplicationContext());

        Debug.Log("MainActivity: This is Read!!!");


        viewPager = (ViewPager)findViewById(R.id.myViewPager);
        viewPagerSetup();

        tabLayout = (TabLayout)findViewById(R.id.tablayout);
        tabLayout.setupWithViewPager(viewPager);

    }

    private void viewPagerSetup() {

        myPageAdapter = new MyPageAdapter(getSupportFragmentManager());

        Tab_Selector selector = dao.findAll();

//        Tab tab = new Tab();
//        Debug.Log("TAB NAME: "+ tab.tabName);
//        myPageAdapter.addFrag(BaseFragment.getInstance((tab.tabName)), (tab.tabName));

        for (Tab tab : selector) {
            Debug.Log("tabselecter"+tab.tabName);

            myPageAdapter.addFrag(BaseFragment.getInstance((tab.tabName)), (tab.tabName));
        }

        viewPager.setAdapter(myPageAdapter);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }


    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
//            case R.id.editTab:
//                editTab();
//                return true;
            case R.id.addTab:
                addTab();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

//    private void editTab() {
//
//    }

    private void addTab() {

        AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity.this);
        alertDialog.setTitle("Add Tab");
        alertDialog.setMessage("Enter keyford for #hashtag");
        final EditText input = new EditText(this);
        alertDialog.setView(input);

        alertDialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                hashWords = input.getText().toString();

                Tab tab = new Tab();
                tab.tabName = hashWords;
                dao.insert(tab);

                myPageAdapter.addFrag(BaseFragment.getInstance(hashWords), hashWords);

                dialog.cancel();
            }
        });

        alertDialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        alertDialog.show();

    }

}
