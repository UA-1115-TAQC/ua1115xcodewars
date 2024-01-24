package org.academy.kata.implementation.Natalsa566;

import org.academy.kata.Six;

import java.util.Arrays;
import java.util.stream.Stream;

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
@Override
    public double mean(String town, String strng) {
        String[] townRecords = getTownRecords(town, strng);
        if (townRecords.length == 0) {
            return -1.0;
        }
        double[] rainfallValues;
        try {
            rainfallValues = Arrays.stream(townRecords)
                    .map(record -> Double.parseDouble(record.split(" ")[1]))
                    .mapToDouble(Double::doubleValue)
                    .toArray();
        } catch (NumberFormatException e) {
            return Double.NaN;
        }
        return Arrays.stream(rainfallValues).average().orElse(Double.NaN);
    }
    private static String[] getTownRecords(String town, String strng) {
        return Stream.of(strng.split("\n"))
                .filter(record -> record.startsWith(town + ":"))
                .findFirst()
                .map(record -> record.substring(record.indexOf(":") + 1).split(","))
                .orElse(new String[0]);
    }


    public double variance(String town, String strng) {
        return 0;
    }

    public String nbaCup(String resultSheet, String toFind) {
        return null;
    }

    public String stockSummary(String[] lstOfArt, String[] lstOf1stLetter) {
        return null;
    }
}
