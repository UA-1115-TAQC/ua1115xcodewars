package org.academy.kata.implementation.hohashvili;

import org.academy.kata.Six;

public class SixImpl implements Six {
    public long findNb(long m) {
        return 0;
    }

    public String balance(String book) {
        return null;
    }

    public double f(double x) {
        return x / (Math.sqrt(1 + x) + 1);
    }

    public static Double[] findTown(String town, String strng) {
        String[] splitData = strng.split("\n");
        String[] monthData = {}; // month-value pairs
        for(String line :splitData) {
            String newLine = "";
            if (line.contains(town)) {
                newLine = line.substring(town.length()+1, line.length()-1);
                monthData = newLine.split(",");
                break;
            }
        }
        if (monthData.length == 0) {
            return null;
        }
        Double[] resultValues = new Double[12];
        int counter = 0;
        for (String val : monthData) {
            resultValues[counter] = Double.parseDouble(val.split(" ")[1]);
            counter++;
        }
        return resultValues;
    }

    public double mean(String town, String strng) {
        Double[] metrics = findTown(town, strng);
        Double sum = 0.0;

        if (metrics!= null) {
            for (Double d:metrics) {
                sum += d;
            }
            return sum/metrics.length;
        }
        return -1.0;
    }

    public double variance(String town, String strng) {
        Double[] metrics = findTown(town, strng);
        Double mean = this.mean(town, strng);
        if (metrics!= null) {
            double sumSquaredDiff = 0.0;
            for (double value : metrics) {
                double diff = value - mean;
                sumSquaredDiff += diff * diff;
            }
            return sumSquaredDiff / metrics.length;
        }
        return -1.0;
    }

    public String nbaCup(String resultSheet, String toFind) {
        return null;
    }

    public String stockSummary(String[] lstOfArt, String[] lstOf1stLetter) {
        return null;
    }
}
