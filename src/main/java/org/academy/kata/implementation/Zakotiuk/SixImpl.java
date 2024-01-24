package org.academy.kata.implementation.Zakotiuk;

import org.academy.kata.Six;

public class SixImpl implements Six {
    public long findNb(long m) {
        long cube_counter = 1;
        long total = 0;

        while (total < m){
            total += cube_counter * cube_counter * cube_counter;
            cube_counter++;
        }

        if(total == m)
            return cube_counter-1;
        else
            return -1;
    }

    public String balance(String book) {
        return null;
    }

    public double f(double x) {
        double numerator = x;
        double denominator = Math.sqrt(1 + x) + 1;

        return numerator / denominator;
    }

    public double mean(String town, String strng) {

        String monthData = getMonthDataForTown(town, strng);

        if (monthData.isEmpty())
            return -1;

        String[] monthRecords = monthData.split(",");
        double sum = 0;
        int validRecordsCount = 0;

        for (String record : monthRecords) {
            String[] tempData = record.split(" ");
            if (tempData.length >= 2) {
                String temp = tempData[1];
                sum += Double.parseDouble(temp);
                validRecordsCount++;
            }
        }

        if (validRecordsCount == 0)
            return -1;

        return sum / validRecordsCount;
    }

    public double variance(String town, String strng) {
        double mean = mean(town, strng);

        if (mean == -1) {
            return -1;
        }

        String monthData = getMonthDataForTown(town, strng);

        if (monthData.isEmpty())
            return -1;

        String[] monthRecords = monthData.split(",");
        double counting = 0.0;
        int validRecordsCount = 0;

        for (String record : monthRecords) {
            String[] tempData = record.split(" ");
            if (tempData.length >= 2) {
                String temp = tempData[1];
                double tempdb = Double.parseDouble(temp) - mean;
                counting += tempdb * tempdb;
                validRecordsCount++;
            }
        }

        if (validRecordsCount == 0)
            return -1;

        return counting / validRecordsCount;
    }
    private String getMonthDataForTown(String town, String strng) {
        String[] citiesData = strng.split("\\n");
        String monthData = "";

        for (String cityData : citiesData) {
            String[] parts = cityData.split(":");

            if (parts[0].equals(town)) {
                monthData = parts[1];
                break;
            }
        }

        return monthData;
    }

    public String nbaCup(String resultSheet, String toFind) {
        return null;
    }

    public String stockSummary(String[] lstOfArt, String[] lstOf1stLetter) {
        return null;
    }
}
