package com.aamir.game.cli;

import com.aamir.game.Game;

public class NotStartedState implements State {

    private Game game;

    public NotStartedState(Game game) {
        this.game = game;
    }

    @Override
    public void startGame() {
        game.setState(game.getStartedSate());
        game.getMacroCommand().fillStartedCommands();
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
