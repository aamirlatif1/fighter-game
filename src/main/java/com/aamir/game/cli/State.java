package com.aamir.game.cli;

public interface State {
    default void startGame(){ }
    default void loadGame(){}
    default void purchaseWeapon(){}
    default void startFight(){}
}
