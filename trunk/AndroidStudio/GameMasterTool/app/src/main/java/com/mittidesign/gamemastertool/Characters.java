package com.mittidesign.gamemastertool;

/**
 Each object represents a character
 */
public class Characters {
    private long id;
    private String name;
    private int healthPoints = 0;
    private int initiative = 0;
    private int stamina = 0;
    private int npc = 1;

    public Characters(String name) {  //old contructor , int healthPoints, int initiative, int stamina, int npc
        this.name = name;
        /*this.healthPoints = healthPoints;
        this.initiative = initiative;
        this.stamina = stamina;
        this.npc = npc;*/
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

    public int isNpc() {
        return npc;
    }

    public void setNpc(int npc) {
        this.npc = npc;
    }
}
