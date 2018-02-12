package com.aamir.game.state;

import com.aamir.game.Game;

public class FightState implements State {

    private Game game;

    public FightState(Game game) {
        this.game = game;
    }

    @Override
    public void startGame() {
        game.setState(game.getStartedSate());
        game.getMacroCommand().fillStartedCommands();
    }


    @Override
    public void purchaseWeapon() {
        game.setState(game.getPurchaseWeaponState());
        game.getMacroCommand().fillWeaponPurchaseCommands();
    }
}
