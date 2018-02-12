package com.aamir.game;

import com.aamir.game.exception.InsufficientCoinsException;
import com.aamir.game.exception.WeaponNotAvailableException;
import com.aamir.game.model.Player;
import com.aamir.game.model.Weapon;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GameTest {

    static Game game = new Game();
    static Weapon knife = new Weapon("Knife", 10, 10, 0);
    static Weapon spear = new Weapon("Spear", 20, 20, 0);
    static Weapon shield = new Weapon("Shield", 30, 5, 10);
    static Weapon armour = new Weapon("Armour", 60, 0, 30);

    Player player;

    @Before
    public void setUp() throws Exception {
        player = new Player("Aamir");
    }

    @Test
    public void hasPlayer() throws Exception {
        assertEquals(50, player.getCoins());
        assertEquals(100, player.getHealth());
    }

    @Test
    public void hasWeapon() throws Exception {
        assertEquals(10, knife.getPrice());
        assertEquals(10, knife.getDamage());
        assertEquals(0, knife.getDefence());
    }

    @Test
    public void purchaseWeapon() throws Exception {
        game.purchaseWeapon(player, knife);
        assertEquals(40, player.getCoins());
        assertEquals(1, player.getWeapons().size());
    }

    @Test(expected = InsufficientCoinsException.class)
    public void insufficientBalanceOnPurchase() throws Exception {
        game.purchaseWeapon(player, armour);
    }

    @Test(expected = WeaponNotAvailableException.class)
    public void attackWithNotAvailableWeapon() throws Exception {
        game.purchaseWeapon(player, knife);
        Fight fight = new Fight(player);
        fight.attackWith(spear);
    }

    @Test
    public void startFight() throws Exception {
        Fight fight = new Fight(player);
        assertFalse(fight.finished());
    }
    
    @Test
    public void attackEnemyWithKnife() throws Exception {
        game.purchaseWeapon(player, knife);
        Fight fight = new Fight(player);
        fight.attackWith(knife);
        assertEquals(90, fight.getEnemy().getHealth());
        assertEquals(1, fight.getPlayer().getExperience());
    }

    @Test
    public void killEnemy() throws Exception {
        game.purchaseWeapon(player, knife);
        Fight fight = new Fight(player);
        for(int i = 0; i < 10; i++)
            fight.attackWith(knife);
        assertEquals(0, fight.getEnemy().getHealth());
        assertTrue(fight.getEnemy().isKilled());
    }

    @Test
    public void counterAttack() throws Exception {
        game.purchaseWeapon(player, knife);
        Fight fight = new Fight(player);
        fight.counterAttackWith(knife);
        assertEquals(90, fight.getPlayer().getHealth());
    }

    @Test
    public void attachWithOnEnemyWithShield() throws Exception {
        game.purchaseWeapon(player, knife);
        Fight fight = new Fight(player);
        fight.getEnemy().addWeapon(shield);
        fight.attackWith(knife);
        assertEquals(100, fight.getEnemy().getHealth());
        assertEquals(95, fight.getPlayer().getHealth());
    }

    @Test
    public void increaseLevelOfPlayer() throws Exception {
        assertEquals(1, player.getCurrentLevel());
        game.purchaseWeapon(player, knife);
        Fight fight = new Fight(player);
        for(int i = 0; i < 10; i++)
            fight.attackWith(knife);
        assertEquals(2, player.getCurrentLevel());
    }


}
