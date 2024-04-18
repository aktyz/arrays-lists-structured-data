package org.coursera.duke.java.week1;

public class WordPlay {
    public static boolean isVowel(Character ch)
    {
        String vowels = "aeiouAEIOU";
        int i = 0;
        while(vowels.length() > i)
        {
            if(ch.equals(vowels.charAt(i)))
                return true;
            i++;
        }
        return false;
    }

    public static String replaceVowels(String phase, Character ch)
    {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (phase.length() > i)
        {
            if(isVowel(phase.charAt(i)))
            {
                sb.append(ch);
            }
            else sb.append(phase.charAt(i));
            i++;
        }
        return sb.toString();
    }

    public static String emphasize(String phrase, Character ch)
    {
        StringBuilder chs = new StringBuilder();
        StringBuilder results = new StringBuilder();
        chs.append(ch);
        if(Character.isUpperCase(ch))
            chs.append(Character.toLowerCase(ch));
        else if(Character.isLowerCase(ch))
            chs.append(Character.toUpperCase(ch));
        int i = 0;
        while (phrase.length() > i)
        {
            Character phraseChar = phrase.charAt(i);
            if(doesContain(chs.toString(), phraseChar))
            {
                if(i == 0)
                    results.append('*');
                if(i % 2 == 1)
                    results.append('+');
                if(i % 2 == 0)
                    results.append('*');
            }
            else
                results.append(phraseChar);
            i++;
        }
        return results.toString();
    }

    public static boolean doesContain(String keys, Character c)
    {
        int i = 0;
        while (keys.length() > i) {
            if (keys.charAt(i) == c)
                return true;
            i++;
        }
        return false;
    }
    public static void testIsVowel()
    {
        boolean result = isVowel('F');
        if(result != false) System.out.println("Test case 1 failed");
        result = isVowel('a');
        if(result != true) System.out.println("Test case 2 failed");
        result = isVowel('0');
        if(result != false) System.out.println("Test case 3 failed");
        result = isVowel('U');
        if(result != true) System.out.println("Test case 4 failed");
        System.out.println("Tests of isVowel() method completed\n");
    }

    public static void testReplaceVowels()
    {
        String result = replaceVowels("Hello World", '*');
        System.out.println(result+"\n");
        result = replaceVowels("aeiouAEIOU", '*');
        System.out.println(result+"\n");
        System.out.println("Tests of replaceVowels() method completed\n");
    }

    public static void testEmphasize()
    {
        String result = emphasize("dna ctgaaactga", 'a');
        if(!result.equals("dn* ctg+*+ctg+"))
            System.out.println("Test case 1 failed");
        result = emphasize("Mary Bella Abracadabra", 'a');
        if(!result.equals("M+ry Bell+ +br*c*d*br+"))
            System.out.println("Test case 2 failed");
        System.out.println("Tests of emphasize() method completed\n");
    }
}
