package com.example.recipe_app_cooker_space_test2;

import androidx.annotation.IntegerRes;

public class recyclerview_list {
    private Integer image ;
    private String text;
    private int id;

    public recyclerview_list(Integer image, String text) {
        this.image = image;
        this.text = text;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public Integer getImage() {
        return image;
    }

    public void setImage(Integer image) {
        this.image = image;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
