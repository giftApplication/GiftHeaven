package com.example.moon.giftheaven.views.fragments;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.moon.giftheaven.R;
//import com.example.moon.giftheaven.views.activities.Gmail_User_Info;
//import com.example.moon.giftheaven.views.activities.MyDB;
import com.example.moon.giftheaven.views.activities.MyDB;
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

import java.util.Locale;

//import com.example.moon.giftheaven.R;
//import com.example.moon.giftheaven.views.activities.after_login_activity;

public class login_Fragment extends Fragment implements View.OnClickListener, GoogleApiClient.OnConnectionFailedListener,FacebookListener{

    EditText uname, upassword;
    MyDB myDB;
    SQLiteDatabase db;
    Cursor cursor;
    private FacebookHelper facebookHelper;
    private GoogleApiClient googleApiClient;
    Button login, fb_login,g_login;
    public static final int SIGN_IN_CODE=777;

    @SuppressLint("ResourceAsColor")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root =  inflater.inflate(R.layout.fragment_login_, container, false);
        getActivity().setRequestedOrientation( ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        uname = root.findViewById(R.id.uname);
        upassword = root.findViewById(R.id.upassword);
        upassword.setHint("Password");

        // getting buttons by id.......................
        login = (Button)root.findViewById(R.id.login_btn);
        fb_login=(Button)root.findViewById(R.id.fb_login);
        g_login=(Button)root.findViewById(R.id.google_btn);

        // setOnclickListener called.............
        login.setOnClickListener(this);
        fb_login.setOnClickListener(this);

        //log in with Google wala kaam
        GoogleSignInOptions gso=new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();
        googleApiClient=new GoogleApiClient.Builder(getActivity())
                .enableAutoManage(getActivity(),this)
                .addApi(Auth.GOOGLE_SIGN_IN_API,gso)
                .build();
        g_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=Auth.GoogleSignInApi.getSignInIntent(googleApiClient);
                startActivityForResult(intent,SIGN_IN_CODE);
            }
        });
        return root;
    }

    //........onActivityResult()..................
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        facebookHelper.onActivityResult(requestCode,resultCode,data);
        if(requestCode==SIGN_IN_CODE){
            GoogleSignInResult result= Auth.GoogleSignInApi.getSignInResultFromIntent(data);
            handleSignInResult(result);
        }
    }

    //...........Facebook Listeners Methods..................
    @Override public void onFbSignInFail(String errorMessage) {
        Toast.makeText(getActivity(), ""+errorMessage,Toast.LENGTH_SHORT).show();
    }

    @Override public void onFbSignInSuccess(String authToken, String userId) {
        Toast.makeText(getActivity(), String.format(Locale.US, "User id:%s\n\nAuthToken:%s", userId, authToken),Toast.LENGTH_SHORT).show();
        Intent j=new Intent(getActivity(), after_login_activity.class);
        startActivity(j);

    }

    @Override public void onFBSignOut() {
        Toast.makeText(getActivity(), "Signed Out of Facebook",Toast.LENGTH_SHORT).show();
    }

    //............onCreate Method................................
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.setApplicationId(getResources().getString(R.string.facebook_app_id));
        FacebookSdk.sdkInitialize(getActivity());
        facebookHelper=new FacebookHelper(login_Fragment.this);

    }

//....................................SIMPLE LOGIN + FB_HELPER...................................................................
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.login_btn:
                myDB = new MyDB(getActivity());
                db = myDB.getReadableDatabase();
                if (checkDataEntered()) {
                    String[] columns = {"name", "pass"};
                    String[] uValues = {uname.getText().toString(), upassword.getText().toString()};
                    cursor = db.query("User", columns, "name=? AND pass=?", uValues, null, null, null);
                    if (cursor != null) {
                        if (cursor.moveToFirst()) {
                            Intent myIntent = new Intent(getActivity().getApplicationContext(), after_login_activity.class);
                            myIntent.putExtra("Username", uname.getText().toString());
                            startActivity(myIntent);
                        } else {
                            Toast.makeText(getActivity(), "Invalid Username or Password!", Toast.LENGTH_LONG).show();
                            uname.setText("");
                            upassword.setText("");}} }
                break;
            case R.id.fb_login:
                facebookHelper.performSignIn(this);
                break;
        }
    }
    private boolean checkDataEntered() {
        if(isEmpty(upassword) || isEmpty(uname)) {
            if (isEmpty(uname))
                uname.setError("UserName required");
            if (isEmpty(upassword))
                upassword.setError("Passowrd required");
            return false;
        }
        else return true;
    }
    private boolean isEmpty(EditText t) {
        CharSequence text = t.getText().toString();
        return (TextUtils.isEmpty(text));

    }

//........................ GMAIL WORK HERE............................................................................................

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {}
    private void handleSignInResult(GoogleSignInResult result) {
        if(result.isSuccess())
        {
            goMainScreen();
        }
        else
        {
            Toast.makeText(getActivity(), "not Signed In to Gmail",Toast.LENGTH_SHORT).show();
        }
    }
    private void goMainScreen() {
        Toast.makeText(getActivity(), "Successfully Signed In! ",Toast.LENGTH_SHORT).show();
        Intent i=new Intent(getActivity(), after_login_activity.class);
        i.addFlags(i.FLAG_ACTIVITY_CLEAR_TOP | i.FLAG_ACTIVITY_CLEAR_TASK | i.FLAG_ACTIVITY_NEW_TASK);
        startActivity(i);}

}
