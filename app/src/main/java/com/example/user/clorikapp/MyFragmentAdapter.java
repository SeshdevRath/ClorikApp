package com.example.user.clorikapp;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by User on 13-07-2016.
 */
public class MyFragmentAdapter extends FragmentStatePagerAdapter {
    private static final int ITEM_COUNT = 2;
    private String[] tabName = {"TAB ONE","TAB TWO"};

    public MyFragmentAdapter(FragmentManager fm)
    {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;

        if(position == 0)
            fragment = new FragmentA();
        else if(position == 1)
            fragment = new FragmentB();

        return fragment;
    }

    @Override
    public int getCount() {
        return ITEM_COUNT;
    }

    @Override
    public CharSequence getPageTitle(int position) {
       return tabName[position];
    }
}
