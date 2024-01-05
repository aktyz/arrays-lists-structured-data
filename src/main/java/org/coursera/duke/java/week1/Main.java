package org.coursera.duke.java.week1;

public class Main {
    public static void main(String[] args) {
        conversionTest();
    }

    public static void conversionTest(){
        String test = "ABCDEFabcdef123!#";
        for(int k=0; k < test.length(); k++){
            char ch = test.charAt(k);
            char uch = Character.toUpperCase(ch);
            char lch = Character.toLowerCase(ch);
            System.out.println(ch+" "+uch+" "+lch);
        }
    }
    private static void digitTest() {
        String test = "ABCabc0123456789';#!";
        for(int k=0; k < test.length(); k++){
            char ch = test.charAt(k);
            if (Character.isDigit(ch)){
                System.out.println(ch+" is a digit");
            }
            if (Character.isAlphabetic(ch)){
                System.out.println(ch+" is alphabetic");
            }
            if (ch == '#'){
                System.out.println(ch +" #hashtag");
            }
        }
    }
}
