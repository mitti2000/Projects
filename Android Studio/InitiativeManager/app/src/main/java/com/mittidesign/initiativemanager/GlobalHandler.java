package com.mittidesign.initiativemanager;


public class GlobalHandler {

    public static Character charListEntry;
    public static Character editChar;
    private static Character addToFightList;
    private static int amountToAdd;

    public static void createCharListEntry(String name, int hp, int stamina, boolean npc){
        charListEntry = new Character(name, npc, hp, stamina);
    }

    public static void editableChar(Character character) {
        editChar = character;
    }

    public static Character getFightListCharacter(){
        return addToFightList;
    }

    public static void setFightListCharacter(Character character){
        addToFightList = character;
    }

    public static void setAmountToAdd(int amount){
        amountToAdd = amount;
    }

    public static int getAmountToAdd(){
        return amountToAdd;
    }

}
