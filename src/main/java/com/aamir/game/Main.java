package com.aamir.game;

import com.aamir.game.cli.out.Logger;
import com.aamir.game.cli.out.LoggerFactory;

import java.util.Scanner;

public class Main {

    private static Logger logger = LoggerFactory.getLogger();

    public static void main(String[] args) {
        Game game = new Game();
        Scanner scanner = new Scanner(System.in);
        while (true){
            game.displayCommands();
            logger.log("Select Option : ");
            int commandIndex = scanner.nextInt();
            game.executeCommand(commandIndex);
        }
    }
}
