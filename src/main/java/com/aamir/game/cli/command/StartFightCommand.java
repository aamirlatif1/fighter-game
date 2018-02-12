package com.aamir.game.cli.command;

import com.aamir.game.Game;

public class StartFightCommand implements Command {

    private Game game;

    public StartFightCommand(Game game) {
        this.game = game;
    }

    @Override
    public void execute() {
        game.startFight();
    }
}
