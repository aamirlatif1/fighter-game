package com.aamir.game.model;


import com.aamir.game.model.Weapon;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private final String displayName;
    private int health;
    private int coins;
    private List<Weapon> weapons;
    private boolean killed;
    private int experience;
    private int currentLevel;
    private int selectedWeaponIndex;

    public Player(String displayName) {
        this.displayName = displayName;
        health = 100;
        coins = 50;
        currentLevel = 1;
        selectedWeaponIndex = 0;
    }

    public int getCoins() {
        return this.coins;
    }

    public int getHealth() {
        return this.health;
    }

    public void setCoins(int coins) {
        this.coins = coins;
    }

    public List<Weapon> getWeapons() {
        return weapons;
    }

    public void reduceHealth(int damage) {
        health -= damage;
        if (health <= 0){
            killed = true;
            health = 0;
        }
    }

    public boolean isKilled() {
        return this.killed;
    }

    public int getExperience() {
        return this.experience;
    }

    public void increaseExperience(int experience) {
        this.experience += experience;
    }

    public void addWeapon(Weapon weapon) {
        if (weapons == null)
            weapons = new ArrayList<Weapon>();
        weapons.add(weapon);
    }

    public Weapon getDefenceWeapon() {
        Weapon defenceWeapon = Weapon.ZERO_DEFENCE_WEAPON;
        if(weapons != null) {
            for (Weapon weapon : weapons) {
                if (weapon.getDefence() > defenceWeapon.getDefence())
                    defenceWeapon = weapon;
            }
        }
        return defenceWeapon;
    }

    public int getCurrentLevel() {
        return this.currentLevel;
    }

    public void increaseLevel() {
        currentLevel++;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public void setCurrentLevel(int currentLevel) {
        this.currentLevel = currentLevel;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setWeapons(List<Weapon> weapons) {
        this.weapons = weapons;
    }

    public void setKilled(boolean killed) {
        this.killed = killed;
    }

    public Weapon getSelectWeapon() {
        return weapons.get(selectedWeaponIndex);
    }

    public String getDisplayName() {
        return displayName;
    }
}
