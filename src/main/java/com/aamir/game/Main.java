package com.aamir.game;

import com.aamir.game.cli.in.ConsoleReader;
import com.aamir.game.cli.in.InputReader;
import com.aamir.game.cli.out.Logger;
import com.aamir.game.cli.out.LoggerFactory;
import com.aamir.game.play.Game;

import java.util.Scanner;

public class Main {

    private static final Logger LOGGER = LoggerFactory.getLogger();

    public static void main(String[] args) {
        InputReader inputReader = new ConsoleReader();
        Game game = new Game(inputReader);
        Scanner scanner = new Scanner(System.in);

        while (!game.isStopped()){
            game.getMenuManager().displayCommands();
            LOGGER.log("Select Option : ");
            int commandIndex = scanner.nextInt();
            game.getMenuManager().executeCommand(commandIndex);
        }
    }
}
