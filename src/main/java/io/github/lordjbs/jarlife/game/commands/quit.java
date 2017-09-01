package io.github.lordjbs.jarlife.game.commands;

import io.github.lordjbs.jarlife.sys.System_Utils;

/**
 * @author lordjbs
 */
public class quit implements ICommand {
    @Override
    public void execute(String input) {
        System_Utils.exit();
    }

    @Override
    public String help() {
        return "quits";
    }

    @Override
    public String name() {
        return "quit";
    }
}
