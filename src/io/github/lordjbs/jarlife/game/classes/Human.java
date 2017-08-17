package io.github.lordjbs.jarlife.game.classes;

import io.github.lordjbs.jarlife.game.humans;

import java.util.Random;

/**
 * @author lordjbs
 * Copyright (C) 2017 lordjbs.
 */
public class Human {

    private Random random = new Random();
    public int AGE = 1;
    public String NAME = null;
    public String GENDER = null;
    public int UNIQUE_ID = 0;
    public Human() {

        this.GENDER = HumanStuff.genders[random.nextInt(2)];
        this.generateUNIQUE_ID();
    }

    private void generateUNIQUE_ID() {
        int temp = random.nextInt(300);
        if(humans.persons.containsKey(temp)) {
            generateUNIQUE_ID();
        }else {
            this.UNIQUE_ID = temp;
        }
    }
}
