package org.academy.kata.implementation.KhrystynaPavlikovska;

import org.academy.kata.Six;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SixImpl implements Six {
    public long findNb(long m) {

        long sum = 0;
        long n = 1;

        while (sum < m) {
            sum += n * n * n;
            n++;
        }

        return (sum == m) ? n - 1 : -1;
    }

    public String balance(String book) {

        String cleanedBook = book.replaceAll("[^\\n. \\da-zA-Z]", "");
        String[] transactions = cleanedBook.split("[\\n]+");

        double currentBalance = Double.parseDouble(transactions[0]);
        double totalExpense = 0;
        int transactionCount = 0;

        StringBuilder result = new StringBuilder("Original Balance: " + transactions[0]);

        for (int i = 1; i < transactions.length; i++) {
            transactionCount++;

            String[] transactionParts = transactions[i].split("[ ]+");
            double transactionAmount = Double.parseDouble(transactionParts[2]);

            currentBalance -= transactionAmount;
            totalExpense += transactionAmount;

            String formattedTransaction = String.format("\\r\\n%s %s %.2f Balance %.2f",
                    transactionParts[0], transactionParts[1], transactionAmount, currentBalance);

            result.append(formattedTransaction);
        }

        double averageExpense = (transactionCount == 0) ? 0 : totalExpense / transactionCount;

        result.append(String.format("\\r\\nTotal expense  %.2f\\r\\nAverage expense  %.2f", totalExpense, averageExpense));

        return result.toString();
    }

    public double f(double x) {
        return x / (Math.sqrt(1.0 + x) + 1.0);
    }

    public double mean(String town, String strng) {
        String[] townRecords = strng.split("\n");

        for (String record : townRecords) {
            if (record.startsWith(town + ":")) {

                String[] rainfallValues = record.replaceAll("[^0-9.,]+", "").split(",");
                double[] rainfallArray = Arrays.stream(rainfallValues).mapToDouble(Double::parseDouble).toArray();
                return Arrays.stream(rainfallArray).average().orElse(-1.0);
            }
        }

        return -1.0;
    }

    public double variance(String town, String strng) {
        String[] townRecords = strng.split("\n");

        for (String record : townRecords) {
            if (record.startsWith(town + ":")) {

                String[] rainfallValues = record.replaceAll("[^0-9.,]+", "").split(",");
                double[] rainfallArray = Arrays.stream(rainfallValues).mapToDouble(Double::parseDouble).toArray();
                double mean = Arrays.stream(rainfallArray).average().orElse(-1.0);
                return Arrays.stream(rainfallArray).map(x -> Math.pow(x - mean, 2)).average().orElse(-1.0);
            }
        }

        return -1.0;
    }

    public String nbaCup(String resultSheet, String toFind) {
        return null;
    }

    public String stockSummary(String[] lstOfArt, String[] lstOf1stLetter) {

        if (lstOfArt.length == 0 || lstOf1stLetter.length == 0) {
            return "";
        }

        Map<Character, Integer> categorySum = new HashMap<>();

        for (String book : lstOfArt) {
            char category = book.charAt(0);
            int quantity = Integer.parseInt(book.split(" ")[1]);

            categorySum.put(category, categorySum.getOrDefault(category, 0) + quantity);
        }

        StringBuilder result = new StringBuilder();

        for (String category : lstOf1stLetter) {
            char key = category.charAt(0);
            int sum = categorySum.getOrDefault(key, 0);
            result.append(String.format("(%s : %d) - ", category, sum));
        }

        return result.substring(0, result.length() - 3);
    }
}
