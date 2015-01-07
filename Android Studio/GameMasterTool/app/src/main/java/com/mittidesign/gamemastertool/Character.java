package com.mittidesign.gamemastertool;

public class Character {
    private long id;
    private String active;
    private String name;
    private int healthPoints = 0;
    private int initiative = 0;
    private int stamina = 0;
    private String npc;

    //Constructor
    public Character(String name, int healthPoints, int stamina, String npc) {
        super();
        this.active = "";
        this.name = name;
        this.initiative = 0;
        this.healthPoints = healthPoints;
        this.stamina = stamina;
        this.npc = npc;
    }
    //ID
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    //Active
    public String getActive() {
        return active;
    }
    public void setActive() {
        this.active = "X";
    }
    public void clearActive() {
        this.active = "";
    }
    //Name
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    //HP
    public int getHealthPoints() {
        return healthPoints;
    }
    public void setHealthPoints(int healthPoints) {
        this.healthPoints = healthPoints;
    }
    //Initiative
    public int getInitiative() {
        return initiative;
    }
    public void setInitiative(int initiative) {
        this.initiative = initiative;
    }
    //Stamina
    public int getStamina() {
        return stamina;
    }
    public void setStamina(int stamina) {
        this.stamina = stamina;
    }
    //NPC
    public String getNpc() {
        return npc;
    }
    public void setNpc() {
        this.npc = "X";
    }
    public void clearNPC(){
        this.npc = "";
    }

}