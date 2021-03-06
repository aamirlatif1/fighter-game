package com.aamir.game.cli.command;

import com.aamir.game.play.Game;
import com.aamir.game.cli.out.Logger;
import com.aamir.game.cli.out.LoggerFactory;
import com.aamir.game.model.Weapon;
import com.aamir.game.util.FileUtil;

import java.util.ArrayList;
import java.util.List;

public class MenuManager {

    private static final Logger LOGGER = LoggerFactory.getLogger();

    private Game game;
    private List<Command> commands = new ArrayList<>();
    private Command loadGameCommand;
    private Command purchaseWeaponStateCommand;
    private Command changeWeaponStateCommand;
    private Command viewPlayerCommand;
    private Command gameExitCommand;
    private Command startFightCommand;
    private Command gameStartCommand;
    private Command attackOpponentCommand;

    public MenuManager(Game game) {
        this.game = game;
        gameStartCommand = new GameStartCommand(game);
        attackOpponentCommand = new AttackOpponentCommand(game);
        startFightCommand = new StartFightCommand(game);
        gameExitCommand = new GameExitCommand(game);
        viewPlayerCommand = new ViewPlayerCommand(game);
        changeWeaponStateCommand = new ChangeWeaponStateCommand(game);
        loadGameCommand = new LoadGameCommand(game);
        purchaseWeaponStateCommand = new PurchaseWeaponStateCommand(game);
        if (FileUtil.gameStateFileExist())
            fillLoadOptions();
         else
           fillGameStartCommands();
    }

    public void gameStartedCommands(){
        commands.clear();
        commands.add(startFightCommand);
        commands.add(changeWeaponStateCommand);
        commands.add(purchaseWeaponStateCommand);
        addPlayerCommand();
        LOGGER.debug(" Filled game start with options");

    }

    public void fillGameStartCommands() {
        commands.clear();
        commands.add(gameStartCommand);
        commands.add(gameExitCommand);
        LOGGER.debug(" Filled game without load");
    }

    public void fillLoadOptions() {
        commands.clear();
        commands.add(loadGameCommand);
        commands.add(gameStartCommand);
        commands.add(gameExitCommand);
        LOGGER.debug(" Filled game without load");
    }


    public void fillFightCommands() {
        commands.clear();
        commands.add(attackOpponentCommand);
        addPlayerCommand();
    }

    public void fillWeaponPurchaseCommands() {
        commands.clear();
        int index = 0;
        for (Weapon weapon : game.getMetadata().getWeapons())
            if (weapon.getLevel() <= game.getPlayer().getCurrentLevel()
                    && !game.getPlayer().getWeapons().contains(weapon))
                commands.add(new PurchaseWeaponCommand(game, index++));
        addFightCommands();
    }

    public void fillChangeWeaponCommands() {
        commands.clear();
        int index = 0;
        for (Weapon weapon : game.getPlayer().getWeapons())
            commands.add(new ChangeWeaponCommand(game, index++));
        addFightCommands();
    }

    private void addFightCommands() {
        commands.add(startFightCommand);
        addPlayerCommand();
    }

    private void addPlayerCommand() {
        commands.add(viewPlayerCommand);
        commands.add(gameExitCommand);
    }

    public void executeCommand(int index) {
        commands.get(index - 1).execute();
    }

    public void displayCommands(){
        int i = 1;
        for (Command command : commands) {
            LOGGER.log(String.format("%d - %s", i++, command));
        }
    }

}
