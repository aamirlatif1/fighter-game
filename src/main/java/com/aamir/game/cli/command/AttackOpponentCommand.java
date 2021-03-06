package com.aamir.game.cli.command;

import com.aamir.game.play.Game;

public class AttackOpponentCommand implements Command {
    private Game game;

    public AttackOpponentCommand(Game game) {
        this.game = game;
    }

    @Override
    public void execute() {
        game.getFight().attackWithSelectedWeapon();
        if(game.getFight().finished()){
            game.getState().startGame();
        }
    }

    @Override
    public String toString() {
        return "Attack opponent";
    }
}
