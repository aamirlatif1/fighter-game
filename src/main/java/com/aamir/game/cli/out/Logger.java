package com.aamir.game.cli.out;

public interface Logger {
    void log(String message, Object... args);
    void debug(String messsage);
}
