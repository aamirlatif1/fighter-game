package com.aamir.game.state;

import java.io.Serializable;

public interface State extends Serializable {
    default void startGame(){ }
    default void loadGame(){}
    default void purchaseWeapon(){}
    default void startFight(){}
}
