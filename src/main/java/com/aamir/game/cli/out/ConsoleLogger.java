package com.aamir.game.cli.out;

public class ConsoleLogger implements Logger {

    @Override
    public void log(String message, Object... args) {
        System.out.println(String.format(message, args));
    }
}
