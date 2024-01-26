package org.academy.kata.implementation.KhrystynaPavlikovska;

import org.academy.kata.Six;


import java.util.HashMap;
import java.util.Map;

public class SixImpl implements Six {
    public long findNb(long m) {

        long sum = 0;
        long n = 1;

        while (sum < m) {
            sum += n * n * n;
            n++;
        }

        return (sum == m) ? n - 1 : -1;
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

        Map<Character, Integer> categorySum = new HashMap<>();

        for (String book : lstOfArt) {
            char category = book.charAt(0);
            int quantity = Integer.parseInt(book.split(" ")[1]);

            categorySum.put(category, categorySum.getOrDefault(category, 0) + quantity);
        }

        StringBuilder result = new StringBuilder();

        for (String category : lstOf1stLetter) {
            char key = category.charAt(0);
            int sum = categorySum.getOrDefault(key, 0);
            result.append(String.format("(%s : %d) - ", category, sum));
        }

        return result.substring(0, result.length() - 3);
    }
}
