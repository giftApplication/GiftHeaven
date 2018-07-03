package com.example.moon.giftheaven.models;

import com.example.moon.giftheaven.views.fragments.FragmentBudget;
import com.example.moon.giftheaven.views.fragments.FragmentEvent;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.InputStream;
import java.util.ArrayList;

/**
 * Created by HP on 7/4/2018.
 */

public class Wedding_parse extends parse_json {

    Wedding gifts_;
    ArrayList<Wedding> gifts__array;
    ArrayList<String> news = new ArrayList<>();

    public ArrayList<Wedding> get_JSON_wedding(InputStream input)  throws Exception {

        int size = input.available();
        byte[] data = new byte[size];
        int r = input.read(data);
        input.close();

        String json1 = new String(data, "UTF-8");

        JSONObject obj = new JSONObject(json1);
        gifts__array = new ArrayList<Wedding>();

        JSONArray arr = obj.getJSONArray("details");
        System.out.println("arr =" + arr.length());
        for (int i = 0; i < arr.length(); i++) {
            JSONObject jsonObject = arr.getJSONObject(i);
            gifts_ = new Wedding();
            // gifts_.no_of_records = (int) obj.get("totalRecords");

            // System.out.println(jsonObject);
            gifts_.name=jsonObject.getString("name");
            gifts_.url = jsonObject.getString("url");
            gifts_.img = jsonObject.getString("image");
            gifts_.price = jsonObject.getString("price_on_detail");
            gifts_.description = jsonObject.getString("description");
            gifts_.event= FragmentEvent.event;
            gifts_.budget= jsonObject.getString( "price" );

            gifts__array.add(i, gifts_);
            //System.out.println(gifts__array.size());

        }
        // System.out.println("size = " + gifts__array.size());
        return gifts__array;
    }

}
