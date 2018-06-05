package com.example.moon.giftheaven.views.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.moon.giftheaven.R;

import static com.example.moon.giftheaven.views.activities.Activity1.pager;

public class register_fragment extends Fragment {

    Button register;
    EditText pass;
    public register_fragment()
    {

    }
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_register_fragment, container, false);
        // root.setBackgroundColor(getResources().getColor(R.color.colorAccent));
        System.out.println("Register Fragment");

        register = (Button)root.findViewById(R.id.reg_btn);
        pass=(EditText)root.findViewById(R.id.password);
        pass.setHint("Password");
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login_Fragment login_now  = new login_Fragment();
                pager.setCurrentItem(0);
                //   getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frag,login_now).addToBackStack(null).commit();
            }
        });


        return root;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

}
