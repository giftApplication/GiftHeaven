package com.example.moon.giftheaven.views.fragments;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.example.moon.giftheaven.R;
import com.example.moon.giftheaven.views.adapter.list_view_adapter;
import com.kofigyan.stateprogressbar.StateProgressBar;

import static com.example.moon.giftheaven.views.fragments.FragmentEvent.p_bar;

/**
 * Created by Asad on 6/6/2018.
 */

public class FragmentBudget extends Fragment {


    private list_view_adapter my_adapter;
    String[] budget_name;
    String[] descriptionData = {"Events", "Category", "Budget"};
    Context context;
    Dialog dialog;
    Dialog dialog1;
    ListView list;
    int[] imgs = {R.drawable.bu3, R.drawable.bu3, R.drawable.bu3, R.drawable.bu3};

    public FragmentBudget() {
        // Required empty public constructo
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        budget_name = getResources().getStringArray(R.array.Budget);


        dialog = new Dialog(getActivity());
        dialog1 = new Dialog(getActivity());
        View root = inflater.inflate(R.layout.fragment_fragment_budget, container, false);

        p_bar = (StateProgressBar) root.findViewById(R.id.p_bar);
        p_bar.setStateDescriptionData(descriptionData);

        list = (ListView) root.findViewById(R.id.list_2);

        my_adapter = new list_view_adapter(getActivity(), budget_name, imgs);
        list.setAdapter(my_adapter);

        // Inflate the layout for this fragment
        return root;


    }
}



