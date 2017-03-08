package com.example.user.clorikapp;

/**
 * Created by User on 07-07-2016.
 */
public class DataModel {
    int images1,images2;

    int type;
    String titles1, titles2;

    public static final int ITEM_TYPE_USER = 0;
    public static final int ITEM_TYPE_CONTENT = 1;
    public static final int ITEM_TYPE_CHOICE = 2;

    DataModel(int image, String title, String description, int image2, int type){
        images1 = image;
        images2 = image2;
        titles1 = title;
        titles2 = description;
        this.type = type;
    }


    public int getImages1() {
        return images1;
    }

    public void setImages1(int images1) {
        this.images1 = images1;
    }

    public int getImages2() {
        return images2;
    }

    public void setImages2(int images2) {
        this.images2 = images2;
    }

    public String getTitles1() {
        return titles1;
    }

    public void setTitles1(String titles1) {
        this.titles1 = titles1;
    }

    public String getTitles2() {
        return titles2;
    }

    public void setTitles2(String titles2) {
        this.titles2 = titles2;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

}
