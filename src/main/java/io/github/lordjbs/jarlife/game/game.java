package io.github.lordjbs.jarlife.game;

import io.github.lordjbs.jarlife.game.innergame.Human;
import io.github.lordjbs.jarlife.game.innergame.HumanElements;
import io.github.lordjbs.jarlife.game.commands.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Random;

import static io.github.lordjbs.jarlife.game.internalutil.gameutil.print;

/**
 * @author lordjbs
 */
public class game {

    public static int year = 0;
    public static HashMap<String, ICommand> commands = new HashMap<>();

    public static void loop() throws Exception {
        System.out.print("\n~$ ");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String input = bufferedReader.readLine();

        commands.forEach((cmd_name, cmd) -> {
            if(input.startsWith(cmd_name.toLowerCase())) {
                cmd.execute(input);
            }
        });

        loop();
    }

    public static void loadCommands() {
        commands.put("eval", new eval());
        commands.put("info", new info());
        commands.put("nextyear", new nextyear());
        commands.put("quit", new quit());
        commands.put("help", new help());
    }

    public static void newDay() throws Exception {
        year++;
        print("Year " + year);
        Random generator = new Random();
        Object[] values = HumanElements.persons.values().toArray();

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

        HumanElements.persons.forEach((human_UUID, human_object) -> {
            human_object.AGE++;
            int _AGE = human_object.AGE;
            if(_AGE == 1) {
                human_object.AGE_TYPE = Human.AgeType.KID;
                print(human_object.NAME  + " is now a KID! (BABY->KID)");
            }else if(_AGE == 14) {
                human_object.AGE_TYPE = Human.AgeType.TEEN;
                print(human_object.NAME  + " is now a KID! (KID->TEEN)");
            }else if(_AGE == 18) {
                human_object.AGE_TYPE = Human.AgeType.ADULT;
                print(human_object.NAME  + " is now a KID! (TEEN->ADULT)");
            }
        });
    }
}
