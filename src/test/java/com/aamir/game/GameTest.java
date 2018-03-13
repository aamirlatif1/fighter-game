package com.aamir.game;

import com.aamir.game.cli.in.ConsoleReader;
import com.aamir.game.cli.in.InputReader;
import com.aamir.game.exception.InsufficientCoinsException;
import com.aamir.game.exception.WeaponNotAvailableException;
import com.aamir.game.model.Weapon;
import com.aamir.game.play.Fight;
import com.aamir.game.play.Game;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GameTest {

    static InputReader inputReader = new ConsoleReader();
    Game game = new Game(inputReader);
    static Weapon knife = new Weapon("Knife", 10, 10, 10, 1);
    static Weapon spear = new Weapon("Spear", 20, 15, 15, 2);
    static Weapon sword = new Weapon("Sword", 60, 25, 20, 3);


    @Before
    public void setUp() throws Exception {
        game.start("Aamir");
    }

    @Test
    public void purchaseWeapon() throws Exception {
        game.purchaseWeapon(spear);
        assertEquals(30, game.getPlayer().getCoins());
        assertEquals(2, game.getPlayer().getWeapons().size());
    }

    @Test(expected = InsufficientCoinsException.class)
    public void insufficientBalanceOnPurchase() throws Exception {
        game.purchaseWeapon(sword);
    }

    @Test(expected = WeaponNotAvailableException.class)
    public void attackWithNotAvailableWeapon() throws Exception {
        game.purchaseWeapon(knife);
        Fight fight = new Fight(game);
        fight.attackWith(spear);
    }

    @Test
    public void startFight() throws Exception {
        Fight fight = new Fight(game);
        assertFalse(fight.finished());
    }
    
    @Test
    public void attackEnemyWithKnife() throws Exception {
        game.purchaseWeapon(knife);
        Fight fight = new Fight(game);
        fight.attackWith(knife);
        assertEquals(90, fight.getOpponent().getHealth());
        assertEquals(10, fight.getPlayer().getExperience());
    }

    @Test
    public void killEnemy() throws Exception {
        game.purchaseWeapon(knife);
        game.startFight();
        Fight fight = game.getFight();
        for(int i = 0; i < 10; i++)
            fight.attackWith(knife);
        assertEquals(0, fight.getOpponent().getHealth());
        assertTrue(fight.getOpponent().isKilled());
    }

    @Test
    public void counterAttack() throws Exception {
        game.purchaseWeapon(knife);
        Fight fight = new Fight(game);
        fight.counterAttackWith(knife);
        assertEquals(90, fight.getPlayer().getHealth());
    }


    @Test
    public void increaseLevelOfPlayer() throws Exception {
        assertEquals(1, game.getPlayer().getCurrentLevel());
        game.purchaseWeapon(spear);
        Fight fight = new Fight(game);
        for(int i = 0; i < 4; i++)
            fight.attackWith(knife);
        assertEquals(3, game.getPlayer().getCurrentLevel());
    }


}
