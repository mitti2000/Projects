package com.mittidesign.training;

import android.util.Log;

/**
 * Created by Mit on 03.12.2014.
 */
public class Sheep extends Animal {
    private String name = "";
    private int woolAmount; // in grams


    public Sheep() {
        Log.d("Sheep", "ein neues Schaf ist erschienen");
        woolAmount = 300;
    }

    public void setName (String newName) {
        name = newName;
    }

    public String getName () {
        return  name;
    }

    public int shear () {
        int currenWoolAmount = woolAmount;
        woolAmount = 0;
        return currenWoolAmount;
    }
}
