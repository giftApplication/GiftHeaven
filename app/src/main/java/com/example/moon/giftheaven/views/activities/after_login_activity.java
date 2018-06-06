package com.example.moon.giftheaven.views.activities;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.moon.giftheaven.R;
import com.example.moon.giftheaven.views.adapter.event_category_budget;

public class after_login_activity extends AppCompatActivity {
    event_category_budget adapter ;
    static public ViewPager pager1;

    String title;
    Toolbar myToolbar;

    MenuItem prevItem;

    BottomNavigationView main_nav;

    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.after_login_activity);

        pager1 = findViewById(R.id.pager1);
        adapter= new event_category_budget(getSupportFragmentManager());
        pager1.setAdapter(adapter);

        main_nav = findViewById(R.id.main_nav);
        main_nav.setOnNavigationItemSelectedListener(nav);

        myToolbar = (Toolbar) findViewById(R.id.mytoolbar);
        myToolbar.setTitle("");
        setSupportActionBar(myToolbar);



        myToolbar.setNavigationIcon(R.mipmap.back);
        myToolbar.setNavigationOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent back_intent = new Intent(getApplicationContext(),Activity1.class);
                        startActivity(back_intent);
                        finish();
                    }
                }
        );


        pager1.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                System.out.println("previtem" + prevItem);
                if (prevItem != null) {
                    prevItem.setChecked(false);
                }
                else
                {
                    main_nav.getMenu().getItem(0).setChecked(false);
                }

                main_nav.getMenu().getItem(position).setChecked(true);
                prevItem =  main_nav.getMenu().getItem(position);
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
                    android.support.v4.app.Fragment frag = null;

                    switch (item.getItemId()) {
                        case R.id.nav_event:
                            //frag = new login_Fragment();
                            title= (String) adapter.getPageTitle(0);
                            pager1.setCurrentItem(0);
                            break;
                        case R.id.nav_category:
                            // frag = new Registor_Fragment();
                            title= (String) adapter.getPageTitle(1);
                            pager1.setCurrentItem(1);
                            break;
                        case R.id.nav_budget:
                            // frag = new Registor_Fragment();
                            title= (String) adapter.getPageTitle(2);
                            pager1.setCurrentItem(2);
                            break;

                    }
                    return true;

                }
            };

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.toolbar_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

}
