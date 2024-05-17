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
}
