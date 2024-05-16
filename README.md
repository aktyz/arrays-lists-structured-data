# Java Programming: Arrays, Lists & Structured Data
My notes and code produced when going through [Duke University Coursera Course](https://www.coursera.org/learn/java-programming-arrays-lists-data/)

This is a follow up course, if you need refresher on the previous one go to your [GitHub notes](https://github.com/aktyz/solving-problems-with-software).
-> checkout the notes on your completed [previous course from O'Reilly](https://github.com/aktyz/OReilly-the-complete-java)

## Week 1
[StringBuilder Documentation](https://docs.oracle.com/en/java/javase/14/docs/api/java.base/java/lang/StringBuilder.html)

### Modern Cryptography: https
Brief story of encoding the messages send over the internet.
Two modern cryptography algorithms:
- RSA
- AES - Elliptic Curve DiffieHellman

History of cryptography starts in Mesopotamia arounc 1500 BCE, where craftsmen were using simple encryption schemes to guard their secrets.
Next we have Roman Empire with the Caesar Cipher which will be the subject of this course. Then we have 1553 and an algorithm described by Giovan Bastiste Belosa, but named after Blaise Vigenere in the 19th century.
Continuing to the 1940s, cryptography was crucial during World War II. Alan Turing was a leader in the code breaking effort and made important contributions in the computer science.

### Caesar Cipher Overwiev
> Substitute each letter with the letter obtained by shifting the alphabet by a fixed amount.
<br><br>

Nice way to work on the Caesar Cipher is to pre-shift the alphabet in the beginning.
Consider the following bit of code, with key of "23";
```java
String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
String encr;

String encr = alphabet.substring(23);
encr = encr + alphabet.substring(0, 23);
```
Although we cannot use String class as String class is immutable. Therefore, use StringBuilder:
[StringBuilder Class](https://docs.oracle.com/en/java/javase/14/docs/api/java.base/java/lang/StringBuilder.html)

(!) Play with StringBuilder Mechanics for a while.
StringBuilder methods are way faster than String methods.
Code snippet to measure the runtime of a method (using System.nanotime()):
```java
long start = System.nanoTime();
long finish = System.nanoTime();
System.out.println("Method time when running on StringBuilders: " + ((finish - start)/1000000) + " nanoseconds");
```

Another interesting library to explore is JMH (Java Microbenchmark Harness).

### Concept Review: Loops, Indices


#### The Counting Loop used to reverse a String
This is the simple for loop.

Compare the for loop with the while loop. (Continue using while loop as the for loop are banned in 42Warsaw).

Ended up at the "Character Class Video"

### Programming Exercise: Breaking the Caesar Cipher

#### Assignment 1: Word lengths

You will write a program to figure out the most common word length of words from a file. To solve this problem you will need to keep track of how many words from a file are of each possible length. You should group all words of length 30 or more together, and you should not count basic punctuation that are the first or last characters of a group of characters.

Specifically, you should do the following:

- [x] Create a new class called WordLengths.
- [x] Write a void method countWordLengths that has two parameters, a FileResource named resource and an integer array named counts. This method should read in the words from resource and count the number of words of each length for all the words in resource, storing these counts in the array counts.
- [ ] Write a void method testCountWordLengths that creates a FileResource so you can select a file, and creates a counts integer array of size 31. This method should call countWordLengths with a file and then print the number of words of each length. Test it on the small file smallHamlet.txt shown below.
- [ ] Write a method indexOfMax that has one parameter named values that is an integer array. This method returns the index position of the largest element in values. Then add code to the method testCountWordLengths to call indexOfMax to determine the most common word length in the file. For example, calling indexOfMax after calling countWordLengths on the file smallHamlet.txt should return 3.

For example, after this method executes, counts[k] should contain the number of words of length k.

If a word has a non-letter as the first or last character, it should not be counted as part of the word length. For example, the word And, would be considered of length 3 (the comma is not counted), the word “blue-jeans” would be considered of length 10 (the double quotes are not counted, but the hyphen is). Note that we will miscount some words, such as “Hello,” which will be counted as 6 since we don’t count the double quotes but will count the comma, but that is OK as there should not be many words in that category.

For any words equal to or larger than the last index of the counts array, count them as the largest size represented in the counts array.

You may want to consider using the Character.isLetter method that returns true if a character is a letter, and false otherwise. For example, Character.isLetter(‘a’) returns true, and Character.isLetter(‘-’) returns false.

First test your program on a small file, such as this simple file shown called smallHamlet.txt
Note this file has words that are:
- 2 words of length 2: My as
- 3 words of length 3: are And the
- 2 words of length 4: Laer give
- 1 word of length 5: winds
- 1 word of length 6: sister
- 1 word of length 7: benefit
- 2 words of length 8: embark’d Farewell
- 1 word of length 11: necessaries



