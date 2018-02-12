package com.aamir.game.cli;

import com.aamir.game.Game;

public class StartedState implements State {

    private Game game;

    public StartedState(Game game) {
        this.game = game;
    }

    @Override
    public void purchaseWeapon() {
        game.setState(game.getPurchaseWeaponState());
    }

    @Override
    public void startFight() {
        game.setState(game.getFightState());
        game.getMacroCommand().fillFightCommand();
    }
}
