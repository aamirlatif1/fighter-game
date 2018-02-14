package com.aamir.game.cli.command;

import com.aamir.game.Game;

public class ViewPlayerCommand implements Command{

    private Game game;

    public ViewPlayerCommand(Game game) {
        this.game = game;
    }

    @Override
    public void execute() {
        game.viewPlayer();
    }

    @Override
    public String toString() {
        return "View player";
    }
}
