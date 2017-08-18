package io.github.lordjbs.jarlife;

import io.github.lordjbs.jarlife.game.kotlin.bootloader;

import static io.github.lordjbs.jarlife.game.internalutil.gameutil.print;

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
            bootloader.gamestart();
        } catch (Exception e) {
            e.printStackTrace();
            print("!!Game Error!!");
        } finally {
            try {
                bootloader.gamestart();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
