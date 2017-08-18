package io.github.lordjbs.jarlife.game.commands;

import io.github.lordjbs.jarlife.game.game;

/**
 * @author lordjbs
 * Copyright (C) 2017 lordjbs.
 */
public class nextday implements ICommand {
    @Override
    public void execute(String input) {
        try {
            game.newDay();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
