package com.aamir.game.cli.command;

import com.aamir.game.Game;

public class NewGameStartCommand implements UserCommand {
    private Game game;

    public NewGameStartCommand(Game game) {
        this.game = game;
    }

    @Override
    public void execute() {
        game.start();
    }

    @Override
    public String toString() {
        return "Start new game";
    }
}
