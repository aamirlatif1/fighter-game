package com.aamir.game.play.state;

import com.aamir.game.play.Game;

public class FightState implements State {

    private Game game;

    public FightState(Game game) {
        this.game = game;
    }

    @Override
    public void startGame() {
        game.setState(game.getStartedSate());
        game.getMenuManager().gameStartedCommands();
    }


    @Override
    public void purchaseWeapon() {
        game.setState(game.getPurchaseWeaponState());
        game.getMenuManager().fillWeaponPurchaseCommands();
    }
}
