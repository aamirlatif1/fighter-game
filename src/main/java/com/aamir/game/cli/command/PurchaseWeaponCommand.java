package com.aamir.game.cli.command;

import com.aamir.game.play.Game;

public class PurchaseWeaponCommand implements Command {

    private Game game;
    private int weaponId;

    public PurchaseWeaponCommand(Game game, int weaponId) {
        this.weaponId = weaponId;
        this.game = game;
    }

    @Override
    public void execute() {
        game.purchaseWeapon(weaponId);
    }

    @Override
    public String toString() {
        return game.getMetadata().getWeapons().get(weaponId).getName();
    }
}
