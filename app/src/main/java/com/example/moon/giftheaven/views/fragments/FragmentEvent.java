package com.example.moon.giftheaven.views.fragments;

/**
 * Created by Asad on 6/6/2018.
 */


import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;


import com.example.moon.giftheaven.R;
import com.example.moon.giftheaven.views.adapter.list_view_adapter;
import com.kofigyan.stateprogressbar.StateProgressBar;

import static com.example.moon.giftheaven.views.activities.after_login_activity.pager1;
import static com.example.moon.giftheaven.views.activities.after_login_activity.check;
import static com.example.moon.giftheaven.views.fragments.FragmentEvent.p_bar;


import static java.lang.Thread.sleep;


public class FragmentEvent extends Fragment implements AdapterView.OnItemClickListener {

    public list_view_adapter my_adapter;
    public static StateProgressBar p_bar;
    public static  String event;
    public static int pos;
    public static  String[] category_names;
    public static int[] imges_names;

    String[] descriptionData = {"Events", "Budget"};

    String[] events_name;
    ListView list;
    int[] imgs = {R.drawable.b1, R.drawable.h, R.drawable.w, R.drawable.cris};

    public FragmentEvent() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        events_name = getResources().getStringArray(R.array.Event);
        View root = inflater.inflate(R.layout.fragment_fragment_event, container, false);
        getActivity().setRequestedOrientation( ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);


        p_bar = (StateProgressBar) root.findViewById(R.id.p_bar);
        p_bar.setStateDescriptionData(descriptionData);

        list = (ListView) root.findViewById(R.id.list);
        my_adapter = new list_view_adapter(getActivity(), events_name, imgs);

        list.setAdapter(my_adapter);
        list.setOnItemClickListener(this);
        // Inflate the layout for this fragment
        return root;


    }


    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

        p_bar.setCurrentStateNumber(StateProgressBar.StateNumber.TWO);
        p_bar.checkStateCompleted(true);
        //p_bar.setStateDescriptionTypeface("cursive");
        event = (String) adapterView.getItemAtPosition(i);
        System.out.println("Event" + event);
      /*  if(event.equals( "Wedding" ) || event.equals( "Engagement" )) {
            System.out.println("kkia_hai in event" + kia_hai);
            kia_hai = 0;
        }
        else
            kia_hai=1;*/
       String[] category_name= getResources().getStringArray(R.array.Category);
       String[] cat = getResources().getStringArray(R.array.Cat);
        pos=i;
      if(i==2 || i==3)
      {
        //  category_names[0]="Male"; category_names[1]="Female";
         //imges_names[0]= R.drawable.o; imges_names[1]=R.drawable.tt;
            pos=i;
         //System.out.println("cat_name" + category_names[0] + category_names[1]);
          FragmentCategory fragment = new FragmentCategory();
          final Bundle bundle = new Bundle();
          bundle.putStringArray("array", cat);
          fragment.setArguments(bundle);
      }
      else if(i==0 || i==1)
      {
       //   category_names[0]="Male"; category_names[1]="Female"; category_names[2]="Kids";
        //  imges_names[0]= R.drawable.o; imges_names[1]=R.drawable.tt; imges_names[2]=R.drawable.t;
         //s System.out.println("cat_name" + category_names[0] + category_names[1]);
          FragmentCategory fragment = new FragmentCategory();
          final Bundle bundle = new Bundle();
          bundle.putStringArray("array", category_name);
          fragment.setArguments(bundle);
      }

        check= 1;
       // Intent i =
        pager1.setCurrentItem(1);


    }
}
