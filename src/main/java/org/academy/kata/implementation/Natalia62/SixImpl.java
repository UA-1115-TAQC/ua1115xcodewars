package org.academy.kata.implementation.Natalia62;

import org.academy.kata.Six;
import java.util.*;

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
        if(!strng.contains(town+":")) return -1;
        double[] v = doubAr(town, strng);
        double sum = 0;
        for(int i=0; i<v.length; i++) sum += v[i];
        return sum/v.length;
    }

    public double variance(String town, String strng) {
        if(!strng.contains(town+":")) return -1;
        double[] v = doubAr(town, strng);
        double mean = mean(town, strng);
        double temp = 0;
        for(double a :v)  temp += (mean-a)*(mean-a);
        return temp/v.length;
    }

    private static double[] doubAr(String town, String strng) {
        String[] s = strng.split("\n");
        for(int i=0; i<s.length; i++)
            if(s[i].split(":")[0].equals(town)) {
                String[] nm = s[i].split(":")[1].split(",");
                double[] v = new double[nm.length];
                for(int i2=0; i2<nm.length; i2++)
                    v[i2] = Double.parseDouble(nm[i2].split(" ")[1]);
                return v;
            }
        return null;
    }

    public String nbaCup(String resultSheet, String toFind) {
        return null;
    }

    public String stockSummary(String[] lstOfArt, String[] lstOf1stLetter) {
        return null;
    }
}
