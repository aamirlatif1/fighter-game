package com.aamir.game;

import com.aamir.game.exception.InsufficientCoinsException;
import com.aamir.game.model.Weapon;


public class Game {

    public void purchaseWeapon(Player player, Weapon weapon) {
        player.setCoins(player.getCoins() - weapon.getPrice());
        if(player.getCoins() < weapon.getPrice())
            throw new InsufficientCoinsException("You have not enough coins to purchase : "+weapon.getName());
        player.addWeapon(weapon);
    }

}
