package com.example.moon.giftheaven.models;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.InputStream;
import java.util.ArrayList;

/**
 * Created by HP on 4/10/2018.
 */

public class parse_json {
    GiftsData gifts_;
    ArrayList<GiftsData> gifts__array;
    ArrayList<String> news = new ArrayList<>();

    public ArrayList<GiftsData> get_JSON(InputStream input)  throws Exception {

        int size = input.available();
        byte[] data = new byte[size];
        int r = input.read(data);
        input.close();

        String json1 = new String(data, "UTF-8");

        JSONObject obj = new JSONObject(json1);
        gifts__array = new ArrayList<GiftsData>();

        JSONArray arr = obj.getJSONArray("details");
        System.out.println("arr =" + arr.length());
        for (int i = 0; i < arr.length(); i++) {
            JSONObject jsonObject = arr.getJSONObject(i);
            gifts_ = new GiftsData();
            gifts_.no_of_records = (int) obj.get("totalRecords");

            // System.out.println(jsonObject);
            gifts_.event=jsonObject.getString("event");
            gifts_.category = jsonObject.getString("category");
            gifts_.budget = jsonObject.getString("budget");

            gifts_.name = jsonObject.getString("name");
            gifts_.price = jsonObject.getString("price");
            gifts_.img= (jsonObject.getString( "img" ));
            gifts_.description = jsonObject.getString("description");
            gifts_.link=jsonObject.getString("link");
            gifts_.link=jsonObject.getString("link");


            gifts__array.add(i, gifts_);
            //System.out.println(gifts__array.size());

        }
       // System.out.println("size = " + gifts__array.size());
        return gifts__array;
    }

}
