package com.mittidesign.whereismymoney;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.LinkedList;
import java.util.List;

public class CategoryOpenHelper extends SQLiteOpenHelper {

    //Database Version
    private static final int DATABASE_VERSION = 1;

    //Database Name
    private static final String DATABASE_NAME = "WIMMDB";

    //Table Names
    private static final String CATEGORY_TABLE_NAME = "categories";

    //Keys
    //Category
    private static final String CATEGORY_KEY_ID = "id";
    private static final String CATEGORY_KEY_NAME = "name";
    private static final String CATEGORY_KEY_COLOR = "color";
    private static final String CATEGORY_KEY_MASTER = "master";

    private static final String[] CATEGORY_COLUMNS = {CATEGORY_KEY_ID, CATEGORY_KEY_NAME, CATEGORY_KEY_COLOR, CATEGORY_KEY_MASTER};

    //Create strings
    //Category
    private static final String CATEGORY_TABLE_CREATE =
            "CREATE TABLE " + CATEGORY_TABLE_NAME + " ( " +
                    CATEGORY_KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    CATEGORY_KEY_NAME + " TEXT, " +
                    CATEGORY_KEY_COLOR + " INTEGER, "+
                    CATEGORY_KEY_MASTER + " INTEGER);";

    public CategoryOpenHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CATEGORY_TABLE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        //Drop older category table if existed
        db.execSQL("DROP TABLE IF EXISTS " + CATEGORY_TABLE_NAME);

        //Create fresh category Table
        this.onCreate(db);

    }

    public int addCategory (Category category){
        //1. Get reference to writable database
        SQLiteDatabase db = this.getWritableDatabase();

        //2. create ContentValues to add key "column", "value"
        ContentValues values = new ContentValues();
        values.put(CATEGORY_KEY_NAME, category.getName());
        values.put(CATEGORY_KEY_COLOR, category.getColor());
        values.put(CATEGORY_KEY_MASTER, category.getMasterId());

        //3. insert
        int i = (int) db.insert(CATEGORY_TABLE_NAME, //table name
                null, //nullCokumnHack
                values); //key, Value = column_names/Values = column values

        //4. close
        db.close();

        return i;
    }

    public Category getCategory(int id){
        //1. get reference to readable database
        SQLiteDatabase db = this.getWritableDatabase();

        //2. build query
        Cursor cursor =
                db.query(CATEGORY_TABLE_NAME, //a) Table Name
                CATEGORY_COLUMNS, //b) Column Names
                " id = ?", //c) Selections
                new String[] {String.valueOf(id)}, //d) selection args
                null, //e) group by
                null, //f) having
                null, //g) order by
                null); //h) limit

        //3. if we got results get the first one
        if (cursor != null){
            cursor.moveToFirst();
        }

        //4. build category object
        Category category = new Category();
        category.setId(cursor.getInt(0));
        category.setName(cursor.getString(1));
        category.setColor(cursor.getInt(2));
        category.setMasterId(cursor.getInt(3));

        cursor.close();

        return category;
    }

    public List<Category> getAllCategorys(){
        List<Category> categories = new LinkedList<Category>();

        //1. Build the query
        String query = "SELECT * FROM " + CATEGORY_TABLE_NAME;

        //2. get reference to writaable Database
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        //3. go over each row, build category and add it to list
        Category category = null;
        if(cursor.moveToFirst()){
            do{
                category = new Category();
                category.setId(cursor.getInt(0));
                category.setName(cursor.getString(1));
                category.setColor(cursor.getInt(2));

                //add category to categories
                categories.add(category);
            } while (cursor.moveToNext());
        }

        return categories;
    }

    public int updateCategory(Category category){
        //1. get reference to writable database
        SQLiteDatabase db = this.getWritableDatabase();

        //2. create ContentValues to add key "column/value"
        ContentValues values = new ContentValues();
        values.put(CATEGORY_KEY_NAME, category.getName());
        values.put(CATEGORY_KEY_COLOR, category.getColor());

        //3. Updating row
        int i = db.update(CATEGORY_TABLE_NAME, //Table
                values, //Column values
                CATEGORY_KEY_ID + " = ?", //selections
                new String[] {String.valueOf(category.getId()) }); //selection arguments

        db.close();

        return i;
    }

    public void deleteCategory (Category category){
        //1. get reference to writable database
        SQLiteDatabase db = this.getWritableDatabase();

        //2. Delete
        db.delete(CATEGORY_TABLE_NAME, //Table name
                CATEGORY_KEY_ID + " ?", //Selection
                new String[] {String.valueOf(category.getId())}); //selection arguments

        //3. Close
        db.close();
    }
}