package com.aamir.game.state;

import com.aamir.game.Game;

public class StartedState implements State {

    private Game game;

    public StartedState(Game game) {
        this.game = game;
    }

    @Override
    public void purchaseWeapon() {
        game.setState(game.getPurchaseWeaponState());
        game.getMacroCommand().fillWeaponPurchaseCommands();
    }

    @Override
    public void startFight() {
        game.setState(game.getFightState());
        game.getMacroCommand().fillFightCommand();
    }
}
