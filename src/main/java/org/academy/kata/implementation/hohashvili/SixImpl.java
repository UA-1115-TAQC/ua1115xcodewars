package org.academy.kata.implementation.hohashvili;

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
        Map<String, Integer> result = new HashMap<>();
        for(String val: lstOf1stLetter) {
            result.put(val, 0 );
            for (String stock: lstOfArt) {

                if (String.valueOf(stock.charAt(0)).equals(val)) {
                    String[] splitStock = stock.split(" ");
                    int stockValue = Integer.parseInt(splitStock[1]);
                    result.put(val, result.get(val) + stockValue );
                }
            }
        }

        String formattedResult = "";
        // Format
        for (String key: result.keySet()) {
            String val = "(" + key + " : " + result.get(key) + ") - ";
            formattedResult += val;
        }

        return formattedResult.substring(0,formattedResult.length()-3);
    }
}
