package com.mittidesign.initiativemanager;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class CharDataSource {

    private SQLiteDatabase database; //Variable for Database
    private DBHelper dbHelper; //Variable for DB Helper

    private String[] columns = { //Columns in Table
            DBHelper.COLUMN_ID,
            DBHelper.COLUMN_NAME,
            DBHelper.COLUMN_HP,
            DBHelper.COLUMN_INITIATIVE
    };

    //Constructor
    public CharDataSource(Context context){
        dbHelper = new DBHelper(context); //Get new DB helper in the Context of Acitivity
    }

    public void open(){
        database = dbHelper.getWritableDatabase();
    }

    public void close(){
        dbHelper.close();
    }

    public Character createCharacter(String name){
        int hp = 25;
        int initiative = 13;
        ContentValues values = new ContentValues();
        values.put(DBHelper.COLUMN_NAME, name);
        values.put(DBHelper.COLUMN_HP, hp);
        values.put(DBHelper.COLUMN_INITIATIVE, initiative);

        long insertId = database.insert(DBHelper.TABLE_CHARACTERS,null,values);

        Cursor cursor = database.query(DBHelper.TABLE_CHARACTERS,
                columns,
                DBHelper.COLUMN_ID + "=" + insertId,
                null,null,null,null);
        cursor.moveToFirst();

        Character character;
        character = populateCharacters(cursor);
        cursor.close();
        return character;
    }

    private Character populateCharacters(Cursor cursor){
        int idIndex = cursor.getColumnIndex(DBHelper.COLUMN_ID);
        int nameIndex = cursor.getColumnIndex(DBHelper.COLUMN_NAME);
        int hpIndex = cursor.getColumnIndex(DBHelper.COLUMN_HP);
        int initiativeIndex = cursor.getColumnIndex(DBHelper.COLUMN_INITIATIVE);

        Character character = new Character(cursor.getString(nameIndex));
        character.setId(cursor.getInt(idIndex));
        character.setHealthPoints(cursor.getInt(hpIndex));
        character.setInitiative(cursor.getInt(initiativeIndex));

        return character
    }

}
