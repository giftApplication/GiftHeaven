package com.example.moon.giftheaven.views.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.moon.giftheaven.R;

/**
 * Created by Asad on 6/6/2018.
 */


public class list_view_adapter extends ArrayAdapter<String>
{

    Activity context;
    int[] imgs;
    String[] myTitles;
    public list_view_adapter(Activity c , String[] titles, int[] images){
        super(c, R.layout.layout_on_list,R.id.text,titles);
        //setRequestedOrientation( ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        this.context=c;
        this.imgs=images;
        this.myTitles=titles;
    }




    @Override
    public View getView(int position, View view, ViewGroup parent){
        LayoutInflater layout_inflator =(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row=layout_inflator.inflate(R. layout.layout_on_list,parent,false);

        ImageView images = (ImageView) row.findViewById(R.id.icon);
        TextView myTitle=(TextView) row.findViewById(R.id.text);

        images.setImageResource(imgs[position]);
        myTitle.setText(myTitles[position]);
        return row;

    }

}
