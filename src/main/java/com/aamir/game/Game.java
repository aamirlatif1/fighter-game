package com.aamir.game;

import com.aamir.game.cli.*;
import com.aamir.game.cli.out.Logger;
import com.aamir.game.cli.out.LoggerFactory;
import com.aamir.game.exception.InsufficientCoinsException;
import com.aamir.game.model.Level;
import com.aamir.game.model.Player;
import com.aamir.game.model.Weapon;
import com.aamir.game.util.*;

import java.util.List;

import static com.aamir.game.util.Constants.WEAPONS_FILE_PATH;


public class Game {

    private static Logger logger = LoggerFactory.getLogger();
    private List<Weapon> weapons;
    private List<Player> opponents;
    private List<Level> levels;
    private Player player;
    private State state;
    private State notStartedState;
    private State startedSate;
    private State purchaseWeaponState;
    private State fightState;

    public Game() {
        notStartedState = new NotStartedState(this);
        startedSate = new StartedState(this);
        purchaseWeaponState = new PurchaseWeaponState(this);
        fightState = new FightState(this);
        state = new NotStartedState(this);
    }

    private void loadMetadata(){
        loadWeapons();
        loadWLevels();
        loadOpponents();
    }

    private  void loadWeapons() {
        Parser<Weapon> parser = new WeaponParser();
        List<String> data = FileUtil.readData(WEAPONS_FILE_PATH);
        weapons = parser.parse(data);
    }
    private  void loadWLevels() {
        Parser<Level> parser = new LevelParser();
        List<String> data = FileUtil.readData(WEAPONS_FILE_PATH);
        levels = parser.parse(data);
    }
    private  void loadOpponents() {
        Parser<Player> parser = new OpponentParser();
        List<String> data = FileUtil.readData(WEAPONS_FILE_PATH);
        opponents = parser.parse(data);
    }

    public void purchaseWeapon(Player player, Weapon weapon) {
        player.setCoins(player.getCoins() - weapon.getPrice());
        if(player.getCoins() < weapon.getPrice())
            throw new InsufficientCoinsException("You have not enough coins to purchase : "+weapon.getName());
        player.addWeapon(weapon);
    }

    public void purchaseWeapon(int index){
        purchaseWeapon(player, weapons.get(index));
    }

    public void start() {
        loadMetadata();
        logger.log("Naw game Started");
    }

    public void loadGameState() {
        logger.log("Game has been loaded");
    }

    public List<Weapon> getWeapons() {
        return weapons;
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
}
