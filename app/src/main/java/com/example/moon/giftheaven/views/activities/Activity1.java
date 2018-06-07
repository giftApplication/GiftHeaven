package com.example.moon.giftheaven.views.activities;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.example.moon.giftheaven.R;
import com.example.moon.giftheaven.views.adapter.login_signUp_adapter;

public class Activity1 extends AppCompatActivity {
    login_signUp_adapter adapter;
    static public ViewPager pager;

    MenuItem prevItem;
    BottomNavigationView bottom_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity1);

        pager = findViewById(R.id.pager);

        adapter= new login_signUp_adapter(getSupportFragmentManager());
        pager.setAdapter(adapter);

        bottom_view = findViewById(R.id.bottom_view);
        bottom_view.setOnNavigationItemSelectedListener(nav);

        pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                if (prevItem != null) {
                    prevItem.setChecked(false);
                }
                else
                {
                    bottom_view.getMenu().getItem(0).setChecked(false);
                }

                bottom_view.getMenu().getItem(position).setChecked(true);
                prevItem =  bottom_view.getMenu().getItem(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }
    // set navigation
    private BottomNavigationView.OnNavigationItemSelectedListener nav =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment frag = null;

                    switch (item.getItemId()) {
                        case R.id.login:
                            //frag = new login_Fragment();
                            pager.setCurrentItem(0);
                            break;
                        case R.id.logup:
                            // frag = new Registor_Fragment();
                            pager.setCurrentItem(1);
                            break;

                    }
                    return true;

                }
            };


}

