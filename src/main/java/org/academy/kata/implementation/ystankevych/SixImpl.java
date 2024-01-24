package org.academy.kata.implementation.ystankevych;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
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
        return 0;
    }

    public double variance(String town, String strng) {
        return 0;
    }

    public String nbaCup(String resultSheet, String toFind) {
        if (resultSheet == null || toFind == null
                || resultSheet.isBlank() || toFind.isBlank()) {
            return "";
        }
        if (!resultSheet.contains(toFind + " ")) {
            return "%s:This team didn't play!".formatted(toFind);
        }

        final Pattern p = Pattern.compile("""
                ^(?:\\w+\\s)+(\\d+)\\s(?:\\w+\\s)+(\\d+)$""");
        final Map<String, Integer> statistics = new HashMap<>();
        for (String s : parseNbaSheet(resultSheet, toFind)) {
            Matcher m = p.matcher(s);
            if (!m.find()) {
                return "Error(float number):%s".formatted(s);
            }
            if (s.startsWith(toFind)) {
                updateStatistics(statistics, Integer.parseInt(m.group(1)), Integer.parseInt(m.group(2)));
            } else {
                updateStatistics(statistics, Integer.parseInt(m.group(2)), Integer.parseInt(m.group(1)));
            }
        }
        return "%s:W=%d;D=%d;L=%d;Scored=%d;Conceded=%d;Points=%d"
                .formatted(toFind, statistics.get("W"), statistics.get("D"), statistics.get("L"),
                        statistics.get("Scored"), statistics.get("Conceded"), statistics.get("Points"))
                .replaceAll("null", "0");
    }

    private void updateStatistics(Map<String, Integer> statistics, int first, int second) {
        if (first > second) {
            statistics.merge("W", 1, Integer::sum);
            statistics.merge("Points", 3, Integer::sum);
        } else if (first < second) {
            statistics.merge("L", 1, Integer::sum);
        } else {
            statistics.merge("D", 1, Integer::sum);
            statistics.merge("Points", 1, Integer::sum);
        }
        statistics.merge("Scored", first, Integer::sum);
        statistics.merge("Conceded", second, Integer::sum);
    }

    private static String[] parseNbaSheet(String resultSheet, String toFind) {
        return Arrays.stream(resultSheet.split(","))
                .filter(s -> !s.isBlank() && s.contains(toFind + " "))
                .map(s -> s.replaceAll("\\s+", " "))
                .toArray(String[]::new);
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
