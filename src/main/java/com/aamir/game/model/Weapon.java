package com.aamir.game.model;

import java.io.Serializable;

public class Weapon implements Serializable {

    public static final  Weapon ZERO_DEFENCE_WEAPON = new Weapon("No Defence", 0, 0, 0, 1);

    private String name;
    private int price;
    private int damage;
    private int experience;
    private int level;

    public Weapon(String name, int price, int damage, int experience, int level) {
        this.name = name;
        this.price = price;
        this.damage = damage;
        this.experience = experience;
        this.level = level;
    }

    public String getName() {
        return name;
    }


    public int getDamage() {
        return damage;
    }

    public int getPrice() {
        return price;
    }

    public int getExperience() {
        return this.experience;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getLevel() {
        return level;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Weapon weapon = (Weapon) o;
        return name.equals(weapon.name);
    }

    @Override
    public String toString() {
        return "Weapon{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", damage=" + damage +
                ", experience=" + experience +
                ", level=" + level +
                '}';
    }
}
