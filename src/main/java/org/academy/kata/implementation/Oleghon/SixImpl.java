package org.academy.kata.implementation.Oleghon;

import org.academy.kata.Six;

import java.util.regex.Pattern;

public class SixImpl implements Six {
    public long findNb(long m) {
        return 0;
    }

    public String balance(String book) {
        EightImpl eight = new EightImpl();
        final var pattern = Pattern.compile("[0-9]{1,}(\\.[0-9]*)");
        String[] cleanedBook = book.replaceAll("=|:|;|!|\\?|,|\\{|\\}", "").split("\n| ");
        float total = 0.0f;
        int count = 0;

        float balance = Float.parseFloat(cleanedBook[0]);
        final var sb = new StringBuilder("Original Balance: " + cleanedBook[0] + "\n");

        for (int i = 1; i < cleanedBook.length; i++) {
            if (cleanedBook[i].isEmpty()) continue;
            if (pattern.matcher(cleanedBook[i]).find()) {
                float d = Float.parseFloat(cleanedBook[i]);
                sb.append(String.format("%.2f", d));
                balance -= d;
                total += d;
                count++;
                sb.append(" Balance ").append(String.format("%.2f", balance)).append("\\r\\n");
                continue;
            }
            sb.append(cleanedBook[i]).append(" ");
        }
        sb.append("Total expense  ")
                .append(String.format("%.2f", total))
                .append("\\r\\n")
                .append("Average expense  ")
                .append(String.format("%.2f", eight.TwoDecimalPlaces(total / count)));
        return sb.toString();
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
        return null;
    }
}
