package io.github.lordjbs.jarlife.game;

import io.github.lordjbs.jarlife.game.classes.Human;
import io.github.lordjbs.jarlife.game.classes.HumanStuff;
import io.github.lordjbs.jarlife.game.internalutil.parsenames;
import io.github.lordjbs.jarlife.sys.System_Utils;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

import static io.github.lordjbs.jarlife.game.internalutil.gameutil.print;

/**
 * @author lordjbs
 * Copyright (C) 2017 lordjbs.
 */
public class jarlife_game {
    private static humans _humans = new humans();
    private static int year = -0;
    public static void start() throws Exception{
        print("Parsing names..");
        parsenames.parse();
        print("Mennames: " + HumanStuff.men_names.size() + " | Womannames: " + HumanStuff.woman_names.size() + " | afternames: " + HumanStuff.afternames.size());
        _humans.createHumans();

        print("##########################################\n############    jarLife    ###############\n####### A project made by lordjbs ########\n#### Inspired by @bubbie and @ry00000 ####\n#####   Copyright (C) 2017 lordjbs.  #####\n##########################################");
        newDay();
        _humans.createRelationship();
        _humans.createRelationship();
        loop();
        print("Game | Enter Action (e.g nextday");
    }

    private static void loop() throws Exception {
        System.out.print("\n~$ ");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String input = bufferedReader.readLine();
        Human human;
        if(input.startsWith("info")) {
            try{
                String arg = input.split(" ")[1];
                try{
                    int id = Integer.parseInt(arg);
                    human = humans.persons.get(id);
                    String text = "Game | info: Name: " + human.NAME + ", Gender: " + human.GENDER + ", Age: " + human.AGE + ", Relationship: "  + human.relationShip.NAME +  "Unique ID (UUID): " + human.UNIQUE_ID;
                    print(text);
                }catch(Exception e) {
                    arg += " " + input.split(" ")[2];
                    human = humans.strPersons.get(arg);
                    String text = "Game | info: Name: " + human.NAME + ", Gender: " + human.GENDER + ", Age: " + human.AGE + ", Relationship: "+ human.relationShip.NAME + ", Unique ID (UUID): " + human.UNIQUE_ID;
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
        }else if(input.startsWith("eval")) {
            try {
                String args = input.substring(4);
                ScriptEngineManager factory = new ScriptEngineManager();
                ScriptEngine engine = factory.getEngineByName("JavaScript");
                engine.put("humans", new humans());
                engine.put("HumanStuff", new HumanStuff());
                Object output = engine.eval(args);
                print(output.toString());
            }catch(Exception e) {
                e.printStackTrace();
            }
        }
        loop();
    }

    private static void newDay() throws Exception{
        year++;
        print("Game | Year " + year);
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

        humans.persons.forEach((human_UUID,human_object) -> {
            human_object.AGE++;
            int _AGE = human_object.AGE;
            Human.AgeType _AT = human_object.AGE_TYPE;
            if(_AGE == 1) {
                human_object.AGE_TYPE = Human.AgeType.KID;
                print(human_object.NAME  + " is now a KID! (BABY->KID");
            }else if(_AGE == 14) {
                human_object.AGE_TYPE = Human.AgeType.TEEN;
                print(human_object.NAME  + " is now a KID! (KID->TEEN");
            }else if(_AGE == 18) {
                human_object.AGE_TYPE = Human.AgeType.ADULT;
                print(human_object.NAME  + " is now a KID! (TEEN->ADULT");
            }
        });

        _humans.createRelationship();
        _humans.createRelationship();
    }
}
