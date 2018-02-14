package com.aamir.game.state;

import com.aamir.game.Game;
import com.aamir.game.cli.out.Logger;
import com.aamir.game.cli.out.LoggerFactory;

public class NotStartedState implements State {

    private Game game;
    Logger logger = LoggerFactory.getLogger();

    public NotStartedState(Game game) {
        this.game = game;
    }

    @Override
    public void startGame() {
        game.setState(game.getStartedSate());
        game.getMacroCommand().fillGameStartCommands();
        logger.debug(" going to start");
    }


    @Override
    public void purchaseWeapon() {

    }

    @Override
    public void startFight() {

    }
}
