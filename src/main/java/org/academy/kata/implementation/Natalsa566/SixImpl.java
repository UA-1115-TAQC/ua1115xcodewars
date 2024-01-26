package org.academy.kata.implementation.Natalsa566;

import org.academy.kata.Six;

public class SixImpl implements Six {

    public long findNb(long m) {
        long n = (long) Math.sqrt(2 * Math.sqrt(m));
        if (n * (n + 1) / 2 * n * (n + 1) / 2 == m) {
            return n;
        } else {
            return -1;
        }
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
        return null;
    }
}
