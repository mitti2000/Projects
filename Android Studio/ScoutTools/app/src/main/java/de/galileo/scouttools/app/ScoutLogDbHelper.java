package de.galileo.scouttools.app;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by studio on 06.06.2014.
 */
public class ScoutLogDbHelper extends SQLiteOpenHelper {

    public static final String DB_NAME = "scout.db";
    public static final int DB_VERSION = 11;
    public static final String TABLE_SCOUTLOG = "scoutlog";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_TITLE = "title";
    public static final String COLUMN_CONTENT = "content";
    public static final String COLUMN_IMAGE = "image";

    public static final String SQL_CREATE =
            "create table " + TABLE_SCOUTLOG + "(" +
                    COLUMN_ID + " integer primary key autoincrement, " +
                    COLUMN_TITLE + " text not null, " +
                    COLUMN_CONTENT + " text, " +
                    COLUMN_IMAGE + " text);";


    public ScoutLogDbHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(SQL_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i2) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_SCOUTLOG);
        onCreate(sqLiteDatabase);
    }
}
