package com.aamir.game.cli.command;

import com.aamir.game.Game;
import com.aamir.game.cli.in.ConsoleReader;
import com.aamir.game.cli.in.InputReader;
import com.aamir.game.cli.out.Logger;
import com.aamir.game.cli.out.LoggerFactory;


public class GameStartCommand implements Command {

    Logger logger = LoggerFactory.getLogger();
    private Game game;
    public GameStartCommand(Game game) {
        this.game = game;
    }

    @Override
    public void execute() {
        logger.log("Enter player name : ");
        String name = game.getInputReader().readString();
        game.start(name);
    }
}
