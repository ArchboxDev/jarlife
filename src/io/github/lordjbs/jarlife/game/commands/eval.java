package io.github.lordjbs.jarlife.game.commands;

import io.github.lordjbs.jarlife.game.innergame.HumanElements;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

import static io.github.lordjbs.jarlife.game.internalutil.gameutil.print;

/**
 * @author lordjbs
 * Copyright (C) 2017 lordjbs.
 */
public class eval implements ICommand {
    @Override
    public void execute(String input) {
        try {
            String args = input.substring(4);
            ScriptEngineManager factory = new ScriptEngineManager();
            ScriptEngine engine = factory.getEngineByName("JavaScript");
            engine.put("HumanElements", new HumanElements());
            engine.put("HumanStuff", new HumanElements());
            Object output = engine.eval(args);
            print(output.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
