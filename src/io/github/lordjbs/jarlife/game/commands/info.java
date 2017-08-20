package io.github.lordjbs.jarlife.game.commands;

import io.github.lordjbs.jarlife.game.innergame.Human;
import io.github.lordjbs.jarlife.game.innergame.HumanElements;

import static io.github.lordjbs.jarlife.game.internalutil.gameutil.print;

/**
 * @author lordjbs
 * Copyright (C) 2017 lordjbs.
 */
public class info implements ICommand {
    @Override
    public void execute(String input) {
        Human human;
        try{
            String arg = input.split(" ")[1];
            try{
                int id = Integer.parseInt(arg);
                human = HumanElements.persons.get(id);
                String text = "info: Name: " + human.NAME + ", Gender: " + human.GENDER + ", Age: " + human.AGE + ", Relationship: "  + human.relationShip.NAME +  "Unique ID (UUID): " + human.UNIQUE_ID;
                print(text);
            }catch(Exception e) {
                arg += " " + input.split(" ")[2];
                human = HumanElements.strPersons.get(arg);
                String text = "info: Name: " + human.NAME + ", Gender: " + human.GENDER + ", Age: " + human.AGE + ", Relationship: "+ human.relationShip.NAME + ", Unique ID (UUID): " + human.UNIQUE_ID;
                print(text);
            }
        }catch(Exception ex) {
            print("Game | Could not find this ID/Name");
        }
    }

    @Override
    public String help() {
        return "Find a person. Usage: <id/fullname>";
    }

    @Override
    public String name() {
        return "info";
    }
}
