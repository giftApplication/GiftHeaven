package com.example.moon.giftheaven.models;

import android.graphics.drawable.Drawable;

/**
 * Created by HP on 7/2/2018.
 */

public class Wedding extends Gift {
    String description;

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public String getBudget() {
        return budget;
    }

    public void setBudget(String budget) {
        this.budget = budget;
    }

    String event, budget;

    public Wedding(String name, String price, int id, String image, String link1,String descr) {
        super( name, price, id, image, link1 ,descr);
        this.name= name; this.price=price; this.description= descr;
    }
    public Wedding() {
        super();
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public void my_func() {

    }

    String img;
    String name;
    String url;
    String price;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }



}
