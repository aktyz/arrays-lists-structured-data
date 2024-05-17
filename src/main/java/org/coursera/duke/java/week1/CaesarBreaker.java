package org.coursera.duke.java.week1;

public class CaesarBreaker {
    public static int[] countLetters(String s) {
        String alpha = "abcdefghijklmnopqrstuvwxyz";
        int[] counters = new int[26];
        for (int k = 0; k < s.length(); k++) {
            char ch = s.charAt(k);
            int index = alpha.indexOf(Character.toLowerCase(ch));
            if (index != -1)
                counters[index] += 1;
        }
        return counters;
    }

    public static int maxIndex(int[] counters) {
        int i = 1;
        int maxIndex = 0;
        int max = counters[maxIndex];

        while (i < counters.length) {
            if (counters[i] > max) {
                max = counters[i];
                maxIndex = i;
            }
            i++;
        }
        return maxIndex;
    }
    public static String decrypt(String encrypted) {
        CaesarCipher cc = new CaesarCipher(); // this is yours class :)
        int[] freqs = countLetters(encrypted);
        int maxDex = maxIndex(freqs);
        int dkey = maxDex - 4; // find the distance to the actual e letter
        if (maxDex < 4) {
            dkey = 26 - (4 - maxDex);
        }
        return cc.encrypt(encrypted, 26 - dkey);
    }
    public static void testDecrypt() {
        CaesarCipher cc = new CaesarCipher();
        String message = "In this assignment, you will complete the PerimeterAssignmentRunner class to calculate lots of interesting facts about shapes. This class has been started for you in the BlueJ project called PerimeterAssignmentRunnerStarterCode (this is the same project file that we were looking at in the previous reading, so feel free to open the one you downloaded for the last reading). This project also contains several data files. In addition, you will need to look at the documentation for the Shape class and the Point class, which we went over in the last reading.";
        int key = 0;
        while (key < 27) {
            String encrypted = cc.encrypt(message, key);
            String decrypted = decrypt(encrypted);
            if (!message.equals(decrypted)) {
                System.out.println("Your methods failed for key " + key);
            }
            key++;
        }
        System.out.println("TestDecrypt completed!");
    }

    public static String halfOfString(String message, int start) {
        StringBuilder sb = new StringBuilder();
        while(start < message.length()) {
            sb.append(message.charAt(start));
            start += 2;
        }
        return sb.toString();
    }

    public static void testHalfOfString() {
        String message = "Qbkm Zgis";
        if (!halfOfString(message, 0).equals("Qk gs")) {
            System.out.println("Your method failed starting from the index 0");
        }
        if(!halfOfString(message, 1).equals("bmZi")) {
            System.out.println("Your method failed starting from the index 1");
        }
        System.out.println("Test halfOfString() completed!");
    }

    public static int getKey(String s) {
        int[] frequencies = countLetters(s);
        int maxFreqPosition = maxIndex(frequencies);
        int k = 0;
        if (maxFreqPosition < 4)
            k = 26 - (4 - maxFreqPosition);
        else
            k = maxFreqPosition - 4;
        return k;
    }

    public static String decryptTwoKeys(String encrypted) {
        CaesarCipher cc = new CaesarCipher();
        StringBuilder startedFrom0 = new StringBuilder();
        StringBuilder startedFrom1 = new StringBuilder();
        startedFrom0.append(halfOfString(encrypted, 0));
        startedFrom1.append(halfOfString(encrypted, 1));
        int key0 = getKey(startedFrom0.toString());
        int key1 = getKey(startedFrom1.toString());
        System.out.println("My guess for key0: " + key0 + ", and key1: " + key1);
        return cc.encryptTwoKeys(encrypted, 26 - key0, 26 - key1);
    }

    public static void testDecryptTwoKeys() {
        String message = "Just a test string with lots of eeeeeeeeeeeeeeeees";
        String encrypted = "Gwpv c vbuq pvokki yfve iqqu qc bgbgbgbgbgbgbgbgbu";
        System.out.println("Encrypted with key0: 23, and key1: 2");
        String result = decryptTwoKeys(encrypted);
        if (!result.equals("Just a test string with lots of eeeeeeeeeeeeeeeees")) {
            System.out.println("Your method failed! Your decryption:");
            System.out.println(result);
        }
        System.out.println("Test decryptTwoKeys() completed!");
    }
}
