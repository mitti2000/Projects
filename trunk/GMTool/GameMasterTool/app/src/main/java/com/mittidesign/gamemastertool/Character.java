package com.mittidesign.gamemastertool;

public class Character {
    private long id;
    private String active;
    private String name;
    private int healthPoints = 0;
    private int initiative = 0;
    private int stamina = 0;
    private String npc;

    public Character(String active, String name, int initiative, int healthPoints, int stamina, String npc) {
        super();
        this.active = active;
        this.name = name;
        this.initiative = initiative;
        this.healthPoints = healthPoints;
        this.stamina = stamina;
        this.npc = npc;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
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

    public String getNpc() {
        return npc;
    }

    public void setNpc(String npc) {
        this.npc = npc;
    }

}