package io.github.lordjbs.jarlife.game;

import io.github.lordjbs.jarlife.game.classes.Human;

import java.util.HashMap;
import java.util.Random;

import static io.github.lordjbs.jarlife.game.internalutil.gameutil.print;

/**
 * @author lordjbs
 * Copyright (C) 2017 lordjbs.
 */
public class humans {
    /**
     * Human HashMaps
     */
    public static HashMap<Integer, Human> persons = new HashMap<>();
    public static HashMap<String, Human> strPersons = new HashMap<>();

    private static Random random = new Random();
    public static HashMap<Human, Human> relationships = new HashMap<>();

    public void createHumans() {
        for(int i = 0; i < 20; i++) {
            Human newHuman = new Human(Human.AgeType.ADULT);
            persons.put(newHuman.UNIQUE_ID, newHuman);
            strPersons.put(newHuman.NAME, newHuman);
            print("Created " + newHuman.NAME + " (" + newHuman.UNIQUE_ID + ")");
        }
    }

    public void createRelationship() {
        Random generator = new Random();
        Object[] values = humans.persons.values().toArray();
       // (Human) values[generator.nextInt(values.length)]
        Human h1 = (Human) values[generator.nextInt(values.length)];
        Human h2 = (Human) values[generator.nextInt(values.length)];
        if(h1.AGE_TYPE == Human.AgeType.ADULT && h2.AGE_TYPE == Human.AgeType.ADULT && !h1.died && !h2.died && h1.relationShip == null && h2.relationShip == null) {
            switch (h1.GENDER) {
                case "woman":
                    switch (h2.GENDER) {
                        case "men":
                            h1.relationShip = h2;
                            h2.relationShip = h1;
                            print("Created relationship: " + h1.NAME + "(" + h1.UNIQUE_ID + ") + " + h2.NAME + " (" + h2.UNIQUE_ID + ")");
                            break;
                        case "woman":
                            createRelationship();
                            break;
                    }
                    break;
                case "men":
                    switch (h2.GENDER) {
                        case "woman":
                            h1.relationShip = h2;
                            h2.relationShip = h1;
                            print("Created relationship: " + h1.NAME + "(" + h1.UNIQUE_ID + ") + " + h2.NAME + " (" + h2.UNIQUE_ID + ")");
                            break;
                        case "men":
                            createRelationship();
                            break;
                    }
                    break;
            }
        }else {
            createRelationship();
        }
    }

    public void generateBaby() {
        Boolean[] b = {false,false,false,false,false,false,false,true,false,false,false,true,true,true};
        boolean choosen = b[random.nextInt(b.length + 1)];
        if(choosen) {
            Human baby = new Human(Human.AgeType.BABY);
        }else {

        }
    }
}
