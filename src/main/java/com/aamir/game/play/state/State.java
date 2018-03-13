package com.aamir.game.play.state;

import java.io.Serializable;

public interface State extends Serializable {
    default void startGame(){ }
    default void purchaseWeapon(){}
    default void startFight(){}
    default void changeWeapon(){}
}
