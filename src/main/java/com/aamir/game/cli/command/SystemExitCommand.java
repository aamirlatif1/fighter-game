package com.aamir.game.cli.command;

public class SystemExitCommand implements UserCommand {

    @Override
    public void execute() {
        System.exit(1);
    }

    @Override
    public String toString() {
        return "Exit";
    }
}
