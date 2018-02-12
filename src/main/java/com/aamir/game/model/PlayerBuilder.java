package com.aamir.game.model;

import java.util.List;

public class PlayerBuilder {
    private String displayName;
    private int health = 100;
    private int coins;
    private List<Weapon> weapons;
    private boolean killed = false;
    private int experience;
    private int level;
    private List<Integer> weaponIds;

    public static PlayerBuilder builder(String name) {
        return new PlayerBuilder(name);
    }
    private PlayerBuilder(String name){
        this.displayName = name;
    }

    public PlayerBuilder withHealth(int health){
        this.health = health;
        return this;
    }

    public PlayerBuilder withCoins(int coins){
        this.coins = coins;
        return this;
    }

    public PlayerBuilder withWeapons(List<Weapon> weapons){
        this.weapons = weapons;
        return this;
    }

    public PlayerBuilder withExperience(int experience){
        this.experience = experience;
        return this;
    }

    public PlayerBuilder withLevel(int level){
        this.level = level;
        return this;
    }

    public PlayerBuilder withKilled(boolean killed){
        this.killed = killed;
        return this;
    }

    public PlayerBuilder withWeaponIds(List<Integer> weaponIds){
        this.killed = killed;
        return this;
    }

    public Player build(){
        Player player = new Player(displayName);
        player.setCoins(coins);
        player.setExperience(experience);
        player.setCurrentLevel(level);
        player.setHealth(health);
        player.setWeapons(weapons);
        player.setKilled(killed);
        return player;
    }

}
