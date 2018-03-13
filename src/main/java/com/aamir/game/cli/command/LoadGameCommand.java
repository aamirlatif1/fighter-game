package com.aamir.game.cli.command;

import com.aamir.game.play.Game;

public class LoadGameCommand implements Command {

    private Game game;

    public LoadGameCommand(Game game) {
        this.game = game;
    }

    @Override
    public void execute() {
        game.loadGameState();
    }

    @Override
    public String toString() {
        return "Load game";
    }
}
