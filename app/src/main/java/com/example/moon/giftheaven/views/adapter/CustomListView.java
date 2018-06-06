package com.example.moon.giftheaven.views.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.moon.giftheaven.R;
import com.example.moon.giftheaven.views.activities.gift_detail;

/**
 * Created by moon on 5/2/2018.
 */

public class CustomListView extends BaseAdapter implements View.OnClickListener {


    Context c;

    public String[] gift_names = {"Charm Bracelet                    ", "Coffee Mug                           ", "Bracelet                                 ", "Vase                                       ", "Lamp                                      ", "Vase                                       "};
    public String[] desc = {"Rs.500", "Rs.700", "Rs.1000", "Rs.1000", "Rs.500", "Rs.600"};
    public int index;
    public Integer[] imgid = {R.drawable.charm_brac, R.drawable.coffee_mug, R.drawable.sc, R.drawable.charlie_red, R.drawable.keyring, R.drawable.vase};

    public CustomListView(Context ctx) {

        this.c = ctx;
    }

    @Override
    public int getCount() {
        return gift_names.length;
    }

    @Override
    public Object getItem(int pos) {
        return gift_names[pos];
    }

    @Override
    public long getItemId(int pos) {
        return pos;
    }

    @Override
    public View getView(int pos, View convertview, ViewGroup viewGroup) {
        if (convertview == null) {
            LayoutInflater inflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertview = inflater.inflate(R.layout.layout, null);

        }

        //get view
        TextView nametxt = (TextView) convertview.findViewById(R.id.text1);
        TextView pricetxt = (TextView) convertview.findViewById(R.id.text_d1);
        TextView link = (TextView) convertview.findViewById(R.id.text_link);

        ImageView img = (ImageView) convertview.findViewById(R.id.img1);

        //set data
        index=pos;
        nametxt.setText(gift_names[pos]);
        pricetxt.setText(desc[pos]);
        link.setOnClickListener(this);
        img.setImageResource(imgid[pos]);

        return convertview;
    }


    @Override
    public void onClick(View view) {
        Intent intent = new Intent(c, gift_detail.class);
        intent.putExtra("Position", index);
        c.startActivity(intent);
    }
}