package com.example.moon.giftheaven.views.activities;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Asad on 6/7/2018.
 */

public class MyDB extends SQLiteOpenHelper {

    public static final String DBName="myDB";
    public static final int DBVersion=1;

    public MyDB(Context context) {
        super(context, DBName, null, DBVersion);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String userTable="Create TABLE User(name VARCHAR, email VARCHAR, pass VARCHAR);";
        db.execSQL(userTable);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

    }
}

