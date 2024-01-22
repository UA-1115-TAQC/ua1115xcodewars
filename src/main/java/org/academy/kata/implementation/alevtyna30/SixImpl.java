package org.academy.kata.implementation.alevtyna30;

import org.academy.kata.Six;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.averagingDouble;

public class SixImpl implements Six {
    public long findNb(long m) {
        long volume = 0;
        int n = 1;

        while (volume < m) {
            volume += (long) Math.pow(n, 3);
            if (volume == m) {
                return n;
            }
            n++;
        }
        return -1;
}

    public String balance(String book) {
        return null;
    }

    public double f(double x) {
        return 0;
    }

    public double mean(String town, String strng) {
        return parseTemp(town, strng).stream()
                .collect(averagingDouble(n -> n));
    }
    public double variance(String town, String strng) {
        double mean = mean(town, strng);
        if (mean == -1.0) return -1.0;

        return parseTemp(town, strng).stream()
                .collect(averagingDouble(n -> (n - mean) * (n - mean)));
    }
    private static List<Double> parseTemp(String town, String strng) {
        List<Double> temps = new ArrayList<>();
        for (String line : strng.split("\\n")) {
            String[] data = line.split(":");
            if (town.equals(data[0])) {
                for (String weather : data[1].split(",")) {
                    String[] temp = weather.split("\\s");
                    temps.add(Double.parseDouble(temp[1]));
                }
                break;
            }
        }
        if (temps.isEmpty()) temps.add(-1.0);

        return temps;
    }

    public String nbaCup(String resultSheet, String toFind) {
        return null;
    }

    public String stockSummary(String[] lstOfArt, String[] lstOf1stLetter) {
        return null;
    }
}
