package com.aamir.game.cli.out;

public class ConsoleLogger implements Logger {

    boolean debug = false;
    @Override
    public void log(String message, Object... args) {
        System.out.println(String.format(message, args));
    }

    @Override
    public void debug(String message) {
        if(debug) {
            StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
            StackTraceElement element = stackTraceElements[1];
            System.out.println(element.getClassName() + "." + element.getMethodName() + " :: " + message);
        }
    }
}
