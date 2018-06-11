package com.example.moon.giftheaven.views.activities;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.moon.giftheaven.R;
import com.example.moon.giftheaven.views.adapter.event_category_budget;
import com.example.moon.giftheaven.views.fragments.LockViewpager;
import com.example.moon.giftheaven.views.fragments.RatingActivity;

public class after_login_activity extends AppCompatActivity {
    event_category_budget adapter;
    static public LockViewpager pager1;
    /*********************************/
    Dialog dialogf;
    Dialog dialogr;
    String title;
    Toolbar myToolbar;
    static public int check;
    MenuItem prevItem;
    BottomNavigationView main_nav;

    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.after_login_activity);
        check = 0;
/**********/
        dialogf = new Dialog(this);
        dialogr = new Dialog(this);
        pager1 = findViewById(R.id.pager1);
        pager1.setSwipeable(false);
        // pager1.setEnabled(false);

        adapter = new event_category_budget(getSupportFragmentManager());
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
                        Intent back_intent = new Intent(getApplicationContext(), Activity1.class);
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
                } else {
                    main_nav.getMenu().getItem(0).setChecked(false);
                }

                main_nav.getMenu().getItem(position).setChecked(true);
                prevItem = main_nav.getMenu().getItem(position);
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
                    if (check == 0) {
                        pager1.setCurrentItem(0);
                        switch (item.getItemId()) {
                            case R.id.nav_event:
                                //  main_nav.setItemTextColor(ColorStateList.valueOf(Integer.parseInt("#601a36")));
                                //frag = new login_Fragment();
                                title = (String) adapter.getPageTitle(0);
                                pager1.setCurrentItem(0);
                                break;
                            case R.id.nav_category:
                            case R.id.nav_budget:
                                // main_nav.setItemTextColor(ColorStateList.valueOf(Color.GRAY));
                                //main_nav.setItemIconTintList(ColorStateList.valueOf(Color.GRAY));
                                Toast.makeText(getApplicationContext(), "Select event first", Toast.LENGTH_LONG).show();
                                break;

                        }
                    }
                    if (check == 1) {
                        switch (item.getItemId()) {
                            case R.id.nav_event:
                                //frag = new login_Fragment();
                                title = (String) adapter.getPageTitle(0);
                                pager1.setCurrentItem(0);
                                break;
                            case R.id.nav_category:
                                // frag = new Registor_Fragment();
                                title = (String) adapter.getPageTitle(1);
                                pager1.setCurrentItem(1);
                                break;
                            case R.id.nav_budget:
                                //main_nav.setItemTextColor(ColorStateList.valueOf(Color.GRAY));
                                //main_nav.setItemIconTintList(ColorStateList.valueOf(Color.GRAY));
                                Toast.makeText(getApplicationContext(), "Kindly select Category", Toast.LENGTH_LONG).show();
                                break;

                        }
                    }

                    if (check == 2) {
                        switch (item.getItemId()) {
                            case R.id.nav_event:
                                //frag = new login_Fragment();
                                title = (String) adapter.getPageTitle(0);
                                pager1.setCurrentItem(0);
                                break;
                            case R.id.nav_category:
                                // frag = new Registor_Fragment();
                                title = (String) adapter.getPageTitle(1);
                                pager1.setCurrentItem(1);
                                break;
                            case R.id.nav_budget:
                                // frag = new Registor_Fragment();
                                title = (String) adapter.getPageTitle(2);
                                pager1.setCurrentItem(2);
                                break;

                        }
                    }
                    return true;
                }
            };


    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.toolbar_menu,menu);
        return super.onCreateOptionsMenu(menu);

    }
    public  boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        //menu item handling

        if (id == R.id.feedback) {
            dialogf.setContentView(R.layout.feedback);
            dialogf.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
            dialogf.show();
            Button btn_submit = dialogf.findViewById(R.id.btn_submit);
            btn_submit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialogf.dismiss();

                }

            });



        }
        if (id == R.id.rate) {
            Toast.makeText(this, "Rate us ", Toast.LENGTH_SHORT).show();
            dialogr.setContentView(R.layout.activity_rating);
            dialogr.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
            dialogr.show();
            Button btn_rate = dialogr.findViewById(R.id.btn_rate);
              btn_rate.setOnClickListener(new View.OnClickListener() {
                                              @Override
                                              public void onClick(View v) {
                                                  dialogr.dismiss();

                                              }

                                          });
                                      }





           /* Intent intent=new Intent(this,SmileyRating.class);
           startActivity(intent);*/
           // Intent rintent = new Intent(this, RatingActivity.class);
            //startActivity(rintent);

           /* try {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market:// details?id=" + getPackageName())));
            } catch (ActivityNotFoundException e) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://play.google.com/store/apps/details?=" + getPackageName())));

            }*/


        if (id == R.id.share) {
            Intent myIntent = new Intent(Intent.ACTION_SEND);
            myIntent.setType("text/plain");
            String shareBody = "Your Body here";
            String shareSub = "Your subject here";
            myIntent.putExtra(Intent.EXTRA_SUBJECT, shareSub);
            myIntent.putExtra(Intent.EXTRA_TEXT, shareBody);
            startActivity(Intent.createChooser(myIntent, "Share using"));


            Toast.makeText(this, "Share", Toast.LENGTH_SHORT).show();

        }
        if (id == R.id.logout) {
            Intent intent = new Intent(this, Activity1.class);
            startActivity(intent);

        }
        return super.onOptionsItemSelected(item);
    }

}
