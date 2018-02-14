package com.aamir.game;

import com.aamir.game.cli.command.Command;
import com.aamir.game.cli.command.MacroCommand;
import com.aamir.game.cli.in.InputReader;
import com.aamir.game.cli.out.Logger;
import com.aamir.game.cli.out.LoggerFactory;
import com.aamir.game.exception.InsufficientCoinsException;
import com.aamir.game.model.Level;
import com.aamir.game.model.Player;
import com.aamir.game.model.Weapon;
import com.aamir.game.state.*;
import com.aamir.game.util.*;

import java.io.File;
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
    private MacroCommand macroCommand;
    private Fight fight;
    private transient InputReader inputReader;

    public Game(InputReader inputReader) {
        this.inputReader = inputReader;
        notStartedState = new NotStartedState(this);
        startedSate = new StartedState(this);
        purchaseWeaponState = new PurchaseWeaponState(this);
        fightState = new FightState(this);
        state = new NotStartedState(this);
        macroCommand = new MacroCommand(this);
        if (FileUtil.gameStateFileExist()) {
            macroCommand.fillLoadOptions();
        } else{
            macroCommand.fillGameStartCommands();
        }
    }

    public void start(String playerName) {
        loadMetadata();
        player = new Player(playerName);
        // Knife is given as default weapon
        player.addWeapon(weapons.get(0));
        state = startedSate;
        state.startGame();
        logger.log("Naw game Started");
    }

    public void viewPlayer(){
        logger.log(player.toString());
    }

    public void purchaseWeapon(Weapon weapon) {
        if(player.getCoins() < weapon.getPrice())
            throw new InsufficientCoinsException("You have not enough coins to purchase : "+weapon.getName());
        player.setCoins(player.getCoins() - weapon.getPrice());
        player.addWeapon(weapon);
    }

    public void loadGameState() {
        player = FileUtil.loadPlayer();
        logger.log("Game has been loaded");
    }

    public void purchaseWeapon(int index){
        purchaseWeapon(weapons.get(index));
    }

    public void startFight() {
        fight = new Fight(this);
        state.startFight();
        logger.log("Fight Started");
    }

    public void displayCommands(){
        int i = 1;
        for (Command command : macroCommand.getCommands()) {
            logger.log(String.format("%d - %s", i++, command));
        }
    }

    public void changeWeaponState(int selectWeaponIndex) {
        player.setSelectedWeaponIndex(selectWeaponIndex);
        logger.log("Change weapon");

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

    public void executeCommand(int commandIndex) {
        macroCommand.executeCommand(commandIndex);
    }

    public void purchaseWeaponState() {
        state.purchaseWeapon();
    }


    public MacroCommand getMacroCommand() {
        return macroCommand;
    }

    public Fight getFight() {
        return fight;
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

    public InputReader getInputReader() {
        return inputReader;
    }

    public List<Player> getOpponents() {
        return opponents;
    }

    public List<Level> getLevels() {
        return levels;
    }

    public void saveGame() {
        FileUtil.savePlayer(this.getPlayer());
    }

}
