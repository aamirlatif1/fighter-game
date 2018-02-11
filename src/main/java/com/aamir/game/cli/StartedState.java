package com.aamir.game.cli;

import com.aamir.game.Game;

public class StartedState implements State {

    private Game game;

    public StartedState(Game game) {
        this.game = game;
    }

    @Override
    public void startGame() {

    }

    @Override
    public void loadGame() {

    }

    @Override
    public void purchaseWeapon() {

    }

    @Override
    public void startFight() {

    }
}