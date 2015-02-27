package com.mittidesign.initiativemanager;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import java.util.ArrayList;

public class CharDataSource extends DataSource{

    private String[] columns = { //Columns in Table
            DbHelper.COLUMN_CHAR_ID,
            DbHelper.COLUMN_CHAR_NAME,
            DbHelper.COLUMN_CHAR_HP,
            DbHelper.COLUMN_CHAR_STAMINA,
            DbHelper.COLUMN_CHAR_NPC
    };

    //Constructor
    public CharDataSource(Context context){
        super(context);
    }


    public Character createCharacter(String name, int hp, int stamina, boolean npc){
        int npcInt;

        if (npc)  npcInt = 1;
        else npcInt = 0;

        ContentValues values = new ContentValues();
        values.put(DbHelper.COLUMN_CHAR_NAME, name);
        values.put(DbHelper.COLUMN_CHAR_HP, hp);
        values.put(DbHelper.COLUMN_CHAR_STAMINA, stamina);
        values.put(DbHelper.COLUMN_CHAR_NPC, npcInt);

        long insertId = database.insert(DbHelper.TABLE_CHARLIST,null,values);

        Cursor cursor = database.query(DbHelper.TABLE_CHARLIST,
                columns,
                DbHelper.COLUMN_CHAR_ID + "=" + insertId,
                null,null,null,null);
        cursor.moveToFirst();

        Character character;
        character = populateCharacters(cursor);
        cursor.close();
        return character;
    }


    public ArrayList<Character> getAllCharacters(){
        String sortOrder = DbHelper.COLUMN_CHAR_NAME + " DESC";
        int indexID;
        int indexName;
        int indexHP;
        int indexStamina;
        int indexNpc;
        Character character;
        ArrayList<Character> chars;


        Cursor cursor= database.query(
                DbHelper.TABLE_CHARLIST,
                columns,
                null,null,null,null,
                sortOrder
        );
        chars = new ArrayList<Character>();

        cursor.moveToPosition(-1);
        while(cursor.moveToNext()){
            indexID = cursor.getColumnIndex(DbHelper.COLUMN_CHAR_ID);
            indexName =cursor.getColumnIndex(DbHelper.COLUMN_CHAR_NAME);
            indexHP = cursor.getColumnIndex(DbHelper.COLUMN_CHAR_HP);
            indexStamina = cursor.getColumnIndex(DbHelper.COLUMN_CHAR_STAMINA);
            indexNpc = cursor.getColumnIndex(DbHelper.COLUMN_CHAR_NPC);

            character = new Character(cursor.getString(indexName));
            character.setId(cursor.getLong(indexID));
            character.setHealthPoints(cursor.getInt(indexHP));
            character.setStamina(cursor.getInt(indexStamina));
            character.setNpc(cursor.getInt(indexNpc));

            chars.add(character);
        }
        cursor.close();
        return chars;
    }

    public void deleteCharacter(Character character) {
        database.delete(DbHelper.TABLE_CHARLIST, DbHelper.COLUMN_CHAR_ID + "=" + character.getId(), null);
    }

    public void editCharacter(Character character){
        int npcInt;

        if (character.isNpc())  npcInt = 1;
        else npcInt = 0;

        ContentValues values = new ContentValues();
        values.put(DbHelper.COLUMN_CHAR_NAME, character.getName());
        values.put(DbHelper.COLUMN_CHAR_HP, character.getHealthPoints());
        values.put(DbHelper.COLUMN_CHAR_STAMINA, character.getStamina());
        values.put(DbHelper.COLUMN_CHAR_NPC, npcInt);

        database.update(DbHelper.TABLE_CHARLIST, values, DbHelper.COLUMN_CHAR_ID + "=" + character.getId(), null);
    }

    public void deleteDatabase(){
        database.delete(DbHelper.TABLE_CHARLIST,null,null);
    }

    private Character populateCharacters(Cursor cursor){
        int idIndex = cursor.getColumnIndex(DbHelper.COLUMN_CHAR_ID);
        int nameIndex = cursor.getColumnIndex(DbHelper.COLUMN_CHAR_NAME);
        int hpIndex = cursor.getColumnIndex(DbHelper.COLUMN_CHAR_HP);
        int staminaIndex = cursor.getColumnIndex(DbHelper.COLUMN_CHAR_STAMINA);
        int npcIndex = cursor.getColumnIndex(DbHelper.COLUMN_CHAR_NPC);


        Character character = new Character(cursor.getString(nameIndex));
        character.setId(cursor.getInt(idIndex));
        character.setHealthPoints(cursor.getInt(hpIndex));
        character.setStamina(cursor.getInt(staminaIndex));
        character.setNpc(cursor.getInt(npcIndex));

        return character;
    }

}

