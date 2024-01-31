package org.academy.kata.implementation.ystankevych;

import org.academy.kata.Six;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;

public class SixImpl implements Six {
    private static String[] parseNbaSheet(String resultSheet, String toFind) {
        return Arrays.stream(resultSheet.split(","))
                .filter(s -> !s.isBlank() && s.contains(toFind + " "))
                .map(s -> s.replaceAll("\\s+", " "))
                .toArray(String[]::new);
    }

    public long findNb(long m) {
        long counter = 0;
        while (m > 0) {
            m -= (long) Math.pow(++counter, 3);
        }
        return m == 0 ? counter : -1;
    }

    public String balance(String book) {
        String[] bookArray = parseBookToArray(book);

        final double balance = parseDouble(bookArray[0], bookArray[0]);
        final String lineSeparator = "\\r\\n";

        StringBuilder report = new StringBuilder("Original Balance: %.2f".formatted(balance));
        double totalExpense = 0;
        for (int i = 1; i < bookArray.length; i++) {
            report.append(lineSeparator).append(bookArray[i]);
            totalExpense += parseDouble(bookArray[i].split(" ")[2], bookArray[i]);
            report.append(" %s %.2f".formatted("Balance", balance - totalExpense));
        }
        return report.append(lineSeparator)
                .append("%s  %.2f".formatted("Total expense", balance - totalExpense))
                .append(lineSeparator)
                .append("%s  %.2f".formatted("Average expense", totalExpense / (bookArray.length - 1)))
                .toString();
    }

    private String[] parseBookToArray(String book) {
        return Arrays.stream(book.split("\n"))
                .map(s -> s.replaceAll("\\s+", " "))
                .map(s -> s.replaceAll("[\\p{Punct}&&[^.]]", "").strip())
                .filter(s -> !s.isBlank())
                .toArray(String[]::new);
    }

    private double parseDouble(String value, String raw) {
        try {
            return Double.parseDouble(value);
        } catch (NumberFormatException e) {
            throw new RuntimeException("Invalid number format for the raw: " + raw);
        }
    }

    public double f(double x) {
        return x >= -1 ? x / (Math.sqrt(1 + x) + 1.0) : 0;
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

    private DoubleStream getStatisticsByTown(String town, String strng) {
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
