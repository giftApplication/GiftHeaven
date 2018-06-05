package com.example.moon.giftheaven.views.adapter;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.moon.giftheaven.views.fragments.login_Fragment;
import com.example.moon.giftheaven.views.fragments.register_fragment;


public class login_signUp_adapter extends FragmentPagerAdapter {

    int fragments= 2;

    public login_signUp_adapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment current_frag= null;
        if(position==0)
            current_frag= new login_Fragment();

        else if(position==1)
            current_frag= new register_fragment();

        return current_frag;
    }


    @Override
    public CharSequence getPageTitle(int position) {
        if(position==0)
            return "SignIn";
        else if(position==1)
            return "SignUp";
        return super.getPageTitle(position);
    }

    @Override
    public int getCount() {
        return fragments;
    }
}
