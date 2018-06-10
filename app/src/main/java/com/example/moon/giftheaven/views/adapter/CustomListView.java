package com.example.moon.giftheaven.views.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.moon.giftheaven.R;
import com.example.moon.giftheaven.models.Gift;
import com.example.moon.giftheaven.views.activities.gift_detail;
import com.example.moon.giftheaven.views.activities.main_activity;

import java.util.ArrayList;

/**
 * Created by moon on 5/2/2018.
 */

public class CustomListView extends BaseAdapter implements View.OnClickListener {


    Context c;
    Gift gift;
    public  static String[] gift_names = {"Charm Bracelet                    ", "Coffee Mug                           ", "Bracelet                                 ", "Vase                                       ", "Lamp                                      ", "Vase                                       "};
    public static  String[] desc = {"Rs.500", "Rs.1000", "Rs.2000", "Rs.2500", "Rs.3000", "Rs.1500"};
   // public int index;
    public static String[] description={"Description_1","Description_2","Description_3","Description_4","Description_5","Description_6"};
    public static Integer[] imgid = {R.drawable.charm_brac, R.drawable.coffee_mug, R.drawable.sc, R.drawable.charlie_red, R.drawable.keyring, R.drawable.vase};
    public static String[] events_array={"Wedding","Birthday","Wedding","Birthday","Engagement","New Year"};
    public static String[] category_array={"Female","Kids","Male","Kids","Male","Female"};
    public static String[] budget_array={"500","1000","2000","2500","3000","1500"};

    ArrayList<Gift> giftlist = new ArrayList<>();


    public CustomListView(Context ctx) {
        this.c = ctx;
    }

    public CustomListView(Context c, int index, ArrayList<Gift> giftlist) {
        this.c = c;
       // this.index = index;
        this.giftlist = giftlist;
    }

    @Override
    public int getCount() {
        return  giftlist.size();//gift_names.length;
    }

    @Override
    public Object getItem(int pos) {
        return  giftlist.get(pos);//gift_names[pos];
    }

    @Override
    public long getItemId(int pos) {
        return pos;
    }


    @Override
    public View getView(int pos, View convertview, ViewGroup viewGroup) {
        View_holer view_holer = new View_holer();
       /// index=pos;
        //get view
        //final int position = listView.getPositionForView(parentRow);
       // System.out.println("pos=" + pos);


        if (convertview == null) {
            LayoutInflater inflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertview = inflater.inflate(R.layout.layout, null);
            //index= pos;
            view_holer.nametxt=(TextView) convertview.findViewById(R.id.text1);
            view_holer.pricetxt = (TextView) convertview.findViewById(R.id.text_d1);
            view_holer.link = (TextView) convertview.findViewById(R.id.text_link);
            view_holer.img = (ImageView) convertview.findViewById(R.id.img1);
            convertview.setTag(view_holer);

        }
        else
            view_holer=(View_holer) convertview.getTag();


        //set data

        gift = giftlist.get(pos);

        view_holer.pricetxt.setText(gift.getPrice());
        //System.out.println("gift price" + gift.getPrice());
        view_holer.nametxt.setText(gift.getName());
        view_holer.link.setOnClickListener(this);
        view_holer.img.setImageResource(gift.getImage());
        /*view_holer.nametxt.setText(gift_names[pos]);
        view_holer.pricetxt.setText(desc[pos]);
        view_holer.link.setOnClickListener(this);
        view_holer.img.setImageResource(imgid[pos]);*/

        return convertview;
    }



    @Override
    public void onClick(View view) {
        Intent intent = new Intent(c, gift_detail.class);
        final int position = main_activity.lst.getPositionForView(view);
        //System.out.println("Position value " + position);
        intent.putExtra("Position", position);
        c.startActivity(intent);
    }
}