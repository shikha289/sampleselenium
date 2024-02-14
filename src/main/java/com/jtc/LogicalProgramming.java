package com.jtc;
import java.util.HashMap;
import java.util.Set;
public class LogicalProgramming {
    public static void main(String args[]){
        //Question 8: Write a Java Program to find the duplicates of a given String.
        String inputString="7777543888999";
    // Creating a hashmap object.
    HashMap<Character, Integer> hash_map = new HashMap<>();
    char[] strArray = inputString.toCharArray();
for (char c : strArray) {
        if (hash_map.containsKey(c)) {
            hash_map.put(c, hash_map.get(c) + 1);
        }
        else {
            hash_map.put(c, 1);
        }
    }
    // Store the key values in a set and then get the number of each duplicate character.
    Set<Character> keys = hash_map.keySet();
for (char c : keys) {
        if (hash_map.get(c) > 1) {
            System.out.println(c + " repetition-->" + hash_map.get(c));
        }}
        for(int i = 0; i < inputString.length(); i++) {
            char c = inputString.charAt(i);
    if (hash_map.get(c) == 1) {
        System.out.println(c + " is the first not repeated character-->" + hash_map.get(c));
        break;
    }
    }
        //no of each character in a string
      /*  String inputString="pawan''Shikha";
// Creating a hashmap object.
            HashMap<Character, Integer> hash_map = new HashMap<>();
            char[] strArray = inputString.toCharArray();
            for (char c : strArray) {
                if (hash_map.containsKey(c)) {
                    hash_map.put(c, hash_map.get(c) + 1);
                }
                else {
                    hash_map.put(c, 1);
                }
// Print the hashmap object which gives the number of each character in String
        }
        System.out.println(hash_map);*/
}
}