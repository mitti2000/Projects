package com.mittidesign.initiativemanager;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class FightListDataSourceBackup {

    private SQLiteDatabase database; //Variable for Database
    private FightListDbHelper dbHelper; //Variable for DB Helper

    private String[] columns = { //Columns in Table
            FightListDbHelper.COLUMN_ID,
            FightListDbHelper.COLUMN_ACTIVE,
            FightListDbHelper.COLUMN_NAME,
            FightListDbHelper.COLUMN_INITIATIVE,
            FightListDbHelper.COLUMN_HP,
            FightListDbHelper.COLUMN_STAMINA,
            FightListDbHelper.COLUMN_NPC
    };

    //Constructor
    public FightListDataSourceBackup(Context context){
        dbHelper = new FightListDbHelper(context); //Get new DB helper in the Context of Acitivity
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
        int initiative = 30;
        String active = "X";
        int npc = 1;

        ContentValues values = new ContentValues();
        values.put(FightListDbHelper.COLUMN_ACTIVE, active);
        values.put(FightListDbHelper.COLUMN_NAME, name);
        values.put(FightListDbHelper.COLUMN_INITIATIVE, initiative);
        values.put(FightListDbHelper.COLUMN_HP, hp);
        values.put(FightListDbHelper.COLUMN_STAMINA, stamina);
        values.put(FightListDbHelper.COLUMN_NPC, npc);

        long insertId = database.insert(FightListDbHelper.TABLE_CHARACTERS,null,values);

        Cursor cursor = database.query(FightListDbHelper.TABLE_CHARACTERS,
                columns,
                FightListDbHelper.COLUMN_ID + "=" + insertId,
                null,null,null,null);
        cursor.moveToFirst();

        Character character;
        character = populateCharacters(cursor);
        cursor.close();
        return character;
    }


    public ArrayList<Character> getAllCharacters(){
        String sortOrder = FightListDbHelper.COLUMN_NAME + " DESC";
        int indexID;
        int indexActive;
        int indexName;
        int indexInitiative;
        int indexHP;
        int indexStamina;
        int indexNpc;
        Character character;
        ArrayList<Character> chars;


        Cursor cursor= database.query(
                FightListDbHelper.TABLE_CHARACTERS,
                columns,
                null,null,null,null,
                sortOrder
        );
        chars = new ArrayList<Character>();

        cursor.moveToPosition(-1);
        while(cursor.moveToNext()){
            indexID = cursor.getColumnIndex(FightListDbHelper.COLUMN_ID);
            indexActive = cursor.getColumnIndex(FightListDbHelper.COLUMN_ACTIVE);
            indexName =cursor.getColumnIndex(FightListDbHelper.COLUMN_NAME);
            indexInitiative =cursor.getColumnIndex(FightListDbHelper.COLUMN_INITIATIVE);
            indexHP = cursor.getColumnIndex(FightListDbHelper.COLUMN_HP);
            indexStamina = cursor.getColumnIndex(FightListDbHelper.COLUMN_STAMINA);
            indexNpc = cursor.getColumnIndex(FightListDbHelper.COLUMN_NPC);

            character = new Character(cursor.getString(indexName));
            character.setId(cursor.getLong(indexID));
            character.setActive(cursor.getString(indexActive));
            character.setInitiative(cursor.getInt(indexInitiative));
            character.setHealthPoints(cursor.getInt(indexHP));
            character.setStamina(cursor.getInt(indexStamina));
            character.setNpc(cursor.getInt(indexNpc));

            chars.add(character);
        }
        cursor.close();
        return chars;
    }

    public void deleteDatabase(){
        database.delete(FightListDbHelper.TABLE_CHARACTERS,null,null);
    }

    private Character populateCharacters(Cursor cursor){
        int idIndex = cursor.getColumnIndex(FightListDbHelper.COLUMN_ID);
        int activeIndex = cursor.getColumnIndex(FightListDbHelper.COLUMN_ACTIVE);
        int nameIndex = cursor.getColumnIndex(FightListDbHelper.COLUMN_NAME);
        int initiativeIndex = cursor.getColumnIndex(FightListDbHelper.COLUMN_INITIATIVE);
        int hpIndex = cursor.getColumnIndex(FightListDbHelper.COLUMN_HP);
        int staminaIndex = cursor.getColumnIndex(FightListDbHelper.COLUMN_STAMINA);
        int npcIndex = cursor.getColumnIndex(FightListDbHelper.COLUMN_NPC);


        Character character = new Character(cursor.getString(nameIndex));
        character.setId(cursor.getInt(idIndex));
        character.setActive(cursor.getString(activeIndex));
        character.setInitiative(cursor.getInt(initiativeIndex));
        character.setHealthPoints(cursor.getInt(hpIndex));
        character.setStamina(cursor.getInt(staminaIndex));
        character.setNpc(cursor.getInt(npcIndex));

        return character;
    }



}
