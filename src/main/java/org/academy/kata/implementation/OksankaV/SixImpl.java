package org.academy.kata.implementation.OksankaV;

import org.academy.kata.Six;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SixImpl implements Six {
    public long findNb(long m) {
        long n = 0;
        while (m > 0) {
            n++;
            m -= n * n * n;
        }
        return (m == 0) ? n : -1;
    }

    public String balance(String book) {
        String[] rows = book.split("\n");
        Pattern patternBalance = Pattern.compile("^(\\d+\\.\\d{2}).*$");
        Matcher matcherBalance = patternBalance.matcher(rows[0]);
        float balance = 0;
        if (matcherBalance.find()) {
            balance = Float.parseFloat(matcherBalance.group(1));
        }
        String resultStr = "Original Balance: " + String.format("%.02f", balance) + "\\r\\n";
        float totalExpense = 0;
        Pattern pattern = Pattern.compile("^(\\d+)\\s+(\\w+)\\S*\\s+\\D*(\\d+\\.\\d{2})\\D*$");
        float diff = balance;
        for (int i = 1; i < rows.length; i++) {
            Matcher matcher = pattern.matcher(rows[i]);
            float price = 0;
            if (matcher.find()) {
                price = Float.parseFloat(matcher.group(3));
                diff = diff - price;
                totalExpense += price;
                resultStr += matcher.group(1) + " " + matcher.group(2) + " " + String.format("%.02f", price);
                resultStr += " Balance " + String.format("%.02f", diff) + "\\r\\n";
            }
        }
        resultStr += "Total expense  " + String.format("%.02f", totalExpense);
        resultStr += "\\r\\nAverage expense  " + String.format("%.02f", ((double) (Math.round(totalExpense / (rows.length - 1) * 100)) / 100));

        return resultStr;
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
