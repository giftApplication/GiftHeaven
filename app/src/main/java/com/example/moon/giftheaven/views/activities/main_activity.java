package com.example.moon.giftheaven.views.activities;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.moon.giftheaven.R;
import com.example.moon.giftheaven.models.Gift;
import com.example.moon.giftheaven.models.Gift_to_DB;
import com.example.moon.giftheaven.models.SQLLiteHelper;
import com.example.moon.giftheaven.views.adapter.CustomListView;
import com.example.moon.giftheaven.views.fragments.FragmentBudget;
import com.example.moon.giftheaven.views.fragments.FragmentCategory;
import com.example.moon.giftheaven.views.fragments.FragmentEvent;

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
    ArrayList<Gift> list;
    Gift_to_DB add_gifts;
    CustomListView customListView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity);

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
                    int imgId = cursor.getInt( 3 );
                    list.add( new Gift( name.get( i ), price, id, imgId ) );
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
                    int imgId = cursor.getInt( 3 );
                    list.add( new Gift( name.get( i ), price, id, imgId ) );
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
}