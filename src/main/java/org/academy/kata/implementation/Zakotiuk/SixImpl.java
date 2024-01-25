package org.academy.kata.implementation.Zakotiuk;

import org.academy.kata.Six;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

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
        String temp = book.replaceAll("([^\\n. \\da-zA-Z])", "");
        String[] arr = temp.split("[\\n]+");

        double total = 0;
        int count = 0;
        double current = Double.parseDouble(arr[0]);

        StringBuilder result = new StringBuilder();
        result.append("Original Balance: ").append(arr[0]);

        for (int i = 1; i < arr.length; i++) {
            count++;
            String[] line = arr[i].split("[ ]+");
            current -= Double.parseDouble(line[2]);
            total += Double.parseDouble(line[2]);

            String item = String.format("\\r\\n%s %s %s Balance %.2f", line[0], line[1], line[2], current);
            result.append(item);
        }

        result.append(String.format("\\r\\nTotal expense  %.2f\\r\\nAverage expense  %.2f", total, total / count));
        return result.toString();
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

        if (lstOfArt.length == 0 || lstOf1stLetter.length == 0) {
            return "";
        }

        Map<Character, Integer> categoryCounts = new HashMap<>();

        for (String s : lstOfArt) {
            String[] letter_count = s.split(" ");

            char letter = letter_count[0].toCharArray()[0];
            int count = Integer.parseInt(letter_count[1]);

            for (String item : lstOf1stLetter) {
                if (Objects.equals(item, "" + letter)) {
                    if (categoryCounts.containsKey(letter))
                        categoryCounts.put(letter, categoryCounts.get(letter) + count);
                    else
                        categoryCounts.put(letter, count);
                }
            }
        }

        StringBuilder result = new StringBuilder();
        for (String letter : lstOf1stLetter) {
            char category = letter.charAt(0);
            int count = categoryCounts.getOrDefault(category, 0);
            result.append("(").append(category).append(" : ").append(count).append(") - ");
        }
        result.delete(result.length() - 3, result.length());

        return result.toString();
    }
}
