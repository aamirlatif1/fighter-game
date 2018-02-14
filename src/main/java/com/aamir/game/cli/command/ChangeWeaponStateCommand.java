package com.aamir.game.cli.command;

import com.aamir.game.Game;

public class ChangeWeaponStateCommand implements Command {

    private Game game;

    public ChangeWeaponStateCommand(Game game) {
        this.game = game;
    }

    @Override
    public void execute() {
        game.setState(game.getPurchaseWeaponState());
        game.getMacroCommand().fillChangeWeaponCommands();
    }

    @Override
    public String toString() {
        return "Change Weapon" ;
    }
}
