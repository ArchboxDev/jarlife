package io.github.lordjbs.jarlife;

import io.github.lordjbs.jarlife.game.jarlife_game;

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
        try {
            jarlife_game.start();
        } catch (Exception e) {

        } finally {
            try {
                jarlife_game.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
