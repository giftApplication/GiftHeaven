package com.example.moon.giftheaven.models;

import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.widget.Toast;

import com.example.moon.giftheaven.R;
import com.example.moon.giftheaven.views.activities.main_activity;
import com.example.moon.giftheaven.views.adapter.CustomListView;
import com.example.moon.giftheaven.views.fragments.FragmentBudget;
import com.example.moon.giftheaven.views.fragments.FragmentCategory;
import com.example.moon.giftheaven.views.fragments.FragmentEvent;

import java.io.ByteArrayOutputStream;

import static com.example.moon.giftheaven.R.drawable.charlie_red;

import static com.example.moon.giftheaven.views.activities.main_activity.bud;
import static com.example.moon.giftheaven.views.activities.main_activity.cat;
import static com.example.moon.giftheaven.views.activities.main_activity.descrip;
import static com.example.moon.giftheaven.views.activities.main_activity.eve;
import static com.example.moon.giftheaven.views.activities.main_activity.img_id;
import static com.example.moon.giftheaven.views.activities.main_activity.link;
import static com.example.moon.giftheaven.views.activities.main_activity.name;
import static com.example.moon.giftheaven.views.activities.main_activity.name_;
import static com.example.moon.giftheaven.views.activities.main_activity.price;
import static com.example.moon.giftheaven.views.activities.main_activity.sqlLiteHelper;

/**
 * Created by HP on 6/9/2018.
 */

public class Gift_to_DB {

    String query;


    public Gift_to_DB() {
        //DB created                            //0/                                    //  1                   //2                        //3                     //4                      //5                         //6                         //7
        query = "CREATE TABLE IF NOT EXISTS GIFT(Id INTEGER PRIMARY KEY AUTOINCREMENT, Name VARCHAR NOT NULL, Price  VARCHAR NOT NULL, Images INTEGER NOT NULL, Event VARCHAR NOT NULL, Budget VARCHAR NOT NULL , Description VARCHAR NOT NULL, Link VARCHAR)";
        main_activity.sqlLiteHelper.queryData(query);

     /*   Bitmap bitmap= BitmapFactory.decodeResource(Resources.getSystem(),charlie_red);
        ByteArrayOutputStream bos=new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, bos);
        byte[] img=bos.toByteArray();*/

//      //insert_into_DB();
        delete_from_DB();
        //insert_into_DB();
       // drop_table();
        Cursor cur =main_activity.sqlLiteHelper.getData("SELECT * FROM GIFT");
        if(!(cur.moveToNext()) || cur.equals(null) ) insert_into_DB();
    }

    private void drop_table() {
        sqlLiteHelper.drop_table_from_Db();
    }

    void insert_into_DB() {
      // int len = gift_names.length-1;
        int len = price.size()-1;
        System.out.println("Inside Insert in gift to DB");

        while(len>=0) {
           // sqlLiteHelper.insertData(gift_names[len], desc[len], imgid[len], CustomListView.description[len], CustomListView.events_array[len],CustomListView.category_array[len], CustomListView.budget_array[len],CustomListView.link_array);
            sqlLiteHelper.insertData( name_.get( len ), price.get( len ), img_id.get(len), descrip.get( len ), eve.get( len ), bud.get( len ),link.get(len));
            len--;
        }
    }


    void delete_from_DB()
    {
        sqlLiteHelper.deleteRecord();
    }
}
