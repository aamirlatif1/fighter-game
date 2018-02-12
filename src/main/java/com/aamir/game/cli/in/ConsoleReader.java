package com.aamir.game.cli.in;

import java.util.Scanner;

public class ConsoleReader implements InputReader {

    private static Scanner scanner = new Scanner(System.in);


    @Override
    public String readString() {
        return scanner.next();
    }

    @Override
    public int readInt() {
        return scanner.nextInt();
    }
}
