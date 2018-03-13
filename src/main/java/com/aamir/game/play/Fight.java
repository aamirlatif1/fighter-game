package com.aamir.game.play;

import com.aamir.game.cli.out.Logger;
import com.aamir.game.cli.out.LoggerFactory;
import com.aamir.game.exception.WeaponNotAvailableException;
import com.aamir.game.model.Player;
import com.aamir.game.model.Weapon;

import java.io.Serializable;

public class Fight implements Serializable {

    private static final Logger LOGGER = LoggerFactory.getLogger();

    private final Player player;
    private final Player opponent;
    private boolean finished;
    private Game game;

    public Fight(Game game) {
        this.game = game;
        this.player = game.getPlayer();
        this.opponent = new Player("Opponent");
        this.opponent.setSelectedWeaponIndex(0);
        if(game.getMetadata().getWeapons() == null) {
            this.opponent.addWeapon(new Weapon("Knife", 10, 10, 10, 1));
        } else {
            this.opponent.setWeapons(game.getMetadata().getWeapons());
        }
        finished = false;
    }


    public void attackWith(Weapon weapon) {
        if (!player.getWeapons().contains(weapon))
            throw new WeaponNotAvailableException(String.format("You have not purchase %s yet", weapon.getName()));

        makeDamage(weapon, player, opponent);
        makeDamage(opponent.getSelectWeapon(), opponent, player);
        player.increaseExperience(weapon.getExperience());
        updatePlayerLevel();
    }

    private void updatePlayerLevel() {
        if(game.getMetadata().getLevels().size() > player.getCurrentLevel() &&
                player.getExperience() >= game.getMetadata().getLevels().get(player.getCurrentLevel()).getExperienceRequired()) {
            player.increaseLevel();
            player.setCoins(game.getMetadata().getLevels().get(player.getCurrentLevel()-1).getAvailableCoins());
            LOGGER.log("You have reached Level : %d",player.getCurrentLevel());
        }
    }

    private void makeDamage(Weapon weapon, Player attacker, Player defender) {
        defender.reduceHealth(weapon.getDamage());
        LOGGER.log("%s made %d damage to opponent and gained %d experience",
                player.getDisplayName(), weapon.getDamage(), weapon.getExperience());
        if (attacker.isKilled()) {
            finished = true;
            LOGGER.log("%s is killed. Fight is over", attacker.getDisplayName());
        }
        if (defender.isKilled()) {
            finished = true;
            LOGGER.log("%s is killed. Fight is over", defender.getDisplayName());
        }

        if(!finished)
            LOGGER.log("%s has health : %d, %s has health : %d", attacker.getDisplayName(), attacker.getHealth(),
                    defender.getDisplayName(), defender.getHealth());


    }

    public void attackWithSelectedWeapon() {
        attackWith(player.getSelectWeapon());
    }

    public void counterAttackWith(Weapon weapon) {
        makeDamage(weapon, opponent, player);
    }

    public boolean finished() {
        return finished;
    }

    public Player getOpponent() {
        return opponent;
    }

    public Player getPlayer() {
        return player;
    }

}
