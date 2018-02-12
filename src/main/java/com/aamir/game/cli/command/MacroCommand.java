package com.aamir.game.cli.command;

import com.aamir.game.Game;
import com.aamir.game.model.Weapon;

import java.util.ArrayList;
import java.util.List;

public class MacroCommand {

    Game game;
    private List<String> messages = new ArrayList<>();
    private List<Command> commands = new ArrayList<>();
    private Command gameStartCommand = () -> game.start();
    private Command gameLoadCommand = () -> game.loadGameState();
    private Command gameExitCommand = () -> System.exit(1);
    private Command startFightCommand = () -> game.startFight();
    private Command changeWeaponCommand = () -> game.changeWeaponState();
    private Command purchaseWeaponStateCommand = () -> game.purchaseWeaponState();
    private Command attackOpponentCommand;

    public MacroCommand(Game game) {
        this.game = game;
        attackOpponentCommand = new AttackOpponentCommand(game);
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

    public void weaponPurchaseCommands(){
        for (Weapon weapon : game.getWeapons())
            if (weapon.getLevel() <= game.getPlayer().getCurrentLevel())
                addCommand(() -> game.purchaseWeapon(weapon.getLevel()+1), weapon.getName());
        addCommand(gameExitCommand, "Exit");
    }

    public void addCommand(Command command, String message){
        commands.add(command);
        messages.add(message);
    }

    public void excuteCommand(int index){
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
