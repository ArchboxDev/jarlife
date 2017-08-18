package io.github.lordjbs.jarlife.game.classes;

import io.github.lordjbs.jarlife.game.humans;
import java.util.Random;
import static io.github.lordjbs.jarlife.game.internalutil.gameutil.print;

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
    public AgeType AGE_TYPE = null;
    public boolean died = false;
    public Human relationShip;

    public Human(AgeType ageType) {
        this.AGE_TYPE = ageType;
        this.generate();
    }

    private void generate() {
        this.GENDER = HumanStuff.genders[random.nextInt(2)];
        this.generateAge();
        this.generateUUID();
        this.generateName();
    }

    private void generateUUID() {
        int temp = random.nextInt(300);
        if(humans.persons.containsKey(temp)) {
            this.generate();
        }else {
            this.UNIQUE_ID = temp;
        }
    }


    private void generateName() {
        if(GENDER.equals("men")) {
            int temp1 = random.nextInt(123);
            int temp2 = random.nextInt(210);
            String tempname = HumanStuff.men_names.get(temp1) + " " + HumanStuff.afternames.get(temp2);
            this.NAME = tempname;
        }else if(GENDER.equals("woman")) {
            int temp1 = random.nextInt(105);
            int temp2 = random.nextInt(210);
            String tempname = HumanStuff.woman_names.get(temp1) + " " + HumanStuff.afternames.get(temp2);
            this.NAME = tempname;
        }
    }

    private void generateAge() {
        switch(this.AGE_TYPE) {
            case BABY:
                this.AGE = random.nextInt(2);
                break;
            case KID:
                this.AGE = random.nextInt(13-1) + 1;
                break;
            case TEEN:
                this.AGE = random.nextInt(18-14) + 14;
                break;
            case ADULT:
                this.AGE = random.nextInt(32-18) + 18;
                break;
        }
    }

    public void die() {
        print("Game | DEATH: " + this.NAME + " " + HumanStuff.deathReasons[random.nextInt(HumanStuff.deathReasons.length + 1)]);
        this.died = true;
    }

    public static enum AgeType {
        BABY,KID,TEEN,ADULT
    }

}