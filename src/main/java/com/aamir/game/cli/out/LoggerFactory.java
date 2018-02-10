package com.aamir.game.cli.out;

public class LoggerFactory {

    public static Logger getLogger(){
        return new ConsoleLogger();
    }
}
