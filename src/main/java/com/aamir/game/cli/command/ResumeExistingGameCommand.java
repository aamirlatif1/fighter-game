package com.aamir.game.cli.command;

import com.aamir.game.Game;

public class ResumeExistingGameCommand implements UserCommand {
    private Game game;

    public ResumeExistingGameCommand(Game game) {
        this.game = game;
    }

    @Override
    public void execute() {
        game.loadGameState();
    }

    @Override
    public String toString() {
        return "Resume existing game";
    }
}
