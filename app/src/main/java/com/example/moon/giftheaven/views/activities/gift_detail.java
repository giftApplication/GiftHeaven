package com.example.moon.giftheaven.views.activities;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.moon.giftheaven.R;
import com.example.moon.giftheaven.models.Gift;
import com.example.moon.giftheaven.views.adapter.CustomListView;

import java.util.ArrayList;


public class gift_detail extends AppCompatActivity {
    int pos;

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
        final CustomListView adapter=new CustomListView(this);
        Intent intent=getIntent();
        pos=intent.getExtras().getInt("Position");
        System.out.println("index_other" + pos);


        ImageView img=(ImageView) findViewById(R.id.img_gift);
         TextView name=(TextView) findViewById(R.id.text1_1);
         TextView price=(TextView) findViewById(R.id.text_d1_1);
        TextView description=(TextView) findViewById(R.id.text_d1_3);

        Cursor cursor = main_activity.sqlLiteHelper.get_data_by_ID(pos);

        if(cursor!=null) {
            System.out.println(cursor.getInt( 0 ));
          //  if(cursor.moveToFirst()) {
                img.setImageResource(cursor.getInt(3));
                //cursor.get
                Toast.makeText(this,"position is " + pos,Toast.LENGTH_LONG);
                name.setText("Name:   " + cursor.getString(1));
                price.setText("Price:   " + cursor.getString(2));
                description.setText(cursor.getString( 7) );
                Toast.makeText(this, cursor.getInt(1)+cursor.getInt(2)+cursor.getInt(3),Toast.LENGTH_LONG);
          //  }
        }

        cursor.close();

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
