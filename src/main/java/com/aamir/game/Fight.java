package com.aamir.game;

import com.aamir.game.exception.WeaponNotAvailableException;
import com.aamir.game.model.Weapon;

public class Fight {

    private final Player player;
    private final Player enemy;

    private boolean finished;

    public Fight(Player player) {
        this.player = player;
        this.enemy = new Player("Opponent");
    }

    public void start() {
        this.finished = false;
    }

    public boolean finished() {
        return finished;
    }

    public void attackWith(Weapon weapon) {
        if (!player.getWeapons().contains(weapon)) {
            throw new WeaponNotAvailableException(String.format("You have not purchase %s yet", weapon.getName()));
        }
        makeDamage(weapon, player, enemy);
        player.increaseExperience(weapon.getExperience());
    }

    public Player getEnemy() {
        return enemy;
    }

    public Player getPlayer() {
        return player;
    }

    public void counterAttack(Weapon weapon) {
        makeDamage(weapon, enemy, player);

    }

    private void makeDamage(Weapon weapon, Player attacker, Player defender) {
        Weapon defenceWeapon = defender.getDefenceWeapon();
        int damage = weapon.getDamage() - defenceWeapon.getDefence();
        if (damage > 0)
            defender.reduceHealth(weapon.getDamage());
        attacker.reduceHealth(defenceWeapon.getDamage());
        if (attacker.isKilled() || defender.isKilled())
            finished = true;
    }
}
