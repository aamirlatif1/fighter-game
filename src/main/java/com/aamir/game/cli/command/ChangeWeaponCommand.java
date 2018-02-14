package com.aamir.game.cli.command;

import com.aamir.game.Game;
import com.aamir.game.cli.out.Logger;
import com.aamir.game.cli.out.LoggerFactory;

public class ChangeWeaponCommand implements Command {

    private Game game;
    private Logger logger = LoggerFactory.getLogger();
    private int weaponIndex;

    public ChangeWeaponCommand(Game game, int weaponIndex) {
        this.game = game;
        this.weaponIndex = weaponIndex;
    }

    @Override
    public void execute() {
        game.changeWeapon(weaponIndex);
        logger.log("Weapon changed.");
    }

    @Override
    public String toString() {
        return game.getPlayer().getWeapons().get(weaponIndex).getName();
    }
}
