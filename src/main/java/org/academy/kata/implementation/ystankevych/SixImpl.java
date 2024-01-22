package org.academy.kata.implementation.ystankevych;

import java.util.stream.Collectors;
import java.util.Arrays;
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
