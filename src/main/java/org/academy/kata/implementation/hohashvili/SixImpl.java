package org.academy.kata.implementation.hohashvili;

import org.academy.kata.Six;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class SixImpl implements Six {
    public long findNb(long m) {
        return 0;
    }

    public String balance(String book) {
        String[] origSplit = book.split("\\n+");
        String result = "";
        int counter = 0;
        double origBalance = 0;
        double totalExpense = 0;
        for(String line:origSplit) {
            if (counter == 0) {
                origBalance = Double.parseDouble(line);
                result += "Original_Balance:_" + line + "\n";
            } else {
                String[] itemSplit = line.split(" ");
                List<String> newItem = new ArrayList<>(Arrays.asList(itemSplit));
                newItem.add(2, "Balance");
                totalExpense += Double.parseDouble(newItem.get(3));
                newItem.set(3, String.valueOf(origBalance-totalExpense));

                String newItemString = String.join("_", newItem) + '\n';
                result += newItemString;
            }
            counter++;
        }
        result += "Total_expense__" + String.format(Locale.US,"%.2f",totalExpense) + '\n';
        result += "Average_expense__" + String.format(Locale.US,"%.2f",totalExpense/(counter-1)) + '\n';
        return result;
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
