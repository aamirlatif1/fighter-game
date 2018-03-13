package com.aamir.game.cli.command;

import com.aamir.game.play.Game;

public class StartFightCommand implements Command {

    private Game game;

    public StartFightCommand(Game game) {
        this.game = game;
    }

    @Override
    public void execute() {
        game.startFight();
    }

    @Override
    public String toString() {
        return "Start fight";
    }
}
