package com.aamir.game.state;

import com.aamir.game.Game;

public class PurchaseWeaponState implements State {

    private Game game;

    public PurchaseWeaponState(Game game) {
        this.game = game;
    }

    @Override
    public void startGame() {
    }

    @Override
    public void purchaseWeapon() {

    }

    @Override
    public void startFight() {
        game.setState(game.getFightState());
        game.getMacroCommand().fillFightCommands();
    }
}
