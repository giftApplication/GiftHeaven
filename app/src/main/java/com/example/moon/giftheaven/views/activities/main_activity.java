package com.example.moon.giftheaven.views.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.moon.giftheaven.R;
import com.example.moon.giftheaven.views.adapter.CustomListView;


public class main_activity extends AppCompatActivity {
    ListView lst;
    TextView view_details ;
    Toolbar myToolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity);

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

        CustomListView customListView=new CustomListView(this);
        lst.setAdapter(customListView);

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int pos, long id) {

                int id1 = view.getId();

                if(id1 == R.id.text_link) {
                    Intent intent = new Intent(getApplicationContext(), gift_detail.class);
                    intent.putExtra("Position", pos);
                    startActivity(intent);
                }
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.toolbar_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }
}
