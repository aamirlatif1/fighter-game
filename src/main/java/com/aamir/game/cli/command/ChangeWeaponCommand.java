package com.aamir.game.cli.command;

import com.aamir.game.Game;
import com.aamir.game.cli.out.Logger;
import com.aamir.game.cli.out.LoggerFactory;

public class ChangeWeaponCommand implements Command {

    private Game game;
    private Logger logger = LoggerFactory.getLogger();

    public ChangeWeaponCommand(Game game) {
        this.game = game;
    }

    @Override
    public void execute() {
        logger.log("Select weapon");
        int selectWeaponIndex = game.getInputReader().readInt();
        game.changeWeaponState(selectWeaponIndex);
    }

    @Override
    public String toString() {
        return "Change weapon";
    }
}
