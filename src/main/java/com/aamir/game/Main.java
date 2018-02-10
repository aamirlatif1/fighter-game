package com.aamir.game;

import com.aamir.game.cli.CommandLineInputService;
import com.aamir.game.cli.out.Logger;
import com.aamir.game.cli.out.LoggerFactory;
import com.aamir.game.cli.command.UserCommand;

import java.util.Scanner;

public class Main {

    private static Logger logger = LoggerFactory.getLogger();
    static CommandLineInputService cliService = new CommandLineInputService();
    public static void displayCommands(){
        int i = 1;
        for (UserCommand command : cliService.getCommands()) {
            logger.log(String.format("%d - %s", i++, command));
        }
    }
    public static void main(String[] args) {
        cliService.fillGameStartCommands();
        displayCommands();
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.print("Select Option : ");
            int commandIndex = scanner.nextInt();
            cliService.excuteCommand(commandIndex);
        }
    }
}
