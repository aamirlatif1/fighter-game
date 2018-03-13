package com.aamir.game.play.state;

import com.aamir.game.play.Game;
import com.aamir.game.cli.out.Logger;
import com.aamir.game.cli.out.LoggerFactory;

public class StartedState implements State {

    private Game game;
    private static final Logger LOGGER = LoggerFactory.getLogger();

    public StartedState(Game game) {
        this.game = game;
    }


    @Override
    public void startGame() {
        LOGGER.debug("game has been started");
        game.getMenuManager().gameStartedCommands();
    }

    @Override
    public void purchaseWeapon() {
        game.setState(game.getPurchaseWeaponState());
        game.getMenuManager().fillWeaponPurchaseCommands();
    }

    @Override
    public void startFight() {
        game.setState(game.getFightState());
        game.getMenuManager().fillFightCommands();
    }


}
