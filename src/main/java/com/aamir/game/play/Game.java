package com.aamir.game.play;

import com.aamir.game.cli.command.MenuManager;
import com.aamir.game.cli.in.InputReader;
import com.aamir.game.cli.out.Logger;
import com.aamir.game.cli.out.LoggerFactory;
import com.aamir.game.exception.InsufficientCoinsException;
import com.aamir.game.model.GameMetadata;
import com.aamir.game.model.Player;
import com.aamir.game.model.Weapon;
import com.aamir.game.play.Fight;
import com.aamir.game.play.state.*;
import com.aamir.game.util.*;


public class Game {

    private static final Logger LOGGER = LoggerFactory.getLogger();

    private Player player;
    private State state;
    private State notStartedState;
    private State startedSate;
    private State purchaseWeaponState;
    private State fightState;
    private MenuManager menuManager;
    private Fight fight;
    private InputReader inputReader;
    private GameMetadata metadata;

    public Game(InputReader inputReader) {
        this.inputReader = inputReader;
        notStartedState = new NotStartedState(this);
        startedSate = new StartedState(this);
        purchaseWeaponState = new PurchaseWeaponState(this);
        fightState = new FightState(this);
        state = new NotStartedState(this);
        menuManager = new MenuManager(this);
    }

    public void start(String playerName) {
        metadata = new GameMetadata();
        player = new Player(playerName);
        player.addWeapon(metadata.getDefaultWeapon());
        state = startedSate;
        state.startGame();
        LOGGER.log("Naw game Started");
    }

    public void loadGameState() {
        player = FileUtil.loadPlayer();
        state = startedSate;
        state.startGame();
        LOGGER.log("Game has been loaded");
    }

    public void purchaseWeapon(Weapon weapon) {
        if(player.getCoins() < weapon.getPrice())
            throw new InsufficientCoinsException("You have not enough coins to purchase : "+weapon.getName());
        player.setCoins(player.getCoins() - weapon.getPrice());
        player.addWeapon(weapon);
    }

    public void purchaseWeapon(int index){
        try {
            purchaseWeapon(metadata.getWeapon(index));
            LOGGER.log("You successfully purchase weapon");
        }catch (InsufficientCoinsException ex){
            LOGGER.log(ex.getMessage());
        }
    }

    public void startFight() {
        fight = new Fight(this);
        state.startFight();
        LOGGER.log("Fight Started");
    }

    public Player getPlayer() {
        return player;
    }

    public State getState() {
        return state;
    }

    public State getNotStartedState() {
        return notStartedState;
    }

    public State getStartedSate() {
        return startedSate;
    }

    public State getPurchaseWeaponState() {
        return purchaseWeaponState;
    }

    public State getFightState() {
        return fightState;
    }

    public void setState(State state) {
        this.state = state;
    }

    public void purchaseWeaponState() {
        state.purchaseWeapon();
    }

    public MenuManager getMenuManager() {
        return menuManager;
    }

    public Fight getFight() {
        return fight;
    }

    public InputReader getInputReader() {
        return inputReader;
    }

    public void saveGame() {
        FileUtil.savePlayer(this.getPlayer());
    }

    public GameMetadata getMetadata() {
        return metadata;
    }
}
