package com.aamir.game.model;

public class Level {
    private int number;
    private int experienceRequired;
    private int availableCoins;

    public Level(int number, int experienceRequired, int availableCoins) {
        this.number = number;
        this.experienceRequired = experienceRequired;
        this.availableCoins = availableCoins;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getExperienceRequired() {
        return experienceRequired;
    }

    public void setExperienceRequired(int experienceRequired) {
        this.experienceRequired = experienceRequired;
    }

    public int getAvailableCoins() {
        return availableCoins;
    }

    public void setAvailableCoins(int availableCoins) {
        this.availableCoins = availableCoins;
    }
}
