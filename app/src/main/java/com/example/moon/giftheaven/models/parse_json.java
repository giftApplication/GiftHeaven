package com.example.moon.giftheaven.models;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.InputStream;
import java.util.ArrayList;

/**
 * Created by HP on 4/10/2018.
 */

public abstract class parse_json {
    Wedding gifts_;
    ArrayList<Wedding> gifts__array;
    ArrayList<String> news = new ArrayList<>();

    public abstract ArrayList<Wedding> get_JSON_wedding(InputStream input)  throws Exception;

}
