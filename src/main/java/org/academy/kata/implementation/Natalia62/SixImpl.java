package org.academy.kata.implementation.Natalia62;

import org.academy.kata.Six;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        if (toFind.isEmpty()) return "";
        if(!resultSheet.contains(toFind + " ")) return toFind + ":This team didn't play!";

        String[] nba = resultSheet.split(",");
        Pattern pattern = Pattern.compile("(.+)\\s+(\\d+\\.?\\d*)\\s+(.+)\\s+(\\d+\\.?\\d*)");
        int w = 0;
        int d = 0;
        int l = 0;
        int scored = 0;
        int conceded = 0;
        for (String value : nba) {
            if (value.contains(toFind)) {
                Matcher matcher = pattern.matcher(value);
                String firstScore = "";
                String secondScore = "";
                if (matcher.find()) {
                    if (matcher.group(2).contains(".") || matcher.group(4).contains(".") )
                        return "Error(float number):" + value;
                    if (matcher.group(1).equals(toFind)) {
                        firstScore = matcher.group(2);
                        secondScore = matcher.group(4);
                    } else {
                        firstScore = matcher.group(4);
                        secondScore = matcher.group(2);
                    }

                    int firstScoreInt = Integer.parseInt(firstScore);
                    int secondScoreInt = Integer.parseInt(secondScore);
                    scored += firstScoreInt;
                    conceded += secondScoreInt;

                    if (firstScoreInt > secondScoreInt) w++;
                    else if (firstScoreInt == secondScoreInt) d++;
                    else l++;
                }
            }
        }
        int points = w * 3 + d;
        return toFind + ":W=" + w + ";D=" + d + ";L=" + l + ";Scored=" + scored + ";Conceded=" + conceded + ";Points=" + points;
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
