package com.aamir.game.cli.command;

import java.io.Serializable;

@FunctionalInterface
public interface Command {
    void execute();
}
