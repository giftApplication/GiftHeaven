package com.example.moon.giftheaven.views.fragments;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.moon.giftheaven.R;
import com.example.moon.giftheaven.views.activities.MyDB;

import static android.widget.Toast.LENGTH_LONG;
import static com.example.moon.giftheaven.views.activities.Activity1.pager;

public class register_fragment extends Fragment {

    EditText  name_, email_, password_;
    String name, email, password;
    Button register;
    SQLiteDatabase db;
    ContentValues values;
    MyDB myDB;
    public register_fragment()
    {

    }
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_register_fragment, container, false);
        // root.setBackgroundColor(getResources().getColor(R.color.colorAccent));
        System.out.println("Register Fragment");
        name_=root.findViewById(R.id.name);
        email_=root.findViewById(R.id.email);
        password_=root.findViewById(R.id.password);
        password_.setHint("Password");
        //password_.setTypeface("serif");
        register = (Button)root.findViewById(R.id.reg_btn);


        register = (Button)root.findViewById(R.id.reg_btn);
        //register.setOnClickListener(this);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                register.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if(checkDataEntered()) {

                            name=name_.getText().toString();
                            email=email_.getText().toString();
                            password=password_.getText().toString();

                            myDB = new MyDB(getActivity());
                            db = myDB.getWritableDatabase();

                            values = new ContentValues();
                            values.put("name", name);
                            values.put("email", email);
                            values.put("pass", password);

                            db.insert("User", null, values);
                            Toast.makeText(getActivity(), "User Data Inserted!", LENGTH_LONG).show();

                            name_.setText("");
                            email_.setText("");
                            password_.setText("");

                            login_Fragment login_now = new login_Fragment();
                            pager.setCurrentItem(0);
                        }
                    }
                });
                //   getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frag,login_now).addToBackStack(null).commit();
            }
        });

        return root;
    }



    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }
    private boolean checkDataEntered() {
        boolean flag = true;
        if(isEmpty(name_)) {
            name_.setError("UserName is required"); flag = false;}
        if(isEmpty(email_)){
            email_.setError("Email is required");  flag = false;}
        if(isEmpty(password_) ){
            password_.setError("Password is required"); flag = false;}
        else if(password_.getText().toString().length()<8){
            //  System.out.println("len 1 2= " + password_.getText().toString().length());
            password_.setError("Password must be 8 digits long"); flag = false;}
        if(isEmailValid() == false){
            email_.setError("Enter valid Email"); flag = false;}

        return flag;

        // Toast.makeText(getActivity(),"You must enter UserName to register", LENGTH_SHORT).show();
    }

    private boolean isEmailValid() {

        return (!TextUtils.isEmpty(email_.getText().toString()) && Patterns.EMAIL_ADDRESS.matcher(email_.getText().toString()).matches());

    }

    private boolean isEmpty(EditText t) {
        CharSequence text = t.getText().toString();
        return (TextUtils.isEmpty(text));

    }


}
