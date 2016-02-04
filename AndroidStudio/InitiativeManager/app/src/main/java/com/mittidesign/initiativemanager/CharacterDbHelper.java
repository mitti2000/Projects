package com.mittidesign.initiativemanager;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class CharacterDbHelper  extends SQLiteOpenHelper {
    public static final String DB_NAME = "initiativemanager.db";
    public static final int DB_VERSION = 1;
    public static final String TABLE_CHARACTERS = "characters";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_HP = "hp";
    public static final String COLUMN_STAMINA ="stamina";
    public static final String COLUMN_NPC ="npc";

    public static final String SQL_CREATE =
            "create table " + TABLE_CHARACTERS + "(" +
                    COLUMN_ID + " integer primary key autoincrement, "+
                    COLUMN_NAME + " text not null, "+
                    COLUMN_HP + " integer, "+
                    COLUMN_STAMINA + " integer, "+
                    COLUMN_NPC + " integer);";

    //Constructor
    public CharacterDbHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXIST " + TABLE_CHARACTERS);
        onCreate(db);
    }
}
