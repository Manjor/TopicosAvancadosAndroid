package com.example.fc20163243.myphome.Classes;

import android.graphics.Bitmap;

public class Food {

    private int numStars;
    private String name;
    private Bitmap image;

    public Food(int numStars, String name, Bitmap image) {
        this.numStars = numStars;
        this.name = name;
        this.image = image;
    }

    public int getNumStars() {
        return numStars;
    }

    public void setNumStars(int numStars) {
        this.numStars = numStars;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Bitmap getImage() {
        return image;
    }

    public void setImage(Bitmap image) {
        this.image = image;
    }
}
