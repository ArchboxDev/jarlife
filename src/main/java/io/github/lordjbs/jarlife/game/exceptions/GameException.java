package io.github.lordjbs.jarlife.game.exceptions;

import java.io.PrintStream;

/**
 * @author lordjbs
 * Copyright (C) 2017 lordjbs.
 */
public class GameException extends Exception {

    public GameException() {
        super();
    }

    public GameException(Throwable throwable) {
        super(throwable);
    }

    public GameException(String message) {
        super(message);
    }


    @Override
    public void printStackTrace(PrintStream s) {
        super.printStackTrace(s);
    }

    @Override
    public void printStackTrace() {
        super.printStackTrace();
    }

    @Override
    public StackTraceElement[] getStackTrace() {
        return super.getStackTrace();
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public synchronized Throwable getCause() {
        return super.getCause();
    }

    @Override
    public synchronized Throwable initCause(Throwable cause) {
        return super.initCause(cause);
    }
}
