package io.github.lordjbs.jarlife.game.commands;

import io.github.lordjbs.jarlife.sys.System_Utils;

/**
 * @author lordjbs
 * Copyright (C) 2017 lordjbs.
 */
public class quit implements ICommand {
    @Override
    public void execute(String input) {
        System_Utils.exit();
    }
}
