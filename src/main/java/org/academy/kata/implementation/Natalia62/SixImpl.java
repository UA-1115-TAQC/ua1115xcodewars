package org.academy.kata.implementation.Natalia62;

import org.academy.kata.Six;

public class SixImpl implements Six {
    public long findNb(long m) {
        long sum = 0;
        long n = 1;
        while (sum <= m) {
            sum += (long) Math.pow(n, 3);
            if (sum == m) return n;
            n++;
        }
        return -1;
    }

    public String balance(String book) {
        StringBuilder result = new StringBuilder();
        String[] splittedBook = book.replaceAll("[^a-zA-Z0-9 \\n.]","").replaceAll(" {2,}", " ").split("\n");
        double balance = Double.parseDouble(splittedBook[0]);
        double expense = 0;
        result.append("Original Balance: ").append(String.format("%1$.2f", balance)).append("\\r\\n");
        for(int i = 1; i < splittedBook.length; i++) {
            String[] splittedItem = splittedBook[i].split(" ");
            double itemExpense = Double.parseDouble(splittedItem[splittedItem.length - 1]);
            balance -= itemExpense;
            expense += itemExpense;
            result.append(splittedBook[i].trim()).append(" Balance ").append(String.format("%1$.2f", balance)).append("\\r\\n");
        }
        result.append("Total expense  ").append(String.format("%1$.2f", expense)).append("\\r\\n");
        result.append("Average expense  ").append(String.format("%1$.2f", expense / (splittedBook.length - 1)));

        return result.toString();
    }

    public double f(double x) {
        return x / (Math.sqrt(1 + x) + 1.0);
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
        if (lstOfArt.length == 0 || lstOf1stLetter.length == 0) return "";
        StringBuilder result = new StringBuilder();
        int counter = 0;
        String items;
        for (int i = 0; i < lstOf1stLetter.length; i++) {
            items = lstOf1stLetter[i];
            for (String stock : lstOfArt) {
                if (stock.substring(0, 1).equals(items)) {
                    counter += Integer.parseInt(stock.replaceAll("\\D", ""));
                }
            }
            result.append(i != lstOf1stLetter.length - 1 ? String.format("(%s : %d) - ", items, counter) : String.format("(%s : %d)", items, counter));
            counter = 0;
        }
        return result.toString();
    }
}
