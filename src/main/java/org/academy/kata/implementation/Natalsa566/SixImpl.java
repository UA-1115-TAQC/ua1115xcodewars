package org.academy.kata.implementation.Natalsa566;

import org.academy.kata.Base;
import org.academy.kata.Six;

import java.util.Arrays;
import java.util.stream.Stream;
import java.util.HashMap;
import java.util.Map;

public class SixImpl extends Base implements Six {

    public long findNb(long m) {
        long n = (long) Math.sqrt(2 * Math.sqrt(m));
        if (n * (n + 1) / 2 * n * (n + 1) / 2 == m) {
            return n;
        } else {
            return -1;
        }
    }
  
    public String balance(String book) {
        String t = book.replaceAll("([^\\n. \\da-zA-Z])", "");
        String[] arr = t.split("[\\n]+");
        double current = Double.parseDouble(arr[0]);
        double total = 0;
        int count = 0;
        StringBuilder result = new StringBuilder();
        result.append("Original Balance: " + arr[0]);
        for (int i = 1; i < arr.length; i++) {
            count++;
            String[] line = arr[i].split("[ ]+");
            current -= Double.parseDouble(line[2]);
            total += Double.parseDouble(line[2]);
            String u = String.format("\\r\\n%s %s %s Balance %.2f", line[0], line[1], line[2], current);
            result.append(u);
        }
        result.append(String.format("\\r\\nTotal expense  %.2f\\r\\nAverage expense  %.2f", total, total / count));
        return result.toString();
    }

    public double f(double x) {
        return x / 2.0 - x * x / 8.0 + x * x * x / 16.0 - 5.0 * x * x * x * x / 128.0;
    }

    public double mean(String town, String strng) {
        String[] townRecords = getTownRecords(town, strng);
        if (townRecords.length == 0) {
            return -1.0;
        }
        double[] rainfallValues;
        try {
            rainfallValues = Arrays.stream(townRecords)
                    .map(record -> Double.parseDouble(record.split(" ")[1]))
                    .mapToDouble(Double::doubleValue)
                    .toArray();
        } catch (NumberFormatException e) {
            return Double.NaN;
        }
        return Arrays.stream(rainfallValues).average().orElse(Double.NaN);
    }

    public double variance(String town, String strng) {
        String[] townRecords = getTownRecords(town, strng);
        if (townRecords.length == 0) {
            return -1.0;
        }
        double mean = mean(town, strng);
        double[] squaredDifferences;
        try {
            squaredDifferences = Arrays.stream(townRecords)
                    .map(record -> {
                        double rainfall = Double.parseDouble(record.split(" ")[1]);
                        return Math.pow(rainfall - mean, 2);
                    })
                    .mapToDouble(Double::doubleValue)
                    .toArray();
        } catch (NumberFormatException e) {
            return Double.NaN;
        }
        return Arrays.stream(squaredDifferences).average().orElse(Double.NaN);
    }
    private static String[] getTownRecords(String town, String strng) {
        return Stream.of(strng.split("\n"))
                .filter(record -> record.startsWith(town + ":"))
                .findFirst()
                .map(record -> record.substring(record.indexOf(":") + 1).split(","))
                .orElse(new String[0]);
    }

    public String nbaCup(String resultSheet, String toFind) {
        if (toFind.equals(""))
            return "";
        int countTeamname = toFind.split(" ").length;
        String[] split = resultSheet.split(",");
        int points = 0;
        int won = 0;
        int draw = 0;
        int lost = 0;
        int scored = 0;
        int conceded = 0;
        for (String temp : split) {
            int ownPoints = 0;
            int oppPoints = 0;
            boolean teamFound = false;
            String[] parts = temp.split(" ");
            if (countTeamname == 2) {
                teamFound = (parts[0].equals(toFind.split(" ")[0]) && parts[1].equals(toFind.split(" ")[1]))
                        || (parts[parts.length - 3].equals(toFind.split(" ")[0])
                        && parts[parts.length - 2].equals(toFind.split(" ")[1]));
            } else {
                teamFound = (parts[0].equals(toFind.split(" ")[0]) && parts[1].equals(toFind.split(" ")[1])
                        && parts[2].equals(toFind.split(" ")[2]))
                        || (parts[parts.length - 4].equals(toFind.split(" ")[0])
                        && parts[parts.length - 3].equals(toFind.split(" ")[1])
                        && parts[parts.length - 2].equals(toFind.split(" ")[2]));
            }

            if (teamFound) {
                try {
                    if (toFind.split(" ")[0].equals(parts[0])) {
                        if (toFind.split(" ").length == 2) {
                            ownPoints = Integer.parseInt(parts[2]);
                        } else {
                            ownPoints = Integer.parseInt(parts[3]);
                        }
                        oppPoints = Integer.parseInt(parts[parts.length - 1]);
                    } else {
                        if (toFind.split(" ").length == 2) {
                            oppPoints = Integer.parseInt(parts[parts.length - 4]);
                        } else {
                            oppPoints = Integer.parseInt(parts[parts.length - 5]);
                        }
                        ownPoints = Integer.parseInt(parts[parts.length - 1]);
                    }
                } catch (NumberFormatException e) {
                    return "Error(float number):" + temp;
                }
                scored += ownPoints;
                conceded += oppPoints;
                if (ownPoints > oppPoints) {
                    points += 3;
                    won++;
                } else if (ownPoints == oppPoints) {
                    points += 1;
                    draw++;
                } else {
                    lost++;
                }
            }
        }
        if (won == 0 && draw == 0 && lost == 0) {
        return toFind + ":This team didn't play!";
    } else {
        return toFind + ":W=" + won + ";D=" + draw + ";L=" + lost + ";Scored=" + scored + ";Conceded=" + conceded
                + ";Points=" + points;
    }
}

public String stockSummary(String[] lstOfArt, String[] lstOf1stLetter) {
        if (lstOfArt.length == 0 || lstOf1stLetter.length == 0) {
            return "";
        }
        Map<String, Integer> categorySumMap = new HashMap<>();
        for (String art : lstOfArt) {
            String[] parts = art.split(" ");
            String category = parts[0].substring(0, 1);

            if (categorySumMap.containsKey(category)) {
                categorySumMap.put(category, categorySumMap.get(category) + Integer.parseInt(parts[1]));
            } else {
                categorySumMap.put(category, Integer.parseInt(parts[1]));
            }
        }
        StringBuilder result = new StringBuilder();
        for (String letter : lstOf1stLetter) {
            int sum = categorySumMap.getOrDefault(letter, 0);
            result.append("(").append(letter).append(" : ").append(sum).append(") - ");
        }
        result.setLength(result.length() - 3);

        return result.toString();
    }
}
