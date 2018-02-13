package com.aamir.game.cli.command;

import com.aamir.game.Game;
import com.aamir.game.cli.out.Logger;
import com.aamir.game.cli.out.LoggerFactory;
import com.aamir.game.util.FileUtil;

public class GameExitCommand implements Command {

    private Game game;
    private Logger logger = LoggerFactory.getLogger();

    @Override
    public void execute() {
        logger.log("Do you want to save game (y/n) : ");
        String decision = game.getInputReader().readString();
        if(decision.equalsIgnoreCase("y")){
            FileUtil.savePlayer(game.getPlayer());
        }
        System.exit(1);
    }
}
