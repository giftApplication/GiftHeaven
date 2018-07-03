package com.example.moon.giftheaven.views.fragments;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.moon.giftheaven.R;
import com.example.moon.giftheaven.views.activities.main_activity;
import com.example.moon.giftheaven.views.adapter.list_view_adapter;
import com.kofigyan.stateprogressbar.StateProgressBar;

import java.util.ArrayList;

import static com.example.moon.giftheaven.views.activities.after_login_activity.check;
import static com.example.moon.giftheaven.views.fragments.FragmentEvent.p_bar;

/**
 * Created by Asad on 6/6/2018.
 */

public class FragmentBudget extends Fragment implements AdapterView.OnItemClickListener,View.OnClickListener {


    private list_view_adapter my_adapter;
    String[] budget_name;
    String[] descriptionData = {"Events","Budget"};
    Context context;
    public static ArrayList<String> Budget ;
    String bud;
    Dialog dialog ;
    Dialog dialog1;
    ListView list;
    int[] imgs={R.drawable.bu3,R.drawable.bu3,R.drawable.bu3,R.drawable.bu3};
    public FragmentBudget() {
        // Required empty public constructo
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        budget_name= getResources().getStringArray(R.array.Budget);


        dialog = new Dialog(getActivity());
        dialog1 = new Dialog(getActivity());
        View root = inflater.inflate(R.layout.fragment_fragment_budget, container, false);
        getActivity().setRequestedOrientation( ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);


        p_bar = (StateProgressBar) root.findViewById(R.id.p_bar);
        p_bar.setStateDescriptionData(descriptionData);

        list=(ListView)root.findViewById(R.id.list_2);

        my_adapter = new list_view_adapter(getActivity(),budget_name,imgs);
        list.setAdapter(my_adapter);
        list.setOnItemClickListener(this);
        // Inflate the layout for this fragment
        return root;


    }


    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

        Budget = new ArrayList<>();
        switch(i) {
            case 0:
                p_bar.setCurrentStateNumber(StateProgressBar.StateNumber.TWO);
                p_bar.checkStateCompleted(true);

                bud = (String) adapterView.getItemAtPosition(i);
                String[] budget=bud.split("-");

                //System.out.println("parts " + budget[0] + "& " + budget[1]);
                Budget.add( budget[0] ); Budget.add( budget[1] );

                System.out.println("parts " + Budget.get(0) + "& " + Budget.get(1));

                dialog.setContentView(R.layout.dialog_layout);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
                dialog.show();
                Button btn_yes = dialog.findViewById(R.id.btn_yes);
                Button btn_no = dialog.findViewById(R.id.btn_no);
                btn_yes.setOnClickListener(this);
                btn_no.setOnClickListener(this);
                break;
            case 1:
                p_bar.setCurrentStateNumber(StateProgressBar.StateNumber.TWO);
                p_bar.checkStateCompleted(true);

                bud = (String) adapterView.getItemAtPosition(i);
                budget=bud.split( "-" );
                Budget.add( budget[0] ); Budget.add( budget[1] );

                System.out.println("parts " + Budget.get(0) + "& " + Budget.get(1));

                dialog.setContentView(R.layout.dialog_layout);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
                dialog.show();
                Button btn_yes1 = dialog.findViewById(R.id.btn_yes);
                Button btn_no1 = dialog.findViewById(R.id.btn_no);
                btn_yes1.setOnClickListener(this);
                btn_no1.setOnClickListener(this);
                break;
            case 2:
                p_bar.setCurrentStateNumber(StateProgressBar.StateNumber.TWO);
                p_bar.checkStateCompleted(true);

                bud = (String) adapterView.getItemAtPosition(i);
                budget=bud.split( "-" );
                Budget.add( budget[0] ); Budget.add( budget[1] );

                System.out.println("parts " + Budget.get(0) + "& " + Budget.get(1));

                dialog.setContentView(R.layout.dialog_layout);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
                dialog.show();
                Button btn_yes2 = dialog.findViewById(R.id.btn_yes);
                Button btn_no2 = dialog.findViewById(R.id.btn_no);
                btn_yes2.setOnClickListener(this);
                btn_no2.setOnClickListener(this);
                break;
            case 3:
                dialog1.setContentView(R.layout.more_dialogue);
                p_bar.checkStateCompleted(true);
                dialog1.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
                dialog1.show();
                Button btn_ok = dialog1.findViewById(R.id.btn_ok);

                btn_ok.setOnClickListener(this);
                p_bar.setCurrentStateNumber(StateProgressBar.StateNumber.TWO);
                break;


        }

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_yes:
                p_bar.checkStateCompleted(true);
                Intent i = new Intent(getActivity().getApplicationContext(),main_activity.class);
                startActivity(i);
                break;
            case R.id.btn_ok:
                p_bar.checkStateCompleted(true);
                EditText range = (EditText)dialog1.findViewById(R.id.range);
                bud = range.getText().toString();
                Budget.add( bud );

                System.out.println("parts " + Budget.get(0));

                dialog1.setContentView(R.layout.dialog_layout);
                dialog1.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
                dialog1.show();

                Button btn_yes = dialog1.findViewById(R.id.btn_yes);
                Button btn_no = dialog1.findViewById(R.id.btn_no);
                btn_yes.setOnClickListener(this);
                btn_no.setOnClickListener(this);
                break;
            case R.id.btn_no:
                p_bar.setCurrentStateNumber(StateProgressBar.StateNumber.TWO);
                dialog.dismiss();
                dialog1.dismiss();
                break;
            default:
                break;
        }
        dialog.dismiss();
    }
}




