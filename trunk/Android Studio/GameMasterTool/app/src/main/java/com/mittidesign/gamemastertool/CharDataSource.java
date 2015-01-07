package com.mittidesign.gamemastertool;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class CharDataSource {

    private SQLiteDatabase database; //Variable for the Database
    private CharactersDbHelper dbHelper; //Variable for the DB Helper

    //Saver
    private String[] columns = {
            CharactersDbHelper.COLUMN_ID,
            CharactersDbHelper.COLUMN_NAME,
            CharactersDbHelper.COLUMN_INITIATIVE,
            CharactersDbHelper.COLUMN_HP,
            CharactersDbHelper.COLUMN_STAMINA,
            CharactersDbHelper.COLUMN_NPC
    };

    //Contructor
    public CharDataSource(Context context) {
        dbHelper = new CharactersDbHelper(context); //Get new DB Helper Object with the context
    }

    public void open() throws SQLException{
        database = dbHelper.getWritableDatabase(); //get a writeable database
    }

    public void close(){
        dbHelper.close(); //Close the Database
    }

    //Method to create a new Character with the Name Required
    public Character createCharacter(String name) {
        ContentValues values = new ContentValues();  //Create a new contentvalues array
        values.put(CharactersDbHelper.COLUMN_NAME, name); //Set the value to the colume "name" and set the value to the chacter name
        long insertId = database.insert(CharactersDbHelper.TABLE_CHARACTERS, null, values);

        Cursor cursor = database.query(CharactersDbHelper.TABLE_CHARACTERS,
                columns,
                CharactersDbHelper.COLUMN_ID + "=" + insertId,
                null, null,null, null);
        cursor.moveToFirst();

        Character character;
        character = populateCharacters(cursor);
        cursor.close();
        return character;
    }

    public void deleteCharacter(Characters character){
        long id = character.getId();
        database.delete(CharactersDbHelper.TABLE_CHARACTERS, CharactersDbHelper.COLUMN_ID + "=" + id,null );
    }

    private Character populateCharacters(Cursor cursor){
        int idIndex = cursor.getColumnIndex(CharactersDbHelper.COLUMN_ID);
        int nameIndex = cursor.getColumnIndex(CharactersDbHelper.COLUMN_NAME);
        int initiativeIndex = cursor.getColumnIndex(CharactersDbHelper.COLUMN_INITIATIVE);
        int hpIndex = cursor.getColumnIndex(CharactersDbHelper.COLUMN_HP);
        int staminaIndex = cursor.getColumnIndex(CharactersDbHelper.COLUMN_STAMINA);
        int npcIndex = cursor.getColumnIndex(CharactersDbHelper.COLUMN_NPC);

        Character character = new Character(cursor.getString(nameIndex),0,0,"");
        character.setId(cursor.getLong(idIndex));
        character.setInitiative(cursor.getInt(initiativeIndex));
        character.setHealthPoints(cursor.getInt(hpIndex));
        character.setStamina(cursor.getInt(staminaIndex));
        character.clearNPC();

        return character;
    }

}
