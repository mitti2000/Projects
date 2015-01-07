package de.galileo.scouttools.app;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by studio on 06.06.2014.
 */
public class ScoutLogDataSource {

    private SQLiteDatabase database;
    private ScoutLogDbHelper dbHelper;

    private String[] columns = {
            ScoutLogDbHelper.COLUMN_ID,
            ScoutLogDbHelper.COLUMN_TITLE,
            ScoutLogDbHelper.COLUMN_CONTENT,
            ScoutLogDbHelper.COLUMN_IMAGE
    };

    public ScoutLogDataSource(Context context) {
        dbHelper = new ScoutLogDbHelper(context);
    }

    public void open() throws SQLException {
        database = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }

    public ScoutLog createScoutLog(String title) {
        ContentValues values = new ContentValues();
        values.put(ScoutLogDbHelper.COLUMN_TITLE, title);
        long insertId = database.insert(ScoutLogDbHelper.TABLE_SCOUTLOG, null, values);

        Cursor cursor = database.query(ScoutLogDbHelper.TABLE_SCOUTLOG,
                columns,
                ScoutLogDbHelper.COLUMN_ID + "=" + insertId,
                null,null,null,null);

        cursor.moveToFirst();
        ScoutLog scoutLog;
        scoutLog = populateScoutLog(cursor);
        cursor.close();
        return scoutLog;
    }

    public void deleteScoutLog(ScoutLog scoutLog) {
        long id = scoutLog.getId();
        database.delete(ScoutLogDbHelper.TABLE_SCOUTLOG, ScoutLogDbHelper.COLUMN_ID + "=" + id, null);
    }




    public List<ScoutLog> getAllScoutLogs() {
        List<ScoutLog> scoutLogList = new ArrayList<ScoutLog>();
        Cursor cursor = database.query(ScoutLogDbHelper.TABLE_SCOUTLOG,
                columns, null, null, null, null, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            ScoutLog scoutLog = populateScoutLog(cursor);
            scoutLogList.add(scoutLog);
            cursor.moveToNext();
        }

        cursor.close();
        return scoutLogList;
    }

    private ScoutLog populateScoutLog(Cursor cursor) {
        int idIndex = cursor.getColumnIndex(ScoutLogDbHelper.COLUMN_ID);
        int titleIndex = cursor.getColumnIndex(ScoutLogDbHelper.COLUMN_TITLE);
        int contentIndex = cursor.getColumnIndex(ScoutLogDbHelper.COLUMN_CONTENT);
        int imageIndex = cursor.getColumnIndex(ScoutLogDbHelper.COLUMN_IMAGE);

        ScoutLog scoutLog = new ScoutLog(cursor.getString(titleIndex));
        scoutLog.setId(cursor.getLong(idIndex));
        scoutLog.setContent(cursor.getString(contentIndex));
        scoutLog.setImage(cursor.getString(imageIndex));

        return scoutLog;

    }

}
