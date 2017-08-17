package io.github.lordjbs.jarlife;

import io.github.lordjbs.jarlife.game.classes.HumanStuff;
import io.github.lordjbs.jarlife.game.internalutil.parsenames;

import static io.github.lordjbs.jarlife.game.internalutil.gameutil.*;

/**
 * @author lordjbs
 * Copyright (C) 2017 lordjbs.
 */
public class jarlife {

    public static void main(String[] args)
    {
        if(args.length > 0) {
            if(args[0].equalsIgnoreCase("--memes")) {
                System.out.println("memes");
                System.exit(0);
            }
        }

        parsenames.parse();

        print("Mennames: " + HumanStuff.men_names.size() + " | Womannames: " + HumanStuff.woman_names.size() + " | afternames: " + HumanStuff.afternames.size());

    }
}
