package io.github.lordjbs.jarlife.game.kotlin

import io.github.lordjbs.jarlife.game.exceptions.GameException
import io.github.lordjbs.jarlife.game.game
import io.github.lordjbs.jarlife.game.innergame.HumanElements
import io.github.lordjbs.jarlife.game.internalutil.parsenames

class bootloader {
    companion object {
        @Throws(GameException::class)
        @JvmStatic
        fun gamestart() {
            print("##########################################\n############    jarLife    ###############\n####### A project made by lordjbs ########\n#### Inspired by @bubbie and @ry00000 ####\n#####   Copyright (C) 2017 lordjbs.  #####\n##########################################")

            print("\nGame | Press enter to start...")
            System.`in`.read()
            parsenames.parse()
            HumanElements.createHumans()
            game.loadCommands()
            game.newDay()
            game.loop()
        }
    }
}