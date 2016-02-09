package com.mittidesign.whereismymoney;

public class Category {
    int id;
    String name;
    Category master;
    int color;

    public Category(String name, Category master, int color){
        this.name = name;
        this.master = master;
        this.color = color;
        }

    public Category(String name, int color){
        this.name = name;
        this.color = color;
    }

    public String getName(){
        return name;
    }

    public int getColor(){
        return color;
    }

    public Category getMaster(){
        return master;
    }

    public void setName(String name){
        this.name = name;
    }
}
