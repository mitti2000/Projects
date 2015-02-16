package com.mittidesign.initiativemanager;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class CharDataSource {

    private SQLiteDatabase database; //Variable for Database
    private CharacterDbHelper dbHelper; //Variable for DB Helper

    private String[] columns = { //Columns in Table
            CharacterDbHelper.COLUMN_ID,
            CharacterDbHelper.COLUMN_NAME,
            CharacterDbHelper.COLUMN_HP,
            CharacterDbHelper.COLUMN_STAMINA,
            CharacterDbHelper.COLUMN_NPC,
    };

    //Constructor
    public CharDataSource(Context context){
        dbHelper = new CharacterDbHelper(context); //Get new DB helper in the Context of Acitivity
    }

    public void open(){
        database = dbHelper.getWritableDatabase();
    }

    public void close(){
        dbHelper.close();
    }

    public Character createCharacter(String name){
        //TODO: change variables to form values
        int hp = 25;
        int stamina = 12;

        ContentValues values = new ContentValues();
        values.put(CharacterDbHelper.COLUMN_NAME, name);
        values.put(CharacterDbHelper.COLUMN_HP, hp);
        values.put(CharacterDbHelper.COLUMN_STAMINA, stamina);

        long insertId = database.insert(CharacterDbHelper.TABLE_CHARACTERS,null,values);

        Cursor cursor = database.query(CharacterDbHelper.TABLE_CHARACTERS,
                columns,
                CharacterDbHelper.COLUMN_ID + "=" + insertId,
                null,null,null,null);
        cursor.moveToFirst();

        Character character;
        character = populateCharacters(cursor);
        cursor.close();
        return character;
    }


    public ArrayList<Character> getAllCharacters(){
        String sortOrder = CharacterDbHelper.COLUMN_NAME + " DESC";
        int indexID;
        int indexName;
        int indexHP;
        int indexInitiative;
        Character character;
        ArrayList<Character> chars;


        Cursor cursor= database.query(
                CharacterDbHelper.TABLE_CHARACTERS,
                columns,
                null,null,null,null,
                sortOrder
        );
        chars = new ArrayList<Character>();

        cursor.moveToPosition(-1);
        while(cursor.moveToNext()){
            indexID = cursor.getColumnIndex(CharacterDbHelper.COLUMN_ID);
            indexName =cursor.getColumnIndex(CharacterDbHelper.COLUMN_NAME);
            indexHP = cursor.getColumnIndex(CharacterDbHelper.COLUMN_HP);

            character = new Character(cursor.getString(indexName));
            character.setId(cursor.getLong(indexID));
            character.setHealthPoints(cursor.getInt(indexHP));
            chars.add(character);
        }
        cursor.close();
        return chars;
    }

    public void deleteDatabase(){
        database.delete(CharacterDbHelper.TABLE_CHARACTERS,null,null);
    }

    private Character populateCharacters(Cursor cursor){
        int idIndex = cursor.getColumnIndex(CharacterDbHelper.COLUMN_ID);
        int nameIndex = cursor.getColumnIndex(CharacterDbHelper.COLUMN_NAME);
        int hpIndex = cursor.getColumnIndex(CharacterDbHelper.COLUMN_HP);
        int staminaIndex = cursor.getColumnIndex(CharacterDbHelper.COLUMN_STAMINA);
        int npcIndex = cursor.getColumnIndex(CharacterDbHelper.COLUMN_NPC);


        Character character = new Character(cursor.getString(nameIndex));
        character.setId(cursor.getInt(idIndex));
        character.setHealthPoints(cursor.getInt(hpIndex));
        character.setStamina(cursor.getInt(staminaIndex));
        character.setNpc(cursor.getInt(nameIndex));

        return character;
    }

}
