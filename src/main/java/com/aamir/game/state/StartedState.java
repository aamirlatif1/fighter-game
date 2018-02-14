package com.aamir.game.state;

import com.aamir.game.Game;
import com.aamir.game.cli.out.Logger;
import com.aamir.game.cli.out.LoggerFactory;

public class StartedState implements State {

    private Game game;
    private Logger logger = LoggerFactory.getLogger();
    public StartedState(Game game) {
        this.game = game;
    }


    @Override
    public void startGame() {
        logger.debug("game has been started");
        game.getMacroCommand().gameStartedCommands();
    }

    @Override
    public void purchaseWeapon() {
        game.setState(game.getPurchaseWeaponState());
        game.getMacroCommand().fillWeaponPurchaseCommands();
    }

    @Override
    public void startFight() {
        game.setState(game.getFightState());
        game.getMacroCommand().fillFightCommands();
    }


}
