package org.coursera.duke.java.week1;

import edu.duke.FileResource;

public class WordLengths {
    public static void countWordLengths(FileResource resource, int[] counts) {
        int i = 0;
        int wordLength = 0;

        for (String s : resource.words()) {
            while(i < s.length()) {
                if(Character.isLetter(s.charAt(i)))
                    wordLength++;
                else if(i + 1 < s.length() && Character.isLetter(s.charAt(i + 1)))
                    wordLength++;
                i++;
            }
            counts[wordLength]++;
            i = 0;
            wordLength = 0;
        }
        i = 1;
        while (i < counts.length) {
            System.out.println("Number of words of length " + i + ":\t" + counts[i]);
            i++;
        }
    }

    private static int findNextAlphabeticIndex(String word, int start) {
        for (int k = start; k < word.length(); k++) {
            if(Character.isAlphabetic(word.charAt(k)))
                return k;
        }
        return -1; // not found
    }

    private static int findNextNonAlphabeticIndex(String word, int start) {
        for (int k = start; k < word.length(); k++) {
            if(!Character.isAlphabetic(word.charAt(k)))
                return k;
        }
        return -1; // not found
    }
}
