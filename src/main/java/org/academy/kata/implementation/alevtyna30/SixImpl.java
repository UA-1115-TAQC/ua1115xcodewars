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
        String t = book.replaceAll("([^\\n. \\da-zA-Z])", "");
        String[] arr = t.split("[\\n]+");
        double current = Double.parseDouble(arr[0]);
        double total = 0;
        int count = 0;
        StringBuilder result = new StringBuilder();
        result.append("Original Balance: " + arr[0]);
        for (int i = 1; i < arr.length; i++) {
            count++;
            String[] line = arr[i].split("[ ]+");
            current -= Double.parseDouble(line[2]);
            total += Double.parseDouble(line[2]);
            String u = String.format("\\r\\n%s %s %s Balance %.2f", line[0], line[1], line[2], current);
            result.append(u);
        }
        result.append(String.format("\\r\\nTotal expense  %.2f\\r\\nAverage expense  %.2f", total, total / count));
        return result.toString();
    }

    public double f(double x) {
        return x / (1 + Math.sqrt(1 + x));
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
