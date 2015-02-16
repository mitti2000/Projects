package com.mittidesign.initiativemanager;

public class Character {
    private long id;
    private String name;
    private int healthPoints;
    private int initiative;
    private int stamina;
    private boolean npc;

    //Constructor for Database
    public Character(String name){
        this.name = name;
        healthPoints = 0;
        initiative = 0;
    }

    //Constructor for Battle
    public Character(String name, boolean npc, int healthPoints, int stamina){
        this.name = name;
        this.npc = npc;
        this.healthPoints = healthPoints;
        this.stamina = stamina;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public void setHealthPoints(int healthPoints) {
        this.healthPoints = healthPoints;
    }

    public int getInitiative() {
        return initiative;
    }

    public void setInitiative(int initiative) {
        this.initiative = initiative;
    }

    public int getStamina() {
        return stamina;
    }

    public void setStamina(int stamina) {
        this.stamina = stamina;
    }

    public boolean isNpc() {
        return npc;
    }

    public void setNpc(int npc) {
        if(npc>0) this.npc=true;
        else this.npc=false;
    }
}
