package com.mittidesign.whereismymoney;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class CategoryOpenHelper extends SQLiteOpenHelper {

    //Database Version
    private static final int DATABASE_VERSION = 1;

    //Database Name
    private static final String DATABASE_NAME = "WIMMDB";

    //Table Names
    private static final String CATEGORY_TABLE_NAME = "dictionary";

    //Field Names
    //Category
    private static final String CATEGORY_FIELD_NAME = "category_name";
    private static final String CATEGORY_FIELD_COLOR = "category_color";
    private static final String CATEGORY_FIELD_MASTER = "category_master";

    //Keys
    //Category
    private static final String CATEGORY_KEY_ID = "id";
    private static final String CATEGORY_KEY_NAME = "name";
    private static final String CATEGORY_KEY_COLOR = "color";
    private static final String CATEGORY_KEY_MASTER = "master";

    private static final String[] CATEGORY_COLUMNS = {CATEGORY_KEY_NAME, CATEGORY_KEY_COLOR};

    //Create strings
    //Category
    private static final String CATEGORY_TABLE_CREATE =
            "CREATE TABLE " + CATEGORY_TABLE_NAME + " (" +
                    "id INTEGER PRIMARY KEY AUTO INCREMENT, " +
                    CATEGORY_FIELD_NAME + " TEXT, " +
                    CATEGORY_FIELD_COLOR + " INTEGER, " +
                    CATEGORY_FIELD_MASTER + " INTEGER);";

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

    public void addCategory (Category category){
        //1. Get reference to writable database
        SQLiteDatabase db = this.getWritableDatabase();

        //2. create ContentValues to add key "column", "value"
        ContentValues values = new ContentValues();
        values.put(CATEGORY_KEY_NAME, category.getName());
        values.put(CATEGORY_KEY_COLOR, category.getColor());
        //values.put(CATEGORY_KEY_MASTER, category.getMaster()); //change return value to id

        //3. insert
        db.insert(CATEGORY_TABLE_NAME, //table name
                null, //nullCokumnHack
                values); //key, Value = column_names/Values = column values

        //4. close
        db.close();
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
        Category category = new Category("", 0);
        category.


    }
}