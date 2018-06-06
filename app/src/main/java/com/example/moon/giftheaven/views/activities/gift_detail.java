package com.example.moon.giftheaven.views.activities;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.moon.giftheaven.R;
import com.example.moon.giftheaven.views.adapter.CustomListView;


public class gift_detail extends AppCompatActivity {
    int pos=0;

    Toolbar myToolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gift_detail);

        myToolbar = findViewById(R.id.mytoolbar);
        myToolbar.setTitle("");
        setSupportActionBar(myToolbar);

        myToolbar.setNavigationIcon(R.mipmap.back);
        myToolbar.setNavigationOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Intent back_intent = new Intent(getApplicationContext(),main_activity.class);
                        startActivity(back_intent);
                        finish();

                    }
                }
        );


        Intent intent=getIntent();
        pos=intent.getExtras().getInt("Position");


        final CustomListView adapter=new CustomListView(this);
        final ImageView img=(ImageView) findViewById(R.id.img_gift);
        final TextView name=(TextView) findViewById(R.id.text1_1);
        final TextView price=(TextView) findViewById(R.id.text_d1_1);



        //set data
        img.setImageResource(adapter.imgid[pos]);

        name.setText("Name:  "+adapter.gift_names[pos]);
        price.setText("Price:  "+adapter.desc[pos]);

        Button btn_gift=(Button) findViewById(R.id.btn_shop);

        btn_gift.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1=new Intent(Intent.ACTION_VIEW);
                intent1.setData(Uri.parse("https://www.giftsnideas.com/"));
                startActivity(intent1);

            }
        });

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.toolbar_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }
}
