package com.example.moon.giftheaven.views.fragments;

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
import static com.example.moon.giftheaven.views.fragments.FragmentEvent.pos;

/**
 * Created by Asad on 6/6/2018.
 */

public class FragmentCategory extends Fragment implements AdapterView.OnItemClickListener {


    private list_view_adapter my_adapter;
    //ProgressBar p2;
    String[] data1 ={"Male", "Female"};
    int[] imgs1={R.drawable.o,R.drawable.tt};
    public static  String category;
    String[] category_name_1;
    String[] descriptionData={"Events","Category", "Budget"};
    String[] description;

    ListView list;
    int[] imgs={R.drawable.o,R.drawable.t,R.drawable.tt};
    public FragmentCategory() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View root = inflater.inflate(R.layout.fragment_fragment_category, container, false);
        getActivity().setRequestedOrientation( ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        list=(ListView)root.findViewById(R.id.list_1);
        if(FragmentEvent.pos==2 || FragmentEvent.pos==3) {
             description = new String[]{"Male", "Female"};
        }
        else if(FragmentEvent.pos==0 || FragmentEvent.pos==1){
            description = new String[]{"Male", "Female" ,"Kids"};
        }

        my_adapter= new list_view_adapter( getActivity(),description,imgs);

        p_bar = (StateProgressBar) root.findViewById(R.id.p_bar);
        p_bar.setStateDescriptionData(descriptionData);


        list.setAdapter(my_adapter);


        list.setOnItemClickListener(this);
        // Inflate the layout for this fragment
        return root;


    }
    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

       // System.out.println("kia_ha " + kia_hai + "" + category_name_1);
        p_bar.checkStateCompleted(true);
        category= (String)adapterView.getItemAtPosition(i);
        p_bar.setCurrentStateNumber(StateProgressBar.StateNumber.THREE);
        check = 2;
        pager1.setCurrentItem(2);

    }



}
