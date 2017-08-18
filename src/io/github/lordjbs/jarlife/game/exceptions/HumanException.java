package io.github.lordjbs.jarlife.game.exceptions;

/**
 * @author lordjbs
 * Copyright (C) 2017 lordjbs.
 */
public class HumanException extends GameException {

    public HumanException() {
        super();
    }

    public HumanException(String message) {
        super(message);
    }

    public HumanException(Throwable throwable) {
        super(throwable);
    }

    @Override
    public void printStackTrace() {
        super.printStackTrace();
    }
}
