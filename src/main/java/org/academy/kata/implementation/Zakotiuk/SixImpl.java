package org.academy.kata.implementation.Zakotiuk;

import org.academy.kata.Six;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class SixImpl implements Six {
    public long findNb(long m) {
        long cube_counter = 1;
        long total = 0;

        while (total < m) {
            total += cube_counter * cube_counter * cube_counter;
            cube_counter++;
        }

        if (total == m) return cube_counter - 1;
        else return -1;
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

        if (monthData.isEmpty()) return -1;

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

        if (validRecordsCount == 0) return -1;

        return sum / validRecordsCount;
    }

    public double variance(String town, String strng) {
        double mean = mean(town, strng);

        if (mean == -1) {
            return -1;
        }

        String monthData = getMonthDataForTown(town, strng);

        if (monthData.isEmpty()) return -1;

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

        if (validRecordsCount == 0) return -1;

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
        if (toFind.isEmpty()) return "";
        String[] teams = new String[]{"Los Angeles Clippers", "Dallas Mavericks", "New York Knicks", "Atlanta Hawks", "Indiana Pacers", "Memphis Grizzlies", "Los Angeles Lakers", "Minnesota Timberwolves", "Phoenix Suns", "Portland Trail Blazers", "New Orleans Pelicans", "Sacramento Kings", "Los Angeles Clippers", "Houston Rockets", "Denver Nuggets", "Cleveland Cavaliers", "Milwaukee Bucks", "Oklahoma City Thunder", "San Antonio Spurs", "Boston Celtics", "Philadelphia 76ers", "Brooklyn Nets", "Chicago Bulls", "Detroit Pistons", "Utah Jazz", "Miami Heat", "Charlotte Hornets", "Toronto Raptors", "Orlando Magic", "Washington Wizards", "Golden State Warriors"};

        if (!Arrays.asList(teams).contains(toFind)) return toFind + ":This team didn't play!";

        String[] pairs = resultSheet.split(",");
        int wins = 0, draws = 0, loses = 0, scored = 0, conceded = 0, points = 0;

        for (String line : pairs) {
            if (line.contains(".")) return "Error(float number):" + line;

            if (line.contains(toFind)) {
                int first = Integer.parseInt(line.substring(0, line.length() - 10).replaceAll("[\\D]", ""));

                StringBuilder stringBuilder = new StringBuilder();
                String reversed = new StringBuilder(line).reverse().toString();

                for (int i = 0; i < reversed.length(); i++) {
                    if (Character.isDigit(reversed.charAt(i))) {
                        stringBuilder.insert(i, reversed.charAt(i));
                    } else break;
                }

                int second = Integer.parseInt(stringBuilder.reverse().toString());

                if (line.contains(toFind + " " + first)) {
                    scored += first;
                    conceded += second;
                    if (first > second) {
                        points += 3;
                        wins++;
                    }
                    if (first == second) {
                        points += 1;
                        draws++;
                    }
                    if (first < second) {
                        loses++;
                    }
                }
                if (line.contains(toFind + " " + second)) {
                    scored += second;
                    conceded += first;
                    if (second > first) {
                        points += 3;
                        wins++;
                    }
                    if (first == second) {
                        points += 1;
                        draws++;
                    }
                    if (second < first) {
                        loses++;
                    }
                }
            }
        }

        return String.format("%s:W=%d;D=%d;L=%d;Scored=%d;Conceded=%d;Points=%d", toFind, wins, draws, loses, scored, conceded, points);
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
                    else categoryCounts.put(letter, count);
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
