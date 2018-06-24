package com.example.moon.giftheaven.views.activities;

import android.app.Dialog;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.AssetManager;
import android.database.Cursor;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.moon.giftheaven.R;
import com.example.moon.giftheaven.models.Gift;
import com.example.moon.giftheaven.models.Gift_to_DB;
import com.example.moon.giftheaven.models.GiftsData;
import com.example.moon.giftheaven.models.SQLLiteHelper;
import com.example.moon.giftheaven.models.parse_json;
import com.example.moon.giftheaven.views.adapter.CustomListView;
import com.example.moon.giftheaven.views.fragments.FragmentBudget;
import com.example.moon.giftheaven.views.fragments.FragmentCategory;
import com.example.moon.giftheaven.views.fragments.FragmentEvent;

import java.io.InputStream;
import java.util.ArrayList;

import static com.example.moon.giftheaven.views.adapter.CustomListView.desc;
import static com.example.moon.giftheaven.views.adapter.CustomListView.gift_names;
import static com.example.moon.giftheaven.views.adapter.CustomListView.imgid;


public class main_activity extends AppCompatActivity {
    public static ListView lst;
    TextView view_details ;
    Toolbar myToolbar;
    Cursor cursor;
    public  static ArrayList<String> name;
    public static int index;
    public static SQLLiteHelper sqlLiteHelper;
    public static ArrayList<String> link_ = new ArrayList<>(  );
    ArrayList<Gift> list;
    Gift_to_DB add_gifts;
    CustomListView customListView;
    Dialog dialogf;
    Dialog dialogr;

    //=============================================================
    AssetManager assertManager;
    InputStream input;
    ArrayList<GiftsData> gifts_array= new ArrayList<>();
    parse_json obj = new parse_json();
    public static ArrayList<String> cat = new ArrayList<>();
    public static  ArrayList<String> eve = new ArrayList<>();
    public static ArrayList<String> bud = new ArrayList<>();
    public static ArrayList<String> name_ = new ArrayList<>();
    public static ArrayList<String> price = new ArrayList<>();
    public static ArrayList<String> descrip = new ArrayList<>();
    public static ArrayList<String> img_id = new ArrayList<>( );
    public static ArrayList<String> link = new ArrayList<>( );

    //================================================================


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity);
        setRequestedOrientation( ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        dialogf = new Dialog(this);
        dialogr = new Dialog(this);

        //==============================================================
        try {
            assertManager = getResources().getAssets();
            input = assertManager.open("gifts.json");
            gifts_array = obj.get_JSON(input);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(gifts_array.size());

        for(int i=0;i<gifts_array.size();i++) {
            cat.add( gifts_array.get( i ).getCategory() );
            eve.add( gifts_array.get( i ).getEvent() );
            bud.add(gifts_array.get( i ).getBudget());
            name_.add(gifts_array.get( i ).getName());
            price.add(gifts_array.get( i ).getPrice());
            descrip.add(gifts_array.get( i ).getDescription());
            img_id.add(gifts_array.get(i).getImg());
            link.add(gifts_array.get( i ).getLink());
        }

        for(int i=0;i<gifts_array.size();i++) {
            System.out.println( cat.get( i ) + " +" + eve.get(i) +" " +  bud.get(i) );
            System.out.println( name_.get( i ) + " +" + price.get(i) +" " +  descrip.get(i));
            System.out.println( link.get( i ));

        }
        //==========================================================

        sqlLiteHelper = new SQLLiteHelper(this,"GiftDB.sqlite",null,1);
        add_gifts = new Gift_to_DB();


        myToolbar = findViewById(R.id.mytoolbar);
        myToolbar.setTitle("");
        setSupportActionBar(myToolbar);

        myToolbar.setNavigationIcon(R.mipmap.back);
        myToolbar.setNavigationOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Intent back_intent = new Intent(getApplicationContext(),after_login_activity.class);
                        startActivity(back_intent);
                        finish();

                    }
                }
        );

        lst = (ListView) findViewById(R.id.list1);
        view_details=(TextView) findViewById(R.id.text_link);

        list = new ArrayList<>();
        customListView=new CustomListView(this,R.layout.layout,list);
        lst.setAdapter(customListView);

        // get data from DB

         cursor = main_activity.sqlLiteHelper.getData("SELECT * FROM GIFT");
        list.clear();
        System.out.println("event " + FragmentEvent.event);
        System.out.println("category  " + FragmentCategory.category);
        System.out.println("event " + FragmentBudget.Budget);
        int i=0;
        name= new ArrayList<>(  );
        while(cursor.moveToNext())
        {
            System.out.println("event" + cursor.getString( 4 ));
            System.out.println("cat" + cursor.getString( 5 ));
            System.out.println("bud" + cursor.getString( 6 ));
            System.out.println("------------------------");
            if(FragmentBudget.Budget.size()==2) {
                if (FragmentEvent.event.equals( cursor.getString( 4 ) ) &&
                        FragmentCategory.category.equals( cursor.getString( 5 ) )
                        && (Integer.parseInt( cursor.getString( 6 ) ) >= Integer.parseInt( FragmentBudget.Budget.get( 0 ) )
                        && Integer.parseInt( cursor.getString( 6 ) ) <= (Integer.parseInt( FragmentBudget.Budget.get( 1 ) )))) {
                    int id = cursor.getInt( 0 );
                    index = id;
                    name.add( cursor.getString( 1 ) );
                    String price = cursor.getString( 2 );
                    final int resourceId = getResources().getIdentifier(cursor.getString( 3 ), "drawable",getPackageName());
                    Drawable image = getResources().getDrawable(resourceId);
                    list.add( new Gift( name.get( i ), price, id, image,link.get( i ) ) );
                    link_.add(link.get( i ));
                    i++;
                }
            }
            else if(FragmentBudget.Budget.size()== 1) {
                if (FragmentEvent.event.equals( cursor.getString( 4 ) ) &&
                        FragmentCategory.category.equals( cursor.getString( 5 ) )
                        && (Integer.parseInt( cursor.getString( 6 ) ) >= Integer.parseInt( FragmentBudget.Budget.get( 0 )))) {
                    int id = cursor.getInt( 0 );
                    index = id;
                    name.add( cursor.getString( 1 ) );
                    String price = cursor.getString( 2 );
                    final int resourceId = getResources().getIdentifier(cursor.getString( 3 ), "drawable",getPackageName());
                    Drawable image = getResources().getDrawable(resourceId);
                    list.add( new Gift( name.get( i ), price, id, image, link.get(i) ) );
                    link_.add(link.get( i ));
                    i++;
                }
            }

          //  Toast.makeText(this,cursor.getString(4) + "" +cursor.getString(5)+""+cursor.getString(6)+"" + cursor.getString(7),Toast.LENGTH_LONG);



        }
        System.out.println("list size" + list.size());
        customListView.notifyDataSetChanged();

       lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
           public void onItemClick(AdapterView<?> adapterView, View view, int pos, long id) {

               index = pos;
               /* int id1 = view.getId();

                if(id1 == R.id.text_link) {
                    Intent intent = new Intent(getApplicationContext(), gift_detail.class);
                    intent.putExtra("Position", pos);
                    startActivity(intent);
                }
            }*/
               //});

               }
           });
       }

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