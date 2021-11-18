package com.example.newsapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class Mainfield extends AppCompatActivity {
    TabLayout tablayout;
    TabItem sports, home, entertainment, technology;
    Adapter pageradapter;
    Toolbar ntoolbar;

    String api = "2e81c3e3af3144b9984262ce39199968";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainfield);
        ntoolbar = findViewById(R.id.toolbar);
        setSupportActionBar(ntoolbar);

        sports = findViewById(R.id.sports);
        home = findViewById(R.id.home);
        entertainment = findViewById(R.id.entertainment);
        technology = findViewById(R.id.technoligy);
        ViewPager view = findViewById(R.id.containerfragment);
        tablayout = findViewById(R.id.below);
        pageradapter = new Adapter(getSupportFragmentManager(), 6);
        view.setAdapter(pageradapter);

        tablayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                view.setCurrentItem(tab.getPosition());
                if (tab.getPosition() == 0 || tab.getPosition() == 1 || tab.getPosition() == 2 || tab.getPosition() == 3|| tab.getPosition() ==4|| tab.getPosition()==5) {


                    pageradapter.notifyDataSetChanged();
                }
            }


            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        view.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tablayout));
    }
}

