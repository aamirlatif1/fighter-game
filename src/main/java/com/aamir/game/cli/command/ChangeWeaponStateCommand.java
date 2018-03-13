package com.aamir.game.cli.command;

import com.aamir.game.play.Game;

public class ChangeWeaponStateCommand implements Command {

    private Game game;

    public ChangeWeaponStateCommand(Game game) {
        this.game = game;
    }

    @Override
    public void execute() {
        game.setState(game.getPurchaseWeaponState());
        game.getMenuManager().fillChangeWeaponCommands();
    }

    @Override
    public String toString() {
        return "Change Weapon" ;
    }
}
