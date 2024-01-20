package org.academy.kata.implementation.ystankevych;

import org.academy.kata.Six;

import java.util.Arrays;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;

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
        return getStatisticsByTown(town, strng)
                .average()
                .orElse(-1);
    }

    public double variance(String town, String strng) {
        final double average = mean(town, strng);
        return average < 0 ? -1 : getStatisticsByTown(town, strng)
                .boxed()
                .collect(Collectors.averagingDouble(v -> Math.pow(v - average, 2)));
    }

    private static DoubleStream getStatisticsByTown(String town, String strng) {
        return Pattern.compile("(?m)^" + town + ":(.*)$")
                .matcher(strng)
                .results()
                .map(s -> s.group(1))
                .flatMap(s -> Arrays.stream(s.split(","))
                        .filter(c -> !c.isBlank())
                        .map(c -> c.replaceAll("[^\\d.]", "")))
                .mapToDouble(Double::parseDouble);
    }

    public String nbaCup(String resultSheet, String toFind) {
        return null;
    }

    public String stockSummary(String[] lstOfArt, String[] lstOf1stLetter) {
        return null;
    }
}
