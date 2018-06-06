package com.example.moon.giftheaven.views.fragments;

/**
 * Created by Asad on 6/6/2018.
 */


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
import static com.example.moon.giftheaven.views.fragments.FragmentEvent.p_bar;


import static java.lang.Thread.sleep;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentEvent extends Fragment {

    private list_view_adapter my_adapter;
    public static StateProgressBar p_bar;
    String[] descriptionData = {"Events", "Category", "Budget"};

    String[] events_name;
    ListView list;

    int[] imgs = {R.drawable.b1, R.drawable.h, R.drawable.w, R.drawable.eng_};

    public FragmentEvent() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        events_name = getResources().getStringArray(R.array.Event);
        View root = inflater.inflate(R.layout.fragment_fragment_event, container, false);

        p_bar = (StateProgressBar) root.findViewById(R.id.p_bar);
        p_bar.setStateDescriptionData(descriptionData);

        list = (ListView) root.findViewById(R.id.list);
        my_adapter = new list_view_adapter(getActivity(), events_name, imgs);

        list.setAdapter(my_adapter);

        // Inflate the layout for this fragment
        return root;


    }





}
