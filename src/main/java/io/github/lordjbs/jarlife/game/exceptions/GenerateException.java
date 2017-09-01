package io.github.lordjbs.jarlife.game.exceptions;

/**
 * @author lordjbs
 */
public class GenerateException extends GameException {
    public GenerateException() {
        super();
    }

    public GenerateException(Throwable throwable) {
        super(throwable);
    }

    public GenerateException(String message) {
        super(message);
    }

    @Override
    public void printStackTrace() {
        super.printStackTrace();
    }
}
