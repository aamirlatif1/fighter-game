package com.aamir.game.cli;

import com.aamir.game.Game;
import com.aamir.game.cli.command.NewGameStartCommand;
import com.aamir.game.cli.command.ResumeExistingGameCommand;
import com.aamir.game.cli.command.SystemExitCommand;
import com.aamir.game.cli.command.UserCommand;

import java.util.ArrayList;
import java.util.List;

public class CommandLineInputService {

    Game game = new Game();
    private UserCommand newGameStartCommand = new NewGameStartCommand(game);
    private UserCommand resumeExistingGameCommand = new ResumeExistingGameCommand(game);
    private SystemExitCommand exitCommand = new SystemExitCommand();

    List<UserCommand> commands = new ArrayList<>();

    public void fillGameStartCommands(){
        commands.add(newGameStartCommand);
        commands.add(resumeExistingGameCommand);
        commands.add(exitCommand);
    }

    public void excuteCommand(int index){
        commands.get(index-1).execute();
    }

    public List<UserCommand> getCommands() {
        return commands;
    }
}
