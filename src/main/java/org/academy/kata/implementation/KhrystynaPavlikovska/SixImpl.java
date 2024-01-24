package org.academy.kata.implementation.KhrystynaPavlikovska;

import org.academy.kata.Six;

public class SixImpl implements Six {
    public long findNb(long m) {
        return 0;
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
