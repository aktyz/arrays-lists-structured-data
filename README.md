# Java Programming: Arrays, Lists & Structured Data
My notes and code produced when going through [Duke University Coursera Course](https://www.coursera.org/learn/java-programming-arrays-lists-data/)

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
Although we cannot use String class as String class is immutable. Therefore use StringBuilder:
[StringBuilder Class](https://docs.oracle.com/en/java/javase/14/docs/api/java.base/java/lang/StringBuilder.html)

(!) Play with StringBuilder Mechanics for a while.

### Concept Review: Loops, Indices

#### The Counting Loop used to reverse a String
This is the simple for loop.

Compare the for loop with the while loop. (Continue using while loop as the for loop are banned in 42Warsaw).

Ended up at the "Character Class Video"


