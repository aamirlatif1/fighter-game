package com.aamir.game.cli.command;

import com.aamir.game.Game;
import com.aamir.game.cli.out.Logger;
import com.aamir.game.cli.out.LoggerFactory;

public class GameExitCommand implements Command {

    private Game game;
    private Logger logger = LoggerFactory.getLogger();

    public GameExitCommand(Game game) {
        this.game = game;
    }

    @Override
    public void execute() {
        logger.log("Do you want to save game (y/n) : ");
        String decision = game.getInputReader().readString();
        if(decision.equalsIgnoreCase("y")){
            game.saveGame();
        }
        System.exit(1);
    }

    @Override
    public String toString() {
        return "Exit";
    }
}
