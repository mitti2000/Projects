package com.mittidesign.initiativemanager;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import java.util.ArrayList;

public class FightListDataSource extends DataSource{

    private String[] columns = { //Columns in Table
            DbHelper.COLUMN_FIGHT_ID,
            DbHelper.COLUMN_FIGHT_ACTIVE,
            DbHelper.COLUMN_FIGHT_NAME,
            DbHelper.COLUMN_FIGHT_INITIATIVE,
            DbHelper.COLUMN_FIGHT_HP,
            DbHelper.COLUMN_FIGHT_STAMINA,
            DbHelper.COLUMN_FIGHT_NPC
    };



    //Constructor
    public FightListDataSource(Context context){
        super(context);
    }


    public Character createCharacter(String name, int initiative, int hp, int stamina, boolean npc){
        String active = "";

        int npcInt;
        if(npc) npcInt=1;
        else npcInt=0;

        ContentValues values = new ContentValues();
        values.put(DbHelper.COLUMN_FIGHT_ACTIVE, active);
        values.put(DbHelper.COLUMN_FIGHT_NAME, name);
        values.put(DbHelper.COLUMN_FIGHT_INITIATIVE, initiative);
        values.put(DbHelper.COLUMN_FIGHT_HP, hp);
        values.put(DbHelper.COLUMN_FIGHT_STAMINA, stamina);
        values.put(DbHelper.COLUMN_FIGHT_NPC, npcInt);

        long insertId = database.insert(DbHelper.TABLE_FIGHTLIST,null,values);

        Cursor cursor = database.query(DbHelper.TABLE_FIGHTLIST,
                columns,
                DbHelper.COLUMN_FIGHT_ID + "=" + insertId,
                null,null,null,null);
        cursor.moveToFirst();

        Character character;
        character = populateCharacters(cursor);
        cursor.close();
        return character;
    }


    public ArrayList<Character> getAllCharacters(){
        String sortOrder = DbHelper.COLUMN_FIGHT_NAME + " DESC";
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
                DbHelper.TABLE_FIGHTLIST,
                columns,
                null,null,null,null,
                sortOrder
        );
        chars = new ArrayList<Character>();

        cursor.moveToPosition(-1);
        while(cursor.moveToNext()){
            indexID = cursor.getColumnIndex(DbHelper.COLUMN_FIGHT_ID);
            indexActive = cursor.getColumnIndex(DbHelper.COLUMN_FIGHT_ACTIVE);
            indexName =cursor.getColumnIndex(DbHelper.COLUMN_FIGHT_NAME);
            indexInitiative =cursor.getColumnIndex(DbHelper.COLUMN_FIGHT_INITIATIVE);
            indexHP = cursor.getColumnIndex(DbHelper.COLUMN_FIGHT_HP);
            indexStamina = cursor.getColumnIndex(DbHelper.COLUMN_FIGHT_STAMINA);
            indexNpc = cursor.getColumnIndex(DbHelper.COLUMN_FIGHT_NPC);

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
        database.delete(DbHelper.TABLE_FIGHTLIST,null,null);
    }

    private Character populateCharacters(Cursor cursor){
        int idIndex = cursor.getColumnIndex(DbHelper.COLUMN_FIGHT_ID);
        int activeIndex = cursor.getColumnIndex(DbHelper.COLUMN_FIGHT_ACTIVE);
        int nameIndex = cursor.getColumnIndex(DbHelper.COLUMN_FIGHT_NAME);
        int initiativeIndex = cursor.getColumnIndex(DbHelper.COLUMN_FIGHT_INITIATIVE);
        int hpIndex = cursor.getColumnIndex(DbHelper.COLUMN_FIGHT_HP);
        int staminaIndex = cursor.getColumnIndex(DbHelper.COLUMN_FIGHT_STAMINA);
        int npcIndex = cursor.getColumnIndex(DbHelper.COLUMN_FIGHT_NPC);


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
