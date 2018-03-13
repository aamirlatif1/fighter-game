package com.aamir.game.play.state;

import com.aamir.game.play.Game;

public class PurchaseWeaponState implements State {

    private Game game;

    public PurchaseWeaponState(Game game) {
        this.game = game;
    }

    @Override
    public void startFight() {
        game.setState(game.getFightState());
        game.getMenuManager().fillFightCommands();
    }
}
