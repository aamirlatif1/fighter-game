package com.aamir.game.cli.command;

import com.aamir.game.play.Game;

public class PurchaseWeaponStateCommand implements Command {

    private Game game;

    public PurchaseWeaponStateCommand(Game game) {
        this.game = game;
    }

    @Override
    public void execute() {
        game.purchaseWeaponState();
    }

    @Override
    public String toString() {
        return "Purchase weapon";
    }
}
