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

    public static int indexOfMax(int[] counts) {
        int max = counts[0];
        int maxIndex = 0;
        int i = 1;
        while (i < counts.length) {
            if(counts[i] > max) {
                max = counts[i];
                maxIndex = i;
            }
            i++;
        }
        return (maxIndex);
    }
    public static void testCountWordLengths() {
        int[] counts = new int[31];
        countWordLengths(new FileResource("src/main/resources/week1/data/smallHamlet.txt"), counts);

        int maxIndex = indexOfMax(counts);
        if(maxIndex != 3) {
            System.out.println("Index of Max test failed!");
            System.out.println("Count[maxIndex] = " + counts[maxIndex] +",\tmaxIndex = " + maxIndex);
        }
        else {
            System.out.println("Index of Max Test succeeded!");
        }
    }

    private static void zeroArray(int[] a) {
        int i = 0;
        while (i < a.length) {
            a[i] = 0;
            i++;
        }
    }
    public static void breakingTheCaesarCipherTest() {
        int[] counts = new int[31];
        System.out.println("Counting the length of special strings");
        countWordLengths(new FileResource("src/main/resources/week1/data/specials.txt"), counts);
        zeroArray(counts);
        System.out.println();
        System.out.println("Counting the lengths of words in romeo.txt");
        countWordLengths(new FileResource("src/main/resources/week1/data/romeo.txt"), counts);
        System.out.println("Index of max: " + indexOfMax(counts) + ", with max number of words: " + counts[indexOfMax(counts)]);
        zeroArray(counts);
        System.out.println();
        System.out.println("Counting the lengths of words in lotsOfWords.txt");
        countWordLengths(new FileResource("src/main/resources/week1/data/lotsOfWords.txt"), counts);
        System.out.println("Index of max: " + indexOfMax(counts) + ", with max number of words: " + counts[indexOfMax(counts)]);
        zeroArray(counts);
        System.out.println();
        
    }
}
