package com.aamir.game.cli.command;

import com.aamir.game.Game;
import com.aamir.game.cli.out.Logger;
import com.aamir.game.cli.out.LoggerFactory;
import com.aamir.game.model.Weapon;

import java.util.ArrayList;
import java.util.List;

public class MacroCommand {

    Logger logger = LoggerFactory.getLogger();
    Game game;
    private List<Command> commands = new ArrayList<>();
    private Command loadGameCommand;
    private Command purchaseWeaponStateCommand;
    private Command changeWeaponCommand;
    private Command viewPlayerCommand;
    private Command gameExitCommand;
    private Command startFightCommand;
    private Command gameStartCommand;
    private Command attackOpponentCommand;

    public MacroCommand(Game game) {
        this.game = game;
        gameStartCommand = new GameStartCommand(game);
        attackOpponentCommand = new AttackOpponentCommand(game);
        startFightCommand = new StartFightCommand(game);
        gameExitCommand = new GameExitCommand();
        viewPlayerCommand = new ViewPlayerCommand(game);
        changeWeaponCommand = new ChangeWeaponCommand(game);
        loadGameCommand = new LoadGameCommand(game);
        purchaseWeaponStateCommand = new PurchaseWeaponStateCommand(game);
    }

    public void gameStartedCommands(){
        commands.clear();
        commands.add(startFightCommand);
        commands.add(purchaseWeaponStateCommand);
        commands.add(gameExitCommand);
        commands.add(viewPlayerCommand);
        logger.debug(" Filled game start with options");

    }

    public void fillGameStartCommands() {
        commands.clear();
        commands.add(gameStartCommand);
        commands.add(gameExitCommand);
        logger.debug(" Filled game without load");
    }

    public void fillLoadOptions() {
        commands.clear();
        commands.add(gameStartCommand);
        commands.add(gameExitCommand);
        logger.debug(" Filled game without load");
    }


    public void fillFightCommand() {
        commands.clear();
        commands.add(attackOpponentCommand);
        commands.add(changeWeaponCommand);
        commands.add(viewPlayerCommand);
        commands.add(gameExitCommand);
    }

    public void fillWeaponPurchaseCommands() {
        commands.clear();
        int index = 0;
        for (Weapon weapon : game.getWeapons())
            if (weapon.getLevel() <= game.getPlayer().getCurrentLevel()
                    && !game.getPlayer().getWeapons().contains(weapon))
                commands.add(new PurchaseWeaponCommand(game, index++));
        commands.add(viewPlayerCommand);
        commands.add(gameExitCommand);
    }

    public void executeCommand(int index) {
        commands.get(index - 1).execute();
    }


    public List<Command> getCommands() {
        return commands;
    }
}
