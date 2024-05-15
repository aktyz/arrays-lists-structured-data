package org.coursera.duke.java.week1;

import edu.duke.FileResource;

import java.util.Random;

public class BreakingCaesarCipher {
/** Function counting number of occurrence of each letter in a String **/
    public static int[] textFingerPrint(String s) {
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
        return counters;
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

    public static void stimulate(int rolls) {
        Random rand = new Random();
        int [] counts = new int[13];

        for(int k = 0; k < rolls; k++)
        {
            int d1 = rand.nextInt(6) + 1;
            int d2 = rand.nextInt(6) + 1;
            //System.out.println("roll is " + d1 + " + " + d2 + " = " + (d1 + d2));
            counts[d1 + d2]++;
        }
        for(int k = 2; k < counts.length; k++)
        System.out.println(k + "'s = " + counts[k] + ";\t" + 100.0 * counts[k]/rolls);
    }

    public static void countShakespeare() {
        String[] plays = {"caesar.txt", "errors.txt", "hamlet.txt", "likeit.txt", "macbeth.txt", "romeo.txt"};
        //Test on a smaller file:
        //String[] plays = {"small.txt"};

        String[] common = getCommon();
        int[] counts = new int[common.length];
        for (int k = 0; k < plays.length; k++) {
            FileResource resource = new FileResource("src/main/resources/week1/data/" + plays[k]);
            countWords(resource, common, counts);
            System.out.println("Done with " + plays[k]);
        }

        for(int k = 0; k < common.length; k++)
            System.out.println(common[k] + "\t" + counts[k]);
    }

    public static String[] getCommon() {
        FileResource resource = new FileResource("src/main/resources/week1/data/common.txt");
        String[] common = new String[20];
        int index = 0;
        for (String s : resource.words()) {
            common[index] = s;
            index++;
        }
        return common;
    }

    public static void countWords(FileResource resource, String[] common, int[] counts) {
        for (String word : resource.words()) {
            word = word.toLowerCase();
            int index = indexOf(common, word);
            if (index != -1) {
                counts[index]++;
            }
        }
    }

    public static int indexOf(String[] list, String word) {
        for(int k = 0; k < list.length; k++) {
            if (list[k].equals(word)) {
                return k;
            }
        }
        return -1;
    }

    public static String decrypt(String encrypted) {
        CaesarCipher cc = new CaesarCipher(); // this is yours class :)
        int[] freqs = textFingerPrint(encrypted);
        int maxDex = maxIndex(freqs);
        int dkey = maxDex - 4; // find the distance to the actual e letter
        if (maxDex < 4) {
            dkey = 26 - (4 - maxDex);
        }
        return cc.encrypt(encrypted, 26 - dkey);
    }

    public static int maxIndex(int[] vals) {
        int maxDex = 0;
        for (int k = 0; k < vals.length; k++) {
            if(vals[k] > vals[maxDex])
                maxDex = k;
        }
        return maxDex;
    }
}
