package com.example.moon.giftheaven.models;

import android.graphics.drawable.Drawable;

/**
 * Created by HP on 6/9/2018.
 */

public class Gift {
    String Name, Price;
    int Id;
    Drawable img;

    public Gift(String name, String price, int id, Drawable image) {
        Name = name;
        Price = price;
        Id = id;
        img = image;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public Drawable getImage() {
        return img;
    }

    public void setImage(Drawable image) {
        img = image;
    }


}
