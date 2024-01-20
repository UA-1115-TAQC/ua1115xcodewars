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
            double sum = 0;
            int count = 0;

            String[] monthData = monthsValues(town, strng);

            for (String monthDatum : monthData) {
                sum += Double.parseDouble(monthDatum);
                count++;
            }

            if (count > 0) {
                return sum / count;
            } else {
                return -1.0;
            }
        }

        throw new IllegalArgumentException("Invalid input");
    }

    public double variance(String town, String strng) {
        if (!town.isEmpty() && !strng.isEmpty()) {
            String[] monthData = monthsValues(town, strng);
            double mean = mean(town, strng);
            double countOfObserv = 0;
            double squaresSum = 0;

            for (String monthDatum : monthData) {
                if (!monthDatum.isEmpty()) {
                    squaresSum += Math.pow((Double.parseDouble(monthDatum) - mean),2);
                    countOfObserv++;
                }
            }

            if (countOfObserv - 1 > 0) {
                return squaresSum / (monthData.length);
            } else {
                return -1.0;
            }
        }

        throw new IllegalArgumentException("Invalid input");
    }

    private static String[] monthsValues(String town, String strng) {
        String[] townRecords = strng.split("\n");
        for (String townRecord : townRecords) {
            if (townRecord.startsWith(town + ":")) {
                String[] months = townRecord.split(":")[1].trim().split(",");
                String[] monthData = new String[months.length];

                for (int i = 0; i < months.length; i++) {
                    monthData[i] = months[i].trim().split("\\s+")[1];
                }

                return monthData;
            }
        }

        return new String[0];
    }

    public String nbaCup(String resultSheet, String toFind) {
        return null;
    }

    public String stockSummary(String[] lstOfArt, String[] lstOf1stLetter) {
        return null;
    }
}
