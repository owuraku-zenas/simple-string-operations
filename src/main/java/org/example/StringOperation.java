package org.example;

import java.util.*;

public class StringOperation {

    public static boolean palindrome(String phrase) {
        phrase = phrase.replace(" ", "").toLowerCase();

        for (int i=0; i < Math.floorDiv(phrase.length(), 2); i++) {
            if (phrase.charAt(i) != phrase.charAt(phrase.length()-(i+1))) {
                return false;
            }
        }

        return true;
    }

//    public static boolean hasUniqueCharacters(String phrase) {
//        phrase = phrase.replace(" ", "").toLowerCase();
//
//        char[] arrayPhrase = phrase.toCharArray();
//
//        Map<Character, Integer> charFrequency = new HashMap<>();
//
//        for (char character: arrayPhrase) {
//            int frequency = charFrequency.getOrDefault(character, 0);
//            if (frequency > 0) return false;
//            charFrequency.put(character, frequency+1);
//        }
//
//        return true;
//    }
//
//    public static boolean hasUniqueCharactersWithoutMap(String phrase) {
//        phrase = phrase.replace(" ", "").toLowerCase();
//
//        char[] arrayPhrase = phrase.toCharArray();
//
//
//        for (int i = 0; i < arrayPhrase.length-1; i++) {
//            for (int j = i+1; j < arrayPhrase.length; j++) {
//                if (arrayPhrase[i] == arrayPhrase[j]) return false;
//            }
//        }
//        return true;
//    }

    // Last Index of
    public static boolean hasUniqueCharactersUsingLastIndexOf(String phrase) {
        phrase = phrase.replace(" ", "").toLowerCase();

        for (int i = 0; i < Math.floorDiv(phrase.length(),2); i++) {
            if (phrase.lastIndexOf(phrase.charAt(i)) != i) {
                return false;
            }
        }
        return true;
    }

    public static Map<String, List<String>> commonWords(String phrase) {
        phrase = phrase.toLowerCase().replaceAll("[().!?\",]", "");

        String[] arrayOfWords = phrase.split(" ");

        Map<String, Integer> stringFrequency = new HashMap<>();
        for (String word : arrayOfWords) {
            int frequency = stringFrequency.getOrDefault(word, 0);
            stringFrequency.put(word, frequency+1);
        }

        List<Map.Entry<String, Integer>> stringFrequencyList = new ArrayList<>(stringFrequency.entrySet());

        stringFrequencyList.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));

        List<String> topThree = new ArrayList<>();
        List<String> bottomThree = new ArrayList<>();

       if (stringFrequencyList.size() < 3) {
           stringFrequencyList.forEach((entry)-> topThree.add(entry.getKey()));
           stringFrequencyList.forEach((entry)-> bottomThree.add(entry.getKey()));
       } else {
        stringFrequencyList.subList(0,3).forEach((entry)-> topThree.add(entry.getKey()));
        stringFrequencyList.subList(stringFrequencyList.size()-3,stringFrequencyList.size()).forEach((entry)-> bottomThree.add(entry.getKey()));
       }

        return Map.of("top", topThree, "bottom", bottomThree);
    }

    public static char[] replaceSpace(char[] charArray) {
        String word = new String(charArray);
        return word.replaceAll(" ", "%20").toCharArray();
    }
}
