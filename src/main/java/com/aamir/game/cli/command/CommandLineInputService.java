package com.aamir.game.cli.command;

import com.aamir.game.Game;
import com.aamir.game.model.Weapon;

import java.util.ArrayList;
import java.util.List;

public class CommandLineInputService {

    Game game = new Game();
    private List<String> messages = new ArrayList<>();
    private List<UserCommand> commands = new ArrayList<>();
    public void getMenueList(){

    }

    public void fillGameStartCommands(){
        addCommand(() -> game.start(), "Start Game");
        addCommand(() -> game.loadGameState(), "Load existing");
        addCommand(() -> System.exit(1), "Exit");
    }

    public void weaponPurchaseCommands(){
        for (Weapon weapon : game.getWeapons())
            if (weapon.getLevel() <= game.getPlayer().getCurrentLevel())
                addCommand(() -> game.purchaseWeapon(weapon.getLevel()+1), weapon.getName());
    }

    public void addCommand(UserCommand command, String message){
        commands.add(command);
        messages.add(message);
    }

    public void excuteCommand(int index){
        commands.get(index - 1).execute();
    }

    public List<String> getCommandMessages() {
        return messages;
    }
}
