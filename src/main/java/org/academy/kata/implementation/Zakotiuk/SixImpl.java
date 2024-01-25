package org.academy.kata.implementation.Zakotiuk;

import org.academy.kata.Six;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        if (toFind.isEmpty()) return "";

        Set<String> teams = new HashSet<>(Arrays.asList(
                "Los Angeles Clippers", "Dallas Mavericks", "New York Knicks", "Atlanta Hawks", "Indiana Pacers", "Memphis Grizzlies",
                "Los Angeles Lakers", "Minnesota Timberwolves", "Phoenix Suns", "Portland Trail Blazers", "New Orleans Pelicans",
                "Sacramento Kings", "Los Angeles Clippers", "Houston Rockets", "Denver Nuggets", "Cleveland Cavaliers", "Milwaukee Bucks",
                "Oklahoma City Thunder", "San Antonio Spurs", "Boston Celtics", "Philadelphia 76ers", "Brooklyn Nets", "Chicago Bulls",
                "Detroit Pistons", "Utah Jazz", "Miami Heat", "Charlotte Hornets", "Toronto Raptors", "Orlando Magic", "Washington Wizards",
                "Golden State Warriors"));

        if (!teams.contains(toFind)) return toFind + ":This team didn't play!";

        int wins = 0, draws = 0, loses = 0, scored = 0, conceded = 0, points = 0;
        Matcher m = Pattern.compile("([\\w ]+) (\\d+) ([\\w ]+) (\\d+)").matcher(resultSheet);

        while (m.find()) {
            if (m.group().contains(".")) return "Error(float number):" + m.group();

            String team1 = m.group(1);
            String team2 = m.group(3);
            int score1 = Integer.parseInt(m.group(2));
            int score2 = Integer.parseInt(m.group(4));
            if (team1.equals(toFind) || team2.equals(toFind)) {
                boolean isTeam1 = team1.equals(toFind);
                scored += isTeam1 ? score1 : score2;
                conceded += isTeam1 ? score2 : score1;

                int result = Integer.compare(isTeam1 ? score1 : score2, isTeam1 ? score2 : score1);
                if (result > 0) {
                    points += 3;
                    wins++;
                } else if (result == 0) {
                    points += 1;
                    draws++;
                } else {
                    loses++;
                }
            }
        }

        return String.format("%s:W=%d;D=%d;L=%d;Scored=%d;Conceded=%d;Points=%d",
                toFind, wins, draws, loses, scored, conceded, points);
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
