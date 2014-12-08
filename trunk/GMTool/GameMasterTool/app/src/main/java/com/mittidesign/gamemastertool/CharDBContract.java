package com.mittidesign.gamemastertool;


import android.provider.BaseColumns;
import android.database.sqlite.*;
import android.content.*;

public final class CharDBContract {
    public CharDBContract() {}

    /* Inner class that defines the table contents */
    public static abstract class CharTable implements BaseColumns {
        public static final String TABLE_NAME = "chartable";
        public static final String COLUMN_NAME_CHARNAME = "charname";
        public static final String COLUMN_NAME_HP = "healthpoints";
        public static final String COLUMN_NAME_INIT = "initiative";
        public static final String COLUMN_NAME_STAMIN = "stamina";
        public static final String COLUMN_NAME_NPC = "npc";
    }

    private static final String TEXT_TYPE = " TEXT";
    private static final String COMMA_SEP = ",";
    private static final String SQL_CREATE_ENTRIES = "CREATE TABLE " + CharTable.TABLE_NAME + " (" +
            CharTable._ID + " INTEGER PRIMARY KEY," +
            CharTable.COLUMN_NAME_CHARNAME + TEXT_TYPE + COMMA_SEP +
            CharTable.COLUMN_NAME_HP + TEXT_TYPE + COMMA_SEP +
            CharTable.COLUMN_NAME_INIT + TEXT_TYPE + COMMA_SEP +
            CharTable.COLUMN_NAME_STAMIN + TEXT_TYPE + COMMA_SEP +
            CharTable.COLUMN_NAME_NPC + TEXT_TYPE + COMMA_SEP +
            " )";


    private static final String SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS " + CharTable.TABLE_NAME;

    public class FeedReaderDbHelper extends SQLiteOpenHelper {
        // If you change the database schema, you must increment the database version.
        public static final int DATABASE_VERSION = 1;
        public static final String DATABASE_NAME = "CharTable.db";

        public FeedReaderDbHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(SQL_CREATE_ENTRIES);
        }
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            // This database is only a cache for online data, so its upgrade policy is
            // to simply to discard the data and start over
            db.execSQL(SQL_DELETE_ENTRIES);
            onCreate(db);
        }
        public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            onUpgrade(db, oldVersion, newVersion);
        }
    }
}

