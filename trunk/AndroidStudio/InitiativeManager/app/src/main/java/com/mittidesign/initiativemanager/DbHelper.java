package com.mittidesign.initiativemanager;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHelper extends SQLiteOpenHelper {
    // Logcat tag
    public static final String LOG = "DatabaseHelper";

    // Database Version
    public static final int DB_VERSION = 1;

    // Database Name
    public static final String DB_NAME = "initiativemanager.db";

    // Table Names
    public static final String TABLE_FIGHTLIST = "fightlist";
    public static final String TABLE_CHARLIST = "charlist";

    //FIGHTLIST Column Names
    public static final String COLUMN_FIGHT_ID = "id";
    public static final String COLUMN_FIGHT_ACTIVE = "active";
    public static final String COLUMN_FIGHT_NAME = "name";
    public static final String COLUMN_FIGHT_INITIATIVE = "initiative";
    public static final String COLUMN_FIGHT_HP = "hp";
    public static final String COLUMN_FIGHT_STAMINA ="stamina";
    public static final String COLUMN_FIGHT_NPC ="npc";

    //CHARACTERLIST Column Names
    public static final String COLUMN_CHAR_ID = "id";
    public static final String COLUMN_CHAR_NAME = "name";
    public static final String COLUMN_CHAR_HP = "hp";
    public static final String COLUMN_CHAR_STAMINA ="stamina";
    public static final String COLUMN_CHAR_NPC ="npc";

    //Create Tables
    //Create FIGHTLIST
    public static final String CREATE_TABLE_FIGHTLIST =
            "create table " + TABLE_FIGHTLIST + "(" +
                    COLUMN_FIGHT_ID + " integer primary key autoincrement, "+
                    COLUMN_FIGHT_ACTIVE + " text, "+
                    COLUMN_FIGHT_NAME + " text not null, "+
                    COLUMN_FIGHT_INITIATIVE + " integer, "+
                    COLUMN_FIGHT_HP + " integer, "+
                    COLUMN_FIGHT_STAMINA + " integer, "+
                    COLUMN_FIGHT_NPC + " integer);";

    //Create CHARLIST
    public static final String CREATE_TABLE_CHARLIST =
            "create table " + TABLE_CHARLIST + "(" +
                    COLUMN_CHAR_ID + " integer primary key autoincrement, "+
                    COLUMN_CHAR_NAME + " text not null, "+
                    COLUMN_CHAR_HP + " integer, "+
                    COLUMN_CHAR_STAMINA + " integer, "+
                    COLUMN_CHAR_NPC + " integer);";

    //Constructor
    public DbHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        // creating required tables
        db.execSQL(CREATE_TABLE_FIGHTLIST);
        db.execSQL(CREATE_TABLE_CHARLIST);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // on upgrade drop older tables
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_FIGHTLIST);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CHARLIST);

        // create new tables
        onCreate(db);
    }
}
