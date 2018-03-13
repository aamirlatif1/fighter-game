package com.aamir.game.cli.command;

import com.aamir.game.play.Game;
import com.aamir.game.cli.out.Logger;
import com.aamir.game.cli.out.LoggerFactory;

public class ViewPlayerCommand implements Command{

    private static final Logger LOGGER = LoggerFactory.getLogger();
    private Game game;

    public ViewPlayerCommand(Game game) {
        this.game = game;
    }

    @Override
    public void execute() {
        LOGGER.log(game.getPlayer().toString());
    }

    @Override
    public String toString() {
        return "View player";
    }
}
