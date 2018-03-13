package com.aamir.game.play.state;

import com.aamir.game.play.Game;
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
        game.getMenuManager().fillGameStartCommands();
        logger.debug(" going to start");
    }

}
