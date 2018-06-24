package com.example.moon.giftheaven.models;

/**
 * Created by HP on 6/24/2018.
 */

public class GiftsData {
     String event;
    String category;
    String budget;
    String name;
    String price;
    String description;

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    String link;

    public int getNo_of_records() {
        return no_of_records;
    }

    public void setNo_of_records(int no_of_records) {
        this.no_of_records = no_of_records;
    }

    int no_of_records;

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getBudget() {
        return budget;
    }

    public void setBudget(String budget) {
        this.budget = budget;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    String img;

}
