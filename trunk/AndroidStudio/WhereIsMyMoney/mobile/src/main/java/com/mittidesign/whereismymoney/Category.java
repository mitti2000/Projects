package com.mittidesign.whereismymoney;

public class Category {
    private int id;
    private String name;
    private Category master;
    private int color;
    private CategoryOpenHelper dbHelper;

    public Category(String name, Category master, int color){
        this.name = name;
        this.master = master;
        this.color = color;
        }

    public Category(String name, int color){
        this.name = name;
        this.color = color;
    }

    public Category(){
    }

    public int getId(){
        return id;
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

    public int getMasterId(){
        return master.getId();
    }

    public void setId(int id){
        this.id = id;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setColor(int color){
        this.color = color;
    }

    public void setMaster(Category master){
        this.master = master;
    }

    public void setMasterId(int id){

    }


}
