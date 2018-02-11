package com.aamir.game.cli;

public interface State {
    void startGame();
    void loadGame();
    void purchaseWeapon();
    void startFight();
    //STARTED, FIGHT_IN_PROGRESS, PURCHASE_WEAPON
}
