import java.util.ArrayList;
import java.util.List;

/**
 * Created by Omer on 3/11/2016.
 */


/*
Access codes
============

You've discovered the evil laboratory of Dr. Boolean, and you've found that the vile doctor is transforming your fellow rabbit kin into terrifying rabbit-zombies! Naturally, you're less-than-happy about this turn of events.

Of course where there's a will, there's a way. Your top-notch assistant, Beta Rabbit, managed to sneak in and steal some access codes for Dr. Boolean's lab in the hopes that the two of you could then return and rescue some of the undead rabbits. Unfortunately, once an access code is used it cannot be used again. Worse still, if an access code is used, then that code backwards won't work either! Who wrote this security system?

Your job is to compare a list of the access codes and find the number of distinct codes, where two codes are considered to be "identical" (not distinct) if they're exactly the same, or the same but reversed. The access codes only contain the letters a-z, are all lowercase, and have at most 10 characters. Each set of access codes provided will have at most 5000 codes in them.

For example, the access code "abc" is identical to "cba" as well as "abc." The code "cba" is identical to "abc" as well as "cba." The list ["abc," "cba," "bac"] has 2 distinct access codes in it.

Write a function answer(x) which takes a list of access code strings, x, and returns the number of distinct access code strings using this definition of identical.

Languages
=========

To provide a Python solution, edit solution.py
To provide a Java solution, edit solution.java

Test cases
==========

Inputs:
    (string list) x = ["foo", "bar", "oof", "bar"]
Output:
    (int) 2

Inputs:
    (string list) x = ["x", "y", "xy", "yy", "", "yx"]
Output:
    (int) 5
 */
public class AccessCodes {

    /*
    We need 2 things here, a method to efficiently reverse a string and a list of unique access codes.
    We'll compare all strings and their reverses to what we have in our list. If both the string and it's reverse don't exist
    in our list I'll add them.

    In the end we return the size of our unique access code list.
     */
    public static int answer(String[] x) {
        List<String> uniqueCodes = new ArrayList<>();

        for(String s : x){
            boolean notUnique = uniqueCodes.contains(s) || uniqueCodes.contains(reverseString(s));
           if(!notUnique){
               uniqueCodes.add(s);
           }
        }

        return uniqueCodes.size();
    }

    /*
    Reverse a string in its place by swapping characters from the beginning and the end of the string incrementing towards the center.
     */
    public static String reverseString(String s){
        char[] c = s.toCharArray();
        int len = c.length;
        for(int i = 0;i<len/2;i++){
            char temp = c[i];
            c[i] = c[(len-1)-i];
            c[(len-1)-i] = temp;
        }
        return new String(c);
    }
}
