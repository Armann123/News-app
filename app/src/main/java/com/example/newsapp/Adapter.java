package com.example.newsapp;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class Adapter extends FragmentPagerAdapter {

    int tabnumber;

    public Adapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);

        tabnumber = behavior;
    }


    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new HomeClass();


            case 1:
                return new SportsClass();

            case 2:
                return new TechnologyClass();

            case 3:
                return new Entertainmentclass();

            case 4:
                return new ScienceClass();

            case 5:
                return  new Business();





            default:
                return null;

        }
    }


    @Override
    public int getCount() {

        return tabnumber;
    }
}


