package org.coursera.duke.java.week1;

import edu.duke.FileResource;

public class CaesarCipher {

    private static String upperCaseAlphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static String encrypt(String input, int key)
    {
        StringBuilder result = new StringBuilder();
        int i = 0;
        while (i < input.length())
        {
            result.append(encryptChar(input.charAt(i), key));
            i++;
        }
        return result.toString();
    }

    public static String encryptTwoKeys(String input, int key1, int key2)
    {
        StringBuilder result = new StringBuilder();
        int i = 0;
        while (i < input.length()) {
            if (i % 2 == 1) {
                result.append(encryptChar(input.charAt(i), key2));
            } else {
                result.append(encryptChar(input.charAt(i), key1));
            }
            i++;
        }
        return result.toString();
    }

    public static Character encryptChar(Character letter, int key)
    {
        String encriptionString = generateEncryptionString(key);
        int letterIndex;
        if(Character.isUpperCase(letter)) {
            letterIndex = upperCaseAlphabet.indexOf(letter);
            return encriptionString.charAt(letterIndex);
        }
        else if (Character.isLowerCase(letter)){
            letterIndex = upperCaseAlphabet.indexOf(Character.toUpperCase(letter));
            return Character.toLowerCase(encriptionString.charAt(letterIndex));
        }
        else return letter;
    }
    public static void testCaesar()
    {
        int key = 3;
        FileResource fr = new FileResource();
        String message = fr.asString();
        String encrypted = encrypt(message, key);
        System.out.println("Message encrypted with key " + key + ", resulting in:\n" + encrypted);
    }

    public static void testEncrypt()
    {
        String message1 = "FIRST LEGION ATTACK EAST FLANK!";
        String result1 = encrypt(message1, 23);
        if(!result1.equals("CFOPQ IBDFLK XQQXZH BXPQ CIXKH!"))
        {
            System.out.println("First test case failed!\nMy method result:\n" + result1);
        }
        String message2 = message1.toLowerCase();
        String result2 = encrypt(message2, 23);
        if(!result2.equals("cfopq ibdflk xqqxzh bxpq cixkh!"))
        {
            System.out.println("Second test case failed!\nMy method result:\n" + result2);
        }
        String message3 = "First Legion";
        String result3 = encrypt(message3, 23);
        if(!result3.equals("Cfopq Ibdflk"))
        {
            System.out.println("Third test case failed!\nMy method result:\n" + result3);
        }
        String result4 = encrypt(message3, 17);
        if(!result4.equals("Wzijk Cvxzfe"))
        {
            System.out.println("Fourth test case failed!\nMy method result:\n" + result4);
        }
        System.out.println("Testing encrypt() completed!");
    }

    public static void testEncryptTwoKeys()
    {
        String message1 = "First Legion";
        String result1 = encryptTwoKeys(message1, 23, 17);
        if(!result1.equals("Czojq Ivdzle"))
        {
            System.out.println("First test case failed!\nMy method result:\n" + result1);
        }
        System.out.println("Testing encryptTwoKeys() completed!");
    }
    public static String generateEncryptionString(int ceasarCipherKey)
    {
        StringBuilder encr = new StringBuilder(upperCaseAlphabet.substring(ceasarCipherKey));
        encr.append(upperCaseAlphabet.substring(0, ceasarCipherKey));
        return encr.toString();
    }
}
