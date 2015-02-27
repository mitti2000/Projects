package com.mittidesign.initiativemanager;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class DataSource {

    public SQLiteDatabase database; //Variable for Database
    public DbHelper dbHelper; //Variable for DB Helper

    public DataSource(Context context){
        dbHelper = new DbHelper(context); //Get new DB helper in the Context of Acitivity
    }

    public void open(){
        database = dbHelper.getWritableDatabase();
    }

    public void close(){
        dbHelper.close();
    }
}
