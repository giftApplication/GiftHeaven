package com.example.moon.giftheaven.models;

/**
 * Created by HP on 6/9/2018.
 */

public class Gift {
    String Name, Price;
    int Id;

    public Gift(String name, String price, int id, int image) {
        Name = name;
        Price = price;
        Id = id;
        Image = image;
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

    public int getImage() {
        return Image;
    }

    public void setImage(int image) {
        Image = image;
    }

    int Image;
}
