package io.github.lordjbs.jarlife.game.commands;

import io.github.lordjbs.jarlife.game.innergame.Human;
import io.github.lordjbs.jarlife.game.innergame.HumanElements;
import io.github.lordjbs.jarlife.game.internalutil.gameutil;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

/**
 * @author lordjbs
 */
public class eval implements ICommand {
    @Override
    public void execute(String input) {
        try {
            String args = input.substring(4);
            ScriptEngineManager factory = new ScriptEngineManager();
            ScriptEngine engine = factory.getEngineByName("JavaScript");
            engine.put("HumanElements", new HumanElements());
            engine.put("ExampleHuman", new Human(Human.AgeType.ADULT));
            engine.put("util", new gameutil());
            Object output = engine.eval(args);
            System.out.println(output.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public String help() {
        return "Evals code. ONLY FOR USERS WHO KNOW WHAT THEYRE DOING! Usage: <code>";
    }

    @Override
    public String name() {
        return "eval";
    }
}
