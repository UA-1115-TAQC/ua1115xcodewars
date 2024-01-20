package org.academy.kata.implementation.Julyuk;

import org.academy.kata.Six;

public class SixImpl implements Six {
    public long findNb(long m) {
        return 0;
    }

    public String balance(String book) {
        return null;
    }

    public double f(double x) {
        return 0;
    }

    public double mean(String town, String strng) {
        if (!town.isEmpty() && !strng.isEmpty()) {
            String[] townRecords = strng.split("\n");

            for (String townRecord : townRecords) {
                if (townRecord.startsWith(town + ":")) {
                    String[] months = townRecord.split(":")[1].trim().split(","); //start working with the part after :
                    double sum = 0;
                    int count = 0;

                    for (String month : months) {
                        String[] monthData = month.trim().split("\\s+");
                        if (monthData.length == 2) {
                            sum += Double.parseDouble(monthData[1]);
                            count++;
                        }
                    }

                    if (count > 0) {
                        return sum / count;
                    } else {
                        return -1.0;
                    }
                }
            }

            return -1.0;
        }

        throw new IllegalArgumentException("Invalid input");
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
