package org.academy.kata.implementation.KhrystynaPavlikovska;

import org.academy.kata.Six;


import java.util.Arrays;

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
        String[] townRecords = strng.split("\n");

        for (String record : townRecords) {
            if (record.startsWith(town + ":")) {

                String[] rainfallValues = record.replaceAll("[^0-9.,]+", "").split(",");
                double[] rainfallArray = Arrays.stream(rainfallValues).mapToDouble(Double::parseDouble).toArray();
                return Arrays.stream(rainfallArray).average().orElse(-1.0);
            }
        }

        return -1.0;
    }

    public double variance(String town, String strng) {
        String[] townRecords = strng.split("\n");

        for (String record : townRecords) {
            if (record.startsWith(town + ":")) {

                String[] rainfallValues = record.replaceAll("[^0-9.,]+", "").split(",");
                double[] rainfallArray = Arrays.stream(rainfallValues).mapToDouble(Double::parseDouble).toArray();
                double mean = Arrays.stream(rainfallArray).average().orElse(-1.0);
                return Arrays.stream(rainfallArray).map(x -> Math.pow(x - mean, 2)).average().orElse(-1.0);
            }
        }

        return -1.0;
    }

    public String nbaCup(String resultSheet, String toFind) {
        return null;
    }

    public String stockSummary(String[] lstOfArt, String[] lstOf1stLetter) {
        return null;
    }
}
