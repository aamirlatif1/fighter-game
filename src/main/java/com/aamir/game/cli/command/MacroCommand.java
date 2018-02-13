package com.aamir.game.cli.command;

import com.aamir.game.Game;
import com.aamir.game.model.Weapon;

import java.util.ArrayList;
import java.util.List;

public class MacroCommand {

    Game game;
    private List<String> messages = new ArrayList<>();
    private List<Command> commands = new ArrayList<>();
    private Command gameLoadCommand = () -> game.loadGameState();
    private Command changeWeaponCommand = () -> game.changeWeaponState();
    private Command purchaseWeaponStateCommand = () -> game.purchaseWeaponState();
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
    }

    public void fillGameStartCommands(){
        addCommand(gameStartCommand, "Start Game");
        addCommand(gameLoadCommand, "Load existing");
        addCommand(gameExitCommand, "Exit");
    }

    public void fillStartedCommands(){
        clear();
        addCommand(startFightCommand, "Start Fight");
        addCommand(purchaseWeaponStateCommand, "Purchase Weapon");
        addCommand(gameExitCommand, "Exit");
    }

    public void fillFightCommand(){
        clear();
        addCommand(attackOpponentCommand, "Attach opponent");
        addCommand(changeWeaponCommand, "Change Weapon");
        addCommand(gameExitCommand, "Exit");
    }

    public void fillWeaponPurchaseCommands(){
        clear();
        int index = 0;
        for (Weapon weapon : game.getWeapons())
            if (weapon.getLevel() <= game.getPlayer().getCurrentLevel()
                    && !game.getPlayer().getWeapons().contains(weapon))
                addCommand(new PurchaseWeaponCommand(game, index++), weapon.getName());
        addCommand(gameExitCommand, "Exit");
    }

    public void addCommand(Command command, String message){
        commands.add(command);
        messages.add(message);
    }

    public void executeCommand(int index){
        commands.get(index - 1).execute();
    }

    public List<String> getCommandMessages() {
        return messages;
    }

    public void clear(){
        commands.clear();
        messages.clear();
    }
}
