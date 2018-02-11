package com.aamir.game;

import com.aamir.game.cli.command.CommandLineInputService;
import com.aamir.game.cli.out.Logger;
import com.aamir.game.cli.out.LoggerFactory;

import java.util.Scanner;

public class Main {

    private static Logger logger = LoggerFactory.getLogger();
    static CommandLineInputService cliService = new CommandLineInputService();
    public static void displayCommands(){
        int i = 1;
        for (String  command : cliService.getCommandMessages()) {
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
