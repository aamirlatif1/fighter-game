package com.aamir.game.cli.out;

public class LoggerFactory {

    /**
     * @return a singleton of logger.
     */
    public static Logger getLogger(){
        return LoggerInstanceHolder.logger;
    }

    private static class LoggerInstanceHolder {
        static Logger logger = new ConsoleLogger();
    }
}
