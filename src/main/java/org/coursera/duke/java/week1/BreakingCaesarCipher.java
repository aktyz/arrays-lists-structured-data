package org.coursera.duke.java.week1;

import java.util.Random;

public class BreakingCaesarCipher {
/** Function counting number of occurance of each letter in a String **/
    public static void textFingerPrint(String s) {
        String alpha = "abcdefghijklmnopqrstuvwxyz";
        int[] counters = new int[26];
        for (int k = 0; k < s.length(); k++) {
            char ch = s.charAt(k);
            int index = alpha.indexOf(Character.toLowerCase(ch));
            if (index != -1)
                counters[index] += 1;
        }
        for (int k = 0; k < counters.length; k++)
            System.out.println(alpha.charAt(k) + "\t" + counters[k]);
    }

    public static void simpleStimulate(int rolls) {
        Random rand = new Random();
        int twos = 0;
        int twelves = 0;

        for(int k = 0; k < rolls; k++)
        {
            int d1 = rand.nextInt(6) + 1;
            int d2 = rand.nextInt(6) + 1;
            if (d1 + d2 == 2)
                twos++;
            else if (d1 + d2 == 12)
                twelves++;
        }
        System.out.println("2's = " + twos + ";\t" + 100.0 * twos/rolls);
        System.out.println("12's = " + twelves + ";\t" + 100.0 * twelves/rolls);
    }
}
