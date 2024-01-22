package org.academy.kata.implementation.Zakotiuk;

import org.academy.kata.Six;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class SixImpl implements Six {
    public long findNb(long m) {
        return 0;
    }

    public String balance(String book) {
        return null;
    }

    public double f(double x) {
        return 0;
    }

    public double mean(String town, String strng) {
        return 0;
    }

    public double variance(String town, String strng) {
        return 0;
    }

    public String nbaCup(String resultSheet, String toFind) {
        return null;
    }

    public String stockSummary(String[] lstOfArt, String[] lstOf1stLetter) {

        if (lstOfArt.length == 0 || lstOf1stLetter.length == 0) {
            return "";
        }

        Map<Character, Integer> categoryCounts = new HashMap<>();

        for (String s : lstOfArt) {
            String[] letter_count = s.split(" ");

            char letter = letter_count[0].toCharArray()[0];
            int count = Integer.parseInt(letter_count[1]);

            for (String item : lstOf1stLetter) {
                if (Objects.equals(item, "" + letter)) {
                    if (categoryCounts.containsKey(letter))
                        categoryCounts.put(letter, categoryCounts.get(letter) + count);
                    else
                        categoryCounts.put(letter, count);
                }
            }
        }

        StringBuilder result = new StringBuilder();
        for (String letter : lstOf1stLetter) {
            char category = letter.charAt(0);
            int count = categoryCounts.getOrDefault(category, 0);
            result.append("(").append(category).append(" : ").append(count).append(") - ");
        }
        result.delete(result.length() - 3, result.length());

        return result.toString();
    }
}
