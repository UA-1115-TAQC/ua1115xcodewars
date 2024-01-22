package org.academy.kata.implementation.ystankevych;

import java.util.Arrays;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import org.academy.kata.Six;

public class SixImpl implements Six {
    public long findNb(long m) {
        long counter = 0;
        while (m > 0) {
            m -= (long) Math.pow(++counter, 3);
        }
        return m == 0 ? counter : -1;
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
        if (lstOfArt == null || lstOf1stLetter == null || lstOfArt.length == 0
                || lstOf1stLetter.length == 0) {
            return "";
        }
        return Arrays.stream(lstOf1stLetter)
                .map(s -> "(%s : %d)".formatted(s, Arrays.stream(lstOfArt)
                        .filter(a -> a.startsWith(s))
                        .mapToInt(a -> Integer.parseInt(a.split("\\s")[1])).sum()))
                .collect(Collectors.joining(" - "));
    }
}
