package io.github.lordjbs.jarlife.game;

import io.github.lordjbs.jarlife.game.classes.Human;
import io.github.lordjbs.jarlife.game.classes.HumanStuff;
import io.github.lordjbs.jarlife.game.internalutil.parsenames;
import io.github.lordjbs.jarlife.sys.System_Utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

import static io.github.lordjbs.jarlife.game.internalutil.gameutil.print;

/**
 * @author lordjbs
 * Copyright (C) 2017 lordjbs.
 */
public class jarlife_game {
    private static int day = 0;
    public static void start() throws Exception{
        print("Parsing names..");
        parsenames.parse();
        print("Mennames: " + HumanStuff.men_names.size() + " | Womannames: " + HumanStuff.woman_names.size() + " | afternames: " + HumanStuff.afternames.size());
        humans.createHumans();

        print("##########################################\n############    jarLife    ###############\n####### A project made by lordjbs ########\n#### Inspired by @bubbie and @ry00000 ####\n#####   Copyright (C) 2017 lordjbs.  #####\n##########################################");
        newDay();
        loop();
    }

    private static void loop() throws Exception {
        System.out.print("~$ ");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String input = bufferedReader.readLine();
        Human human;
        if(input.startsWith("userinfo")) {
            try{
                String arg = input.split(" ")[1];
                try{
                    int id = Integer.parseInt(arg);
                    human = humans.persons.get(id);
                    String text = "Game | Userinfo: Name: " + human.NAME + ", Gender: " + human.GENDER + ", Age: " + human.AGE + ", Unique ID (UUID): " + human.UNIQUE_ID;
                    print(text);
                }catch(Exception e) {
                    arg += " " + input.split(" ")[2];
                    human = humans.strPersons.get(arg);
                    String text = "Game | Userinfo: Name: " + human.NAME + ", Gender: " + human.GENDER + ", Age: " + human.AGE + ", Unique ID (UUID): " + human.UNIQUE_ID;
                    print(text);
                }
            }catch(Exception ex) {
                print("Game | Could not find this ID/Name");
            }
        }else if(input.startsWith("nextday")) {
            newDay();
        }else if(input.startsWith("quit")) {
            print("goodbye.");
            System_Utils.exit();
        }
        loop();
    }

    private static void newDay() {
        day++;
        print("Game | Day " + day);
        Random generator = new Random();
        Object[] values = humans.persons.values().toArray();

        int rndm = generator.nextInt(4);

        if(rndm == 3) {
            Human[] toDie = {(Human) values[generator.nextInt(values.length)],(Human) values[generator.nextInt(values.length)],(Human) values[generator.nextInt(values.length)]};
            for (Human human : toDie) {
                human.die();
            }
        }else if(rndm  == 2){
            Human[] toDie = {(Human) values[generator.nextInt(values.length)],(Human) values[generator.nextInt(values.length)]};
            for (Human human : toDie) {
                human.die();
            }
        }else if(rndm  == 1){
            Human[] toDie = {(Human) values[generator.nextInt(values.length)]};
            for (Human human : toDie) {
                human.die();
            }
        }else if(rndm  == 0) {
            Human[] toDie = {(Human) values[generator.nextInt(values.length)]};
            for (Human human : toDie) {
                human.die();
            }
        }
    }
}
