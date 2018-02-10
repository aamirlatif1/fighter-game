package com.aamir.game.model;

public class Level {
    private int number;
    private int exerienceRequired;

    public Level(int number, int exerienceRequired) {
        this.number = number;
        this.exerienceRequired = exerienceRequired;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getExerienceRequired() {
        return exerienceRequired;
    }

    public void setExerienceRequired(int exerienceRequired) {
        this.exerienceRequired = exerienceRequired;
    }
}
