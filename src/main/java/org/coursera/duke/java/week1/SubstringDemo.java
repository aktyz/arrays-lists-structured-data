package org.coursera.duke.java.week1;

public class SubstringDemo {
    private static String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public static void generateEncryptionString(int ceasarCipherKey)
    {
        long start = System.nanoTime();
        System.out.println(alphabet);
        String encr = alphabet.substring(ceasarCipherKey);
        encr = encr + alphabet.substring(0, ceasarCipherKey);
        System.out.println(encr);
        long finish = System.nanoTime();
        System.out.println("\nMethod time when running on Strings: " + ((finish - start)/1000000) + " nanoseconds");
    }

    public static void generateEncryptionStringUsingStringBuilder(int ceasarCipherKey)
    {
        long start = System.nanoTime();
        System.out.println(alphabet);
        StringBuilder encr = new StringBuilder(alphabet.substring(ceasarCipherKey));
        encr.append(alphabet.substring(0, ceasarCipherKey));
        System.out.println(encr);
        long finish = System.nanoTime();
        System.out.println("\nMethod time when running on StringBuilders: " + ((finish - start)/1000000) + " nanoseconds");
    }
}
