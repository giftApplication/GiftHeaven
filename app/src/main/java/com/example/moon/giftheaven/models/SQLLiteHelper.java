package com.example.moon.giftheaven.models;

import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;

/**
 * Created by HP on 6/9/2018.
 */

public class SQLLiteHelper extends SQLiteOpenHelper{
    SQLiteDatabase database;
    String query;
    SQLiteStatement statement;

    public SQLLiteHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public void queryData(String  sql)
    {
            database = getWritableDatabase();
            database.execSQL(sql);
    }

    public void insertData(String name, String price, int image, String desc, String event, String cat, String bud)
    {
        database = getWritableDatabase();
        query= "INSERT INTO GIFT VALUES (NULL, ?, ?, ?, ?, ?, ?, ?) ";

        statement = database.compileStatement(query);
        statement.clearBindings();

        statement.bindString(1,name);
        statement.bindString(2,price);
        statement.bindLong(3,image);
        statement.bindString(4,event);
        statement.bindString(5,cat);
        statement.bindString(6,bud);
        statement.bindString(7,desc);

        statement.executeInsert();
    }

    public void deleteRecord()
    {
        database= getWritableDatabase();
        query = "DELETE FROM GIFT";

        statement = database.compileStatement(query);
        statement.clearBindings();

        statement.execute();
    }

    public void drop_table_from_Db()
    {
        database=getWritableDatabase();
        query = "DROP TABLE IF EXISTS GIFT_DETAILS";

        statement = database.compileStatement( query );
        statement.clearBindings();

        statement.execute();
        //db.execSQL("DROP TABLE IF EXISTS YourTableName");
    }

    public Cursor get_data_by_ID(int id)
    {
        query="SELECT * FROM GIFT";
        database= getReadableDatabase();
        Cursor cursor = getData(query);
       // while(cursor.moveToNext())
         //       System.out.println("id" + id + " " + cursor.getInt( 0) );
        while(cursor.moveToNext())
            if(cursor.getInt(0)==id+1) {
                System.out.println("id" + id + " " + cursor.getInt( 0) );
                break;}
        return cursor;
    }


    public Cursor getData(String sql)
    {
        database = getReadableDatabase();
        return database.rawQuery(sql,null);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
