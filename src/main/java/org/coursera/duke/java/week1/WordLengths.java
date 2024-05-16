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
            if(counts[i] > 0)
                System.out.println("Number of words of length " + i + ":\t" + counts[i]);
            i++;
        }
    }

    public static void testCountWordLengths() {
        int[] counts = new int[31];
        countWordLengths(new FileResource("src/main/resources/week1/data/smallHamlet.txt"), counts);
    }
}
