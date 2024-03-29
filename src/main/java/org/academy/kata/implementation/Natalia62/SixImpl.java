package org.academy.kata.implementation.Natalia62;

import org.academy.kata.Six;
import java.util.*;


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
        double[] v = doubAr(town, strng);
        if(v == null) return -1;
        double sum = 0;
        for(int i = 0; i < v.length; i++) sum += v[i];
        return sum / v.length;
    }

    public double variance(String town, String strng) {
        double[] v = doubAr(town, strng);
        if(v == null) return -1;
        double mean = mean(town, strng);
        double temp = 0;
        for(double a : v)  temp += (mean - a) * (mean - a);
        return temp / v.length;
    }

    private static double[] doubAr(String town, String strng) {
        String[] s = strng.split("\n");
        for (int i = 0; i < s.length; i++) {
            if (s[i].split(":")[0].equals(town)) {
                String[] nm = s[i].split(":")[1].split(",");
                double[] v = new double[nm.length];
                for (int i2 = 0; i2 < nm.length; i2++) {
                    String[] parts = nm[i2].split(" ");
                    if (parts.length == 2) v[i2] = Double.parseDouble(parts[1]);
                }
                return v;
            }
        }
        return null;
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
                if (matcher.find()) {
                    String firstScore, secondScore;
                    firstScore = (matcher.group(1).equals(toFind)) ? matcher.group(2) : matcher.group(4);
                    secondScore = (matcher.group(1).equals(toFind)) ? matcher.group(4) : matcher.group(2);
                    int firstScoreInt = Integer.parseInt(firstScore);
                    int secondScoreInt = Integer.parseInt(secondScore);
                    scored += firstScoreInt;
                    conceded += secondScoreInt;
                    w += (firstScoreInt > secondScoreInt) ? 1 : 0;
                    d += (firstScoreInt == secondScoreInt) ? 1 : 0;
                    l += (firstScoreInt < secondScoreInt) ? 1 : 0;
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
