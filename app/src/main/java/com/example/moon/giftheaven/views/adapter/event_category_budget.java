package com.example.moon.giftheaven.views.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.moon.giftheaven.views.fragments.FragmentBudget;
import com.example.moon.giftheaven.views.fragments.FragmentCategory;
import com.example.moon.giftheaven.views.fragments.FragmentEvent;

/**
 * Created by Asad on 6/6/2018.
 */
public class event_category_budget extends FragmentPagerAdapter {
    int fragments= 3;
    public event_category_budget(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment current_frag= null;
        if(position==0)
            current_frag= new FragmentEvent();

        else if(position==1)
            current_frag= new FragmentCategory();

        else if(position==2)
            current_frag= new FragmentBudget();

        return current_frag;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if(position==0)
            return "Event";
        else if(position==1)
            return "Category";
        else if(position==2)
            return "Budget";
        return super.getPageTitle(position);
    }

    @Override
    public int getCount() {
        return fragments;
    }



}

