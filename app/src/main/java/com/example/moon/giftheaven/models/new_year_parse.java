package com.example.moon.giftheaven.models;

import com.example.moon.giftheaven.views.fragments.FragmentEvent;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.InputStream;
import java.util.ArrayList;

/**
 * Created by HP on 7/4/2018.
 */

public class new_year_parse extends parse_json{
    new_year gifts_;
    ArrayList<new_year> gifts__array;
    ArrayList<String> news = new ArrayList<>();

    public ArrayList<new_year> get_JSON_new_year(InputStream input)  throws Exception {

        int size = input.available();
        byte[] data = new byte[size];
        int r = input.read(data);
        input.close();

        String json1 = new String(data, "UTF-8");

        JSONObject obj = new JSONObject(json1);
        gifts__array = new ArrayList<new_year>();

        JSONArray arr = obj.getJSONArray("details");
        System.out.println("arr =" + arr.length());
        for (int i = 0; i < arr.length(); i++) {
            JSONObject jsonObject = arr.getJSONObject(i);
            gifts_ = new new_year();
            // gifts_.no_of_records = (int) obj.get("totalRecords");

            // System.out.println(jsonObject);
            gifts_.name=jsonObject.getString("name");
            gifts_.url = jsonObject.getString("url");
            gifts_.img = jsonObject.getString("image");
            gifts_.price = jsonObject.getString("price_on_detail");
            gifts_.description = jsonObject.getString("description");
            gifts_.event= FragmentEvent.event;
            gifts_.budget= jsonObject.getString( "price_on_detail" );

            gifts__array.add(i, gifts_);
            //System.out.println(gifts__array.size());

        }
        // System.out.println("size = " + gifts__array.size());
        return gifts__array;
    }

}
