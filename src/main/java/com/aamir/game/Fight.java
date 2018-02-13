package com.aamir.game;

import com.aamir.game.cli.out.Logger;
import com.aamir.game.cli.out.LoggerFactory;
import com.aamir.game.exception.WeaponNotAvailableException;
import com.aamir.game.model.Player;
import com.aamir.game.model.Weapon;

import java.io.Serializable;

public class Fight implements Serializable {



    private final Player player;
    private final Player opponent;
    private boolean finished;
    Logger logger = LoggerFactory.getLogger();

    public Fight(Player player) {
        this.player = player;
        this.opponent = new Player("Opponent");
        finished = false;
    }


    public boolean finished() {
        return finished;
    }

    public void attackWith(Weapon weapon) {
        if (!player.getWeapons().contains(weapon)) {
            throw new WeaponNotAvailableException(String.format("You have not purchase %s yet", weapon.getName()));
        }
        makeDamage(weapon, player, opponent);
        player.increaseExperience(weapon.getExperience());
        if(player.getExperience() >= 10)
            player.increaseLevel();
    }

    public Player getOpponent() {
        return opponent;
    }

    public Player getPlayer() {
        return player;
    }

    public void counterAttackWith(Weapon weapon) {
        makeDamage(weapon, opponent, player);
    }

    private void makeDamage(Weapon weapon, Player attacker, Player defender) {
        Weapon defenceWeapon = defender.getDefenceWeapon();
        int damage = weapon.getDamage() - defenceWeapon.getDefence();
        if (damage > 0)
            defender.reduceHealth(weapon.getDamage());
        attacker.reduceHealth(defenceWeapon.getDamage());
        logger.log("%s made %d damage to opponent and gained %d experience",
                player.getDisplayName(), damage, weapon.getExperience());
        if (attacker.isKilled()) {
            finished = true;
            logger.log("%s is killed. Fight is over", attacker.getDisplayName());
        }
        if (defender.isKilled()) {
            finished = true;
            logger.log("%s is killed. Fight is over", defender.getDisplayName());
        }
        if(!finished){
            logger.log("%s has health : %d, %s has health : %d", attacker.getDisplayName(), attacker.getHealth(),
                    defender.getDisplayName(), defender.getHealth());
        }

    }

    public void attackWithSelectedWeapon() {
        attackWith(player.getSelectWeapon());
    }

}
