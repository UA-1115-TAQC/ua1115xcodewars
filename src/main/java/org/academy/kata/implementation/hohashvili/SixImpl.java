package org.academy.kata.implementation.hohashvili;

import org.academy.kata.Six;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.HashMap;
import java.util.Map;


public class SixImpl implements Six {
    public long findNb(long m) {
        int i = 1;
        while (m > 0) {
            m -= (long) Math.pow(i, 3);
            i++;
        }
        if (m == 0) {
            return i-1;
        }
        return -1;
    }

    public String balance(String book) {
        String[] origSplit = book.split("\\n+");
        String result = "";
        int counter = 0;
        double origBalance = 0;
        double totalExpense = 0;
        for(String line:origSplit) {
            line = line.replaceAll("[^0-9a-zA-Z.]", " ");
            line = line.replaceAll("\\s+", " ");

            if (counter == 0) {
                origBalance = Double.parseDouble(line);
                result += "Original Balance: " + line.trim() + "\\r" + "\n";
            } else {
                String[] itemSplit = line.split(" ");
                List<String> newItem = new ArrayList<>(Arrays.asList(itemSplit));
                List<String> resultItem = new ArrayList<String>();
                resultItem.add(0, newItem.get(0) );
                resultItem.add(1, newItem.get(1) );

                resultItem.add(2, newItem.get(2));
                resultItem.add(3, "Balance");
                totalExpense += Double.parseDouble(newItem.get(2));

                DecimalFormat decimalFormatDouble = new DecimalFormat("0.00");
                String formattedNumber = decimalFormatDouble.format(origBalance-totalExpense);

                resultItem.add(4, formattedNumber);

                String newItemString = String.join(" ", resultItem) + "\\r" + "\n";
                result += newItemString;

            }
            counter++;
        }
        result += "Total expense  " + String.format(Locale.US,"%.2f",totalExpense) + "\\r" + '\n';
        result += "Average expense  " + String.format(Locale.US,"%.2f",totalExpense/(counter-1));
        return result;
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
    public static boolean isNumeric(String str) {
        try {
            // Attempt to parse the string as an integer
            Integer.parseInt(str);
            return true; // If successful, the string is numeric
        } catch (NumberFormatException e) {
            return false; // If an exception occurs, the string is not numeric
        }
    }
    public String nbaCup(String resultSheet, String toFind) {
        if (toFind.equals("")) return "";
        String[] teams = new String[]{"Los Angeles Clippers", "Dallas Mavericks", "New York Knicks", "Atlanta Hawks", "Indiana Pacers", "Memphis Grizzlies",
                "Los Angeles Lakers", "Minnesota Timberwolves", "Phoenix Suns", "Portland Trail Blazers", "New Orleans Pelicans",
                "Sacramento Kings", "Los Angeles Clippers", "Houston Rockets", "Denver Nuggets", "Cleveland Cavaliers", "Milwaukee Bucks",
                "Oklahoma City Thunder", "San Antonio Spurs", "Boston Celtics", "Philadelphia 76ers", "Brooklyn Nets", "Chicago Bulls",
                "Detroit Pistons", "Utah Jazz", "Miami Heat", "Charlotte Hornets", "Toronto Raptors", "Orlando Magic", "Washington Wizards",
                "Golden State Warriors"};

        if (!Arrays.asList(teams).contains(toFind)) return toFind + ":This team didn't play!";

        String[] pairs = resultSheet.split(",");
        int wins = 0;
        int draws = 0;
        int loses = 0;
        int scored = 0;
        int conceded = 0;
        int points = 0;
        for (String s : pairs) {
            if (s.contains(".")) return "Error(float number):" + s;
            if (s.contains(toFind)) {
                int first = Integer.parseInt(s.substring(0, s.length() - 10).replaceAll("[\\D]", ""));
                String reversed = new StringBuilder(s).reverse().toString();
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < reversed.length(); i++) {
                    if (Character.isDigit(reversed.charAt(i))) {
                        sb.insert(i, reversed.charAt(i));
                    } else {
                        break;
                    }
                }
                int second = Integer.parseInt(sb.reverse().toString());

                if (s.contains(toFind + " " + first)) {
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
                if (s.contains(toFind + " " + second)) {
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
        return toFind + ":W=" + wins + ";D=" + draws + ";L=" + loses + ";Scored=" + scored + ";Conceded=" + conceded + ";Points=" + points;
    }

    public String stockSummary(String[] lstOfArt, String[] lstOf1stLetter) {
        Map<String, Integer> result = new HashMap<>();
        for(String val: lstOf1stLetter) {
            result.put(val, 0 );
            for (String stock: lstOfArt) {

                if (String.valueOf(stock.charAt(0)).equals(val)) {
                    String[] splitStock = stock.split(" ");
                    int stockValue = Integer.parseInt(splitStock[1]);
                    result.put(val, result.get(val) + stockValue );
                }
            }
        }

        String formattedResult = "";
        // Format
        for (String key: result.keySet()) {
            String val = "(" + key + " : " + result.get(key) + ") - ";
            formattedResult += val;
        }

        return formattedResult.substring(0,formattedResult.length()-3);
    }
}
