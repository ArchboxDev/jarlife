package io.github.lordjbs.jarlife.game;

import io.github.lordjbs.jarlife.game.classes.Human;

import java.util.HashMap;

import static io.github.lordjbs.jarlife.game.internalutil.gameutil.print;

/**
 * @author lordjbs
 * Copyright (C) 2017 lordjbs.
 */
public class humans {
    /**
     * @params Human, Integer - Human: new Human(), Integer: Unique ID of human.
     */
    public static HashMap<Integer, Human> persons = new HashMap<>();
    public static HashMap<String, Human> strPersons = new HashMap<>();

    public static void createHumans() {
        for(int i = 0; i < 20; i++) {
            Human newHuman = new Human();
            persons.put(newHuman.UNIQUE_ID, newHuman);
            strPersons.put(newHuman.NAME, newHuman);
            print("Created " + newHuman.NAME + " (" + newHuman.UNIQUE_ID + ")");
        }
    }
}
