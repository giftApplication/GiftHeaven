package com.example.moon.giftheaven.views.activities;

import android.app.Dialog;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.AssetManager;
import android.database.Cursor;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.moon.giftheaven.R;
import com.example.moon.giftheaven.models.Gift;
import com.example.moon.giftheaven.models.GiftsData;
import com.example.moon.giftheaven.models.parse_json;
import com.example.moon.giftheaven.views.adapter.CustomListView;
import com.squareup.picasso.Picasso;

import java.io.InputStream;
import java.util.ArrayList;

import static com.example.moon.giftheaven.views.activities.main_activity.link_;


public class gift_detail extends AppCompatActivity {
    int pos;
    Dialog dialogf;
    Dialog dialogr;


    Toolbar myToolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gift_detail);

        setRequestedOrientation( ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        dialogf = new Dialog(this);
        dialogr = new Dialog(this);



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

        final Cursor cursor = main_activity.sqlLiteHelper.get_data_by_ID(pos,main_activity.name.get(pos));

        if(cursor!=null) {
            System.out.println("ID" + cursor.getInt( 0 ));
            System.out.println("event in gift_detail" + cursor.getInt( 4 ));
            System.out.println("cat in gift_detail" + cursor.getInt( 5 ));

            System.out.println("bud in gift_detail" + cursor.getInt( 6));
            System.out.println("img_is in  gift_detail" + cursor.getInt( 3));

            String image = cursor.getString(  3);

            //  if(cursor.moveToFirst()) {
               // img.setImageResource(cursor.getInt(3));
                //cursor.get
           // final int resourceId = getResources().getIdentifier(cursor.getString( 3 ), "drawable",getPackageName());
            //Drawable image = getResources().getDrawable(resourceId);
            //img.setImageDrawable( image );
            Picasso.get().load(image).into(img);

                name.setText("Name:   " + cursor.getString(1));
                price.setText("Price:  Rs. " + cursor.getString(2));
                description.setText(cursor.getString( 6) );

          //  }
        }



        Button btn_gift=(Button) findViewById(R.id.btn_shop);

        btn_gift.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1=new Intent(Intent.ACTION_VIEW);

               intent1.setData( Uri.parse( cursor.getString( 7 ) ));
                //  intent1.setData(Uri.parse(CustomListView.link_array));
                cursor.close();
                startActivity(intent1);

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
