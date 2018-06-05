package com.example.moon.giftheaven.views.fragments;

import android.annotation.SuppressLint;
        import android.content.Intent;
        import android.os.Bundle;
        import android.support.annotation.Nullable;
        import android.support.v4.app.Fragment;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.Button;
import android.widget.EditText;

import com.example.moon.giftheaven.R;
import com.example.moon.giftheaven.views.activities.after_login_activity;

public class login_Fragment extends Fragment implements View.OnClickListener{

    Button login, f_login,g_login;
    EditText password;
    public void login_Fragemnt()
    {

    }
    @SuppressLint("ResourceAsColor")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root =  inflater.inflate(R.layout.fragment_login_, container, false);
        System.out.println("login Fragment");

        login = (Button)root.findViewById(R.id.login_btn);

        password=(EditText) root.findViewById(R.id.upassword);
        password.setHint("Password");

        f_login=(Button)root.findViewById(R.id.fb_login);
        g_login=(Button)root.findViewById(R.id.google_btn);

        login.setOnClickListener(this);
        f_login.setOnClickListener(this);
        g_login.setOnClickListener(this);

        return root;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public void onClick(View view) {
        Intent myIntent = new Intent(getActivity().getApplicationContext(),after_login_activity.class);
        startActivity(myIntent);
    }
}
