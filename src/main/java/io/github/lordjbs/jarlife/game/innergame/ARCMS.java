package io.github.lordjbs.jarlife.game.innergame;

import java.util.Random;

/**
 * @author lordjbs
 */

/**
  ARCMS
  ======
  An
  Random
  Class
  Making
  Stuff
 */
public class ARCMS {

    private static Random random = new Random();

    /**
     * Chooses a number between 2 numbers.
     * @param x Number 1
     * @param y Number 2
     * @return Integer
     */
    public static int chooseNumberBetween(int x, int y) {
        return random.nextInt(x-y) + y;
    }

    /**
     * Chooses a number from 0-X
     * @param x Number 1
     * @return Integer
     */
    public static int getNumberUpTo(int x) {
        return random.nextInt(x + 1);
    }

    /**
     * Gets random of a array.
     * @param string The STRING array
     * @return String
     */
    public static String getRandomOfArray(String[] string) {
        return string[getNumberUpTo(string.length)];
    }

    /**
     * Gets random of a array.
     * @param integer The INTEGER array
     * @return int
     */
    public static int getRandomOfArray(int[] integer) {
        return integer[getNumberUpTo(integer.length)];
    }
}
