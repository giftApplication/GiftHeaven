package com.example.moon.giftheaven.views.fragments;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.moon.giftheaven.R;
//import com.example.moon.giftheaven.views.activities.Gmail_User_Info;
//import com.example.moon.giftheaven.views.activities.MyDB;
import com.example.moon.giftheaven.views.activities.after_login_activity;
import com.facebook.FacebookSdk;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.GoogleApiClient;
import com.mukeshsolanki.sociallogin.facebook.FacebookHelper;
import com.mukeshsolanki.sociallogin.facebook.FacebookListener;

import com.example.moon.giftheaven.R;
import com.example.moon.giftheaven.views.activities.after_login_activity;

public class login_Fragment extends Fragment implements View.OnClickListener, GoogleApiClient.OnConnectionFailedListener,FacebookListener{


    FacebookHelper fb_helper;

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        fb_helper.onActivityResult(requestCode,resultCode,data);

        if(requestCode==SIGN_IN_CODE){
            GoogleSignInResult result= Auth.GoogleSignInApi.getSignInResultFromIntent(data);
            handleSignInResult(result);
        }
    }



    private GoogleApiClient googleApiClient;
    Button login, fb_login,g_login;
    //private SignInButton gmail_btn;

    public static final int SIGN_IN_CODE=777;

    public void login_Fragemnt()
    {

    }
    @SuppressLint("ResourceAsColor")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root =  inflater.inflate(R.layout.fragment_login_, container, false);
        System.out.println("login Fragment");

        //........................................Login with facebook wala kaam..................................................

        FacebookSdk.setApplicationId(getResources().getString(R.string.facebook_app_id));
        FacebookSdk.sdkInitialize(getActivity());
        fb_helper=new FacebookHelper(login_Fragment.this);

        fb_login=(Button)root.findViewById(R.id.fb_login);
        fb_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fb_helper.performSignIn(getActivity());

            }
        });





        //...........................................................................

        //log in with Google wala kaam

        GoogleSignInOptions gso=new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();



        googleApiClient=new GoogleApiClient.Builder(getActivity())
                .enableAutoManage(getActivity(),this)
                .addApi(Auth.GOOGLE_SIGN_IN_API,gso)
                .build();



        //gmail_btn=(SignInButton)root.findViewById(R.id.google_btn);
        g_login=(Button)root.findViewById(R.id.google_btn);
        g_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=Auth.GoogleSignInApi.getSignInIntent(googleApiClient);
                startActivityForResult(intent,SIGN_IN_CODE);
            }
        });



        //.............................................................................


        login = (Button)root.findViewById(R.id.login_btn);
        login.setOnClickListener(this);
        return root;
    }



    @Override
    public void onFbSignInFail(String errorMessage) {
        Toast.makeText(getActivity(),"Not LoggedIn with Facebook!"+errorMessage,Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onFbSignInSuccess(String authToken, String userId) {
        Toast.makeText(getActivity(),"Successfully Signed In! "+userId,Toast.LENGTH_SHORT).show();
        Intent myIntent1 = new Intent(getActivity().getApplicationContext(), after_login_activity.class);
        startActivity(myIntent1);
    }

    @Override
    public void onFBSignOut() {
        Toast.makeText(getActivity(),"Signed Out!",Toast.LENGTH_SHORT).show();
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


    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }





    private void handleSignInResult(GoogleSignInResult result) {
        if(result.isSuccess())
        {
            goMainScreen();
        }
        else
        {
            Toast.makeText(getActivity(), "Not LoggedIn with Gmail!",Toast.LENGTH_SHORT).show();
        }
    }

    private void goMainScreen() {
        Intent i=new Intent(getActivity(), after_login_activity.class);
        i.addFlags(i.FLAG_ACTIVITY_CLEAR_TOP | i.FLAG_ACTIVITY_CLEAR_TASK | i.FLAG_ACTIVITY_NEW_TASK);
        startActivity(i);
    }

}
