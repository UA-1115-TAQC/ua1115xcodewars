package org.academy.kata.implementation.Natalsa566;

import org.academy.kata.Six;

import java.util.HashMap;
import java.util.Map;

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
        Map<String, Integer> categorySumMap = new HashMap<>();
        for (String art : lstOfArt) {
            String[] parts = art.split(" ");
            String category = parts[0].substring(0, 1);

            if (categorySumMap.containsKey(category)) {
                categorySumMap.put(category, categorySumMap.get(category) + Integer.parseInt(parts[1]));
            } else {
                categorySumMap.put(category, Integer.parseInt(parts[1]));
            }
        }
        StringBuilder result = new StringBuilder();
        for (String letter : lstOf1stLetter) {
            int sum = categorySumMap.getOrDefault(letter, 0);
            result.append("(").append(letter).append(" : ").append(sum).append(") - ");
        }
        result.setLength(result.length() - 3);

        return result.toString();
    }
}
