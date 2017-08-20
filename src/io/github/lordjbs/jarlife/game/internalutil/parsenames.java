package io.github.lordjbs.jarlife.game.internalutil;

import io.github.lordjbs.jarlife.game.innergame.HumanElements;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author lordjbs
 * Copyright (C) 2017 lordjbs.
 */
public class parsenames {
    public static void parse() {
        parseFornames1();
        parseFornames2();
        parseAfternames();
    }

    private static void parseFornames1() {

        BufferedReader br = null;
        FileReader fr = null;

        try {

            fr = new FileReader("fornames1.txt");
            br = new BufferedReader(fr);

            String sCurrentLine;

            while ((sCurrentLine = br.readLine()) != null) {
                HumanElements.men_names.add(sCurrentLine);
            }

        } catch (IOException e) {

            e.printStackTrace();

        } finally {

            try {

                if (br != null)
                    br.close();

                if (fr != null)
                    fr.close();

            } catch (IOException ex) {

                ex.printStackTrace();

            }

        }
    }

    private static void parseFornames2() {

        BufferedReader br = null;
        FileReader fr = null;

        try {

            fr = new FileReader("fornames2.txt");
            br = new BufferedReader(fr);

            String sCurrentLine;

            while ((sCurrentLine = br.readLine()) != null) {
                HumanElements.woman_names.add(sCurrentLine);
            }

        } catch (IOException e) {

            e.printStackTrace();

        } finally {

            try {

                if (br != null)
                    br.close();

                if (fr != null)
                    fr.close();

            } catch (IOException ex) {

                ex.printStackTrace();

            }

        }
    }

    private static void parseAfternames() {

        BufferedReader br = null;
        FileReader fr = null;

        try {

            fr = new FileReader("afternames.txt");
            br = new BufferedReader(fr);

            String sCurrentLine;

            while ((sCurrentLine = br.readLine()) != null) {
                HumanElements.afternames.add(sCurrentLine);
            }

        } catch (IOException e) {

            e.printStackTrace();

        } finally {

            try {

                if (br != null)
                    br.close();

                if (fr != null)
                    fr.close();

            } catch (IOException ex) {

                ex.printStackTrace();

            }

        }
    }
}
