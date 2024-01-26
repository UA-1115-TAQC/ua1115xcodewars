package org.academy.kata.implementation.Natalsa566;

import org.academy.kata.Six;

import java.util.HashMap;
import java.util.Map;

public class SixImpl implements Six {

    public long findNb(long m) {
        return 0;
    }

    public String balance(String book) {
         StringBuilder result = new StringBuilder();
         double balance = 0.0;
         double totalExpense = 0.0;
         int expenseCount = 0;
         String[] lines = book.split("\n");
            for (String line : lines) {
                if (!line.trim().isEmpty()) {
                    String cleanedLine = line.replaceAll("[^a-zA-Z0-9.\\s]", "");
                    String[] parts = cleanedLine.split("\\s+");
                        if (parts.length > 0 && parts[0].matches("\\d+")) {
                            int checkNumber = Integer.parseInt(parts[0]);
                            double checkAmount = Double.parseDouble(parts[1]);
                            balance -= checkAmount;
                            totalExpense += checkAmount;
                            expenseCount++;
                       result.append(String.format("%d %s %.2f Balance %.2f%n", checkNumber, parts[2], checkAmount, balance));
                        }
                    }
            }
        result.append(String.format("Total expense  %.2f%n", totalExpense));
        result.append(String.format("Average expense  %.2f", totalExpense / expenseCount));
        return result.toString();
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
        if (lstOfArt.length == 0 || lstOf1stLetter.length == 0) {
            return "";
        }
        Map<String, Integer> categorySumMap = new HashMap<>();
        for (String art : lstOfArt) {
            String[] parts = art.split(" ");
            String category = parts[0].substring(0, 1);

            if (categorySumMap.containsKey(category)) {
                categorySumMap.put(category, categorySumMap.get(category) + Integer.parseInt(parts[1]));
            } else {
                categorySumMap.put(category, Integer.parseInt(parts[1]));
            }
        }
        StringBuilder result = new StringBuilder();
        for (String letter : lstOf1stLetter) {
            int sum = categorySumMap.getOrDefault(letter, 0);
            result.append("(").append(letter).append(" : ").append(sum).append(") - ");
        }
        result.setLength(result.length() - 3);

        return result.toString();
    }
}
