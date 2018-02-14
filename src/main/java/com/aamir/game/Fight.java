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
    private Game game;
    Logger logger = LoggerFactory.getLogger();

    public Fight(Game game) {
        this.game = game;
        this.player = game.getPlayer();
        this.opponent = new Player("Opponent");
        this.opponent.setSelectedWeaponIndex(0);
        if(game.getWeapons() == null) {
            //default weapon
            this.opponent.addWeapon(new Weapon("Knife", 10, 10, 10, 1));
        } else {
            this.opponent.setWeapons(game.getWeapons());
        }
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
        makeDamage(opponent.getSelectWeapon(), opponent, player);
        player.increaseExperience(weapon.getExperience());
        updatePlayerLevel();
    }

    private void updatePlayerLevel() {
        if(game.getLevels().size() > player.getCurrentLevel() &&
                player.getExperience() >= game.getLevels().get(player.getCurrentLevel()).getExperienceRequired()) {
            player.increaseLevel();
            player.setCoins(game.getLevels().get(player.getCurrentLevel()-1).getAvailableCoins());
            logger.log("You have reached Level : %d",player.getCurrentLevel());
        }
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
        defender.reduceHealth(weapon.getDamage());
        logger.log("%s made %d damage to opponent and gained %d experience",
                player.getDisplayName(), weapon.getDamage(), weapon.getExperience());
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
